package com.redis.demo;

import redis.clients.jedis.Jedis;

public class RedisStringTest {
	private static Jedis jedis;
	
	public static void main(String[] args) {
		jedis=RedisConnection.getInstance();
		String result=jedis.set("name", "qinbaobao");
		System.out.println("存储的数据为"+jedis.get("name"));
		System.out.println(result);
		
		
	}
}
