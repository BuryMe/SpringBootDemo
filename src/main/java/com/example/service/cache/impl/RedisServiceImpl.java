package com.example.service.cache.impl;

import com.example.service.cache.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

/**
 * redis缓存操作具体实现类
 */
public class RedisServiceImpl implements RedisService {

    /**
     * 默认存储时间为30分钟
     */
    private Long DEAULT_TIME = 30L;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Object getValue(String key) {
        return null;
    }

    @Override
    public void setValue(String key, Object object) {
        redisTemplate.opsForValue().set(key, object);
        redisTemplate.expire(key, DEAULT_TIME, TimeUnit.MINUTES);
    }

    @Override
    public void setValue(String key, Object object, Long timeOut, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, object);
        redisTemplate.expire(key, timeOut, timeUnit);
    }

    @Override
    public Boolean delete(String key) {
        return redisTemplate.delete(key);

    }

    @Override
    public Boolean hasValue(String key) {
        return redisTemplate.hasKey(key);
    }

    public Long getDEAULT_TIME() {
        return DEAULT_TIME;
    }

    public void setDEAULT_TIME(Long DEAULT_TIME) {
        this.DEAULT_TIME = DEAULT_TIME;
    }
}
