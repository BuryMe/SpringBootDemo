package com.example.interceptor;


import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 项目测试拦截器
 * Created by constanting on 2018/7/1.
 */
@Component
@Slf4j
public class DemoInterceptor  implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
//        session.setAttribute("id","111");
//        if(session.isNew()){
//            log.info("this is a new session");
////            System.out.println("this is a new session");
//        }else{
//            log.info("session is exist");
////            System.out.println("session is exist");
//        }
//        if(null == session){
////            log.info("no session");
//        }else{
//            //session验证通过
//        }
        log.info("---------------intercept------------");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {

    }
}
