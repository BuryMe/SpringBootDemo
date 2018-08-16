package com.example.demo;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by constanting on 2018/6/3.
 */
public class refDemo {

    public static void main(String[] args) throws Exception{
//        Class<?> demo = ref.class;
//        Method[] methods = demo.getMethods();
//        for(Method method : methods){
//            System.out.println(method);
//        }
//        Class<?> demo = Class.forName("com.example.demo.ref");
//        Method method = demo.getMethod("refDemo");
//        method.invoke(demo.newInstance());

        Map<String,Object> obj =  new HashMap<>();
        obj.put("a","A");
        obj.put("b","B");
        System.out.println(obj.size());
    }
}
