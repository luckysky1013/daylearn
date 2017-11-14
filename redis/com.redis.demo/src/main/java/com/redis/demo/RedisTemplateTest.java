package com.redis.demo;

import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import redis.clients.jedis.JedisShardInfo;

public class RedisTemplateTest {
	private static final String HOST="localhost";
	private static final int PORT=6379;
	private static final int TIMEOUT=6000;
	public static void main(String[] args) {
		//jedis服务器地址相关信息
		JedisShardInfo jedisShardInfo=new JedisShardInfo(HOST, PORT, TIMEOUT);
		//redis相关配置
		JedisConnectionFactory factory=new JedisConnectionFactory();
		factory.setUsePool(false);
		factory.setPassword(null);
		factory.setShardInfo(jedisShardInfo);
		//redis template definition
		RedisTemplate redisTemplate=new RedisTemplate();
		redisTemplate.setConnectionFactory(factory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
		
		
	}
}
