package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义 注册需要登录验证 注解
 */
//表示该注解作用在防范上
@Target({ElementType.METHOD})
//表示在运行时启动该注解
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginRequired {
}
