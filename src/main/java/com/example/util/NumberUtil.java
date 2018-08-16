package com.example.util;

import redis.clients.util.MurmurHash;

import java.util.Arrays;
import java.util.UUID;

/**
 * 数字（ID）工具类
 * Created by constanting on 2018/7/3.
 */
public class NumberUtil {

    /**
     * 分布式自增ID Snowflake实现
     * @return
     */
    public static long getSqlID(){
        SnowflakeId idWorker = new SnowflakeId(0, 0);
        long id = idWorker.nextId();
        return id;
    }

    public static void main(String[] args) {
        System.out.println(getSqlID());
    }
}
