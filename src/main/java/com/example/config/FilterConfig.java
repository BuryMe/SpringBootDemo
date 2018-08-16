package com.example.config;

import com.example.filter.DemoFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import java.io.IOException;

/**
 * servlet过滤器配置类
 * Created by constanting on 2018/7/1.
 */
//@Configuration
//public class FilterConfig{
//
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean(){
//        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new DemoFilter());
//        filterRegistrationBean.addUrlPatterns(".web");
//        filterRegistrationBean.setOrder(1);
//        return filterRegistrationBean;
//    }
//}
