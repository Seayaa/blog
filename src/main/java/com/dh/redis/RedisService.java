package com.dh.redis;

public interface RedisService {

	Object getValue(String key);
	
	void setValue(String key, Object value);
	
	void setValue(String key, Object value, long duration);
	
	void delValue(String key);
	
}
