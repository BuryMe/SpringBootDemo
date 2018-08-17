package com.example.cache.redis;

import redis.clients.jedis.Jedis;

/**
 * redise 测试
 */
public class Demo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379, 1000);
        jedis.auth("123456");
        int i = 0;
        //开始时间
        long startTime = System.currentTimeMillis();
        long end;
        try {

            while (true){
                jedis.set("test"+i++,i+++"");
                end = System.currentTimeMillis();
                if(end-startTime>1000){
                    break;
                }
            }
        }
        finally {
            jedis.close();
        }
        //结束时间
        System.out.println(end-startTime);
        System.out.println(i);
    }

}
