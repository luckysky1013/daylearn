package com.redis.demo;

import redis.clients.jedis.Jedis;

public class RedisConnection {
	private static final String HOST="localhost";
	private static final Integer PORT=6379;
	private static final Integer TIMEOUT=3000;
	
	public static Jedis getInstance(){
		Jedis jedis=new Jedis(HOST, PORT, TIMEOUT);
		System.out.println("连接成功"+jedis.ping());
		return jedis;
	}
}
