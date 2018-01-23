package com.springboot.redis;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.redis.domain.User;


/**
 * @author liujian
 * @date 2018/1/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class TestRedis {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;


    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("aaa","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws InterruptedException {
        User user=new User("aa1", "aa@126.com", "aa", "aa123456",new Date());
        ValueOperations<String,User> operations=redisTemplate.opsForValue();
        operations.set("com.asq",user);
        operations.set("com.asq.l",user,1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        boolean exsits=redisTemplate.hasKey("com.asq");
        if(exsits){
            User user1= (User) redisTemplate.opsForValue().get("com.asq");
            System.out.println(user1.toString());
        }
        Assert.assertEquals("aa1",operations.get("com.asq").getUserName());

    }
}
