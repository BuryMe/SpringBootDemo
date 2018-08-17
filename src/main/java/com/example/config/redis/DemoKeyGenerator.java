package com.example.config.redis;

import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 自定义 key值序列化 组件
 *
 * @Author constanting_f
 */
@Component
public class DemoKeyGenerator implements KeyGenerator {

    /**
     * key 值前缀，为了方便以后多个项目共同部署，做区分
     */
    private String PREFIX = "DEMO";


    @Override
    public Object generate(Object o, Method method, Object... objects) {
        StringBuilder stringBuilder = new StringBuilder();
        char sp = ':';
        stringBuilder.append(PREFIX);
        stringBuilder.append(sp);

        stringBuilder.append(o.getClass().getSimpleName());
        stringBuilder.append(sp);

        stringBuilder.append(method.getName());
        stringBuilder.append(sp);

        if(objects.length > 0){
            for(Object obj : objects){
                stringBuilder.append(obj.toString());
            }
        }
        return stringBuilder.toString();
    }

    public String getPREFIX() {
        return PREFIX;
    }

    public void setPREFIX(String PREFIX) {
        this.PREFIX = PREFIX;
    }
}
