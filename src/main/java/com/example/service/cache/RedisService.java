package com.example.service.cache;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis 操作服务类
 */

@Service
public interface RedisService {

    /**
     * 查询redis里面的值
     * @param key
     * @return
     */
    public Object getValue(String key);

    /**
     * 新建redis值
     * @param key
     * @param object
     */
    public void setValue(String key,Object object);

    /**
     * 新建redis 键值对，并且对其保存的时间进行自定义
     * @param key
     * @param object
     * @param timeOut
     * @param timeUnit
     */
    public void setValue(String key, Object object, Long timeOut, TimeUnit timeUnit);

    /**
     * 根据key值删除 value
     * @param key
     */
    public Boolean delete(String key);

    /**
     * redis缓存中是否有该key值对应的value
     * @param key
     * @return
     */
    public Boolean hasValue(String key);

}
