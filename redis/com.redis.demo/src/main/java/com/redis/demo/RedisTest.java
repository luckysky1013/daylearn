package com.redis.demo;

import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.Jedis;

public class RedisTest {
	private Jedis jedis;
	@Before
	public void init(){
		jedis=RedisConnection.getInstance();
	}
	@Test
	public void test1Normal(){
		long start=System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			String result=jedis.set("name"+i, "baobao"+i);
			//System.out.println(result);
		}
		long end =System.currentTimeMillis();
		System.out.println("Simple set:"+(end-start)/1000.0+"seconds");
		jedis.disconnect();
	}
}
