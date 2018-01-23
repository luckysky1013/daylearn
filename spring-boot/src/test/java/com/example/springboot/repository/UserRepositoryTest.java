package com.example.springboot.repository;

import java.text.DateFormat;
import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.springboot.dao.UserRepository;
import com.example.springboot.domain.User;

/**
 * @author liujian
 * @date 2018/1/16
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void test(){
        Date date=new Date();

        userRepository.save(new User("aa1", "aa@126.com", "aa", "aa123456",date));
        userRepository.save(new User("bb2", "bb@126.com", "bb", "bb123456",date));
        userRepository.save(new User("cc3", "cc@126.com", "cc", "cc123456",date));

        Assert.assertEquals(9,userRepository.findAll().size());
        //Assert.assertEquals("bb", userRepository.findByUserNameOrEmail("cc", "cc@126.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
