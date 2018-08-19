package com.example.event.demo;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

/**
 * 用户注册事件 事件类
 * @author Administrator
 */

public class UserRegisterEvent extends ApplicationEvent {

    private String name;

    public UserRegisterEvent(Object source) {
        super(source);
    }

    public UserRegisterEvent(Object source,String name) {
        super(source);
        this.name = name;
    }
}
