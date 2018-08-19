package com.example.config;

import com.example.interceptor.DemoInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器统一管理类
 * @Author constanting
 * @Date 2018/7/2.
 */
@Configuration
public class InterceptConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //对所有请求路径进行拦截，除了"/login"和"/register";
        registry.addInterceptor(new DemoInterceptor()).addPathPatterns("/**").excludePathPatterns("/login","/register");

//        registry.addInterceptor( loginInterceptor()).addPathPatterns("/**");
//        super.addInterceptors(registry);
    }

}
