package com.example.event.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

/**
 * 事件监听
 */
public class Listeren implements ApplicationListener<UserRegisterEvent> {

    @Override
    public void onApplicationEvent(UserRegisterEvent userRegisterEvent) {
        System.out.println("积分服务接到通知，给 " + userRegisterEvent.getSource() +
                " 增加积分...");
    }


    public static void main(String[] args) {
        ApplicationContext context =new
                ClassPathXmlApplicationContext("beans.xml");
        UserService userService = (UserService)
                context.getBean("userService");
        //注册事件触发
        userService.register("glmapper");
    }



}
