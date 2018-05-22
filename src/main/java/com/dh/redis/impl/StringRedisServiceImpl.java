package com.dh.redis.impl;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.dh.redis.RedisService;

//@Service
public class StringRedisServiceImpl implements RedisService{

	@Autowired
	private StringRedisTemplate redisTemplate;

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return redisTemplate.opsForValue().get(key);
	}

	@Override
	public void setValue(String key, Object value) {
		// TODO Auto-generated method stub
		redisTemplate.opsForValue().set(key, value.toString());
		
	}

	@Override
	public void setValue(String key, Object value, long duration) {
		// TODO Auto-generated method stub
		setValue(key, value);
		redisTemplate.expire(key, duration, TimeUnit.MINUTES);
	}

	@Override
	public void delValue(String key) {
		// TODO Auto-generated method stub
		redisTemplate.delete(key);
	}

	
}
