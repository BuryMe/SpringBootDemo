package com.example.domain.common.customize;

import java.lang.annotation.*;

/**
 * 自定义注解：登录
 * 用法：在需要进行登录验证的方法上加上该注解
 */

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Auth {


}
