package com.example.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.annotation.LoginRequired;
import com.example.domain.mybatis.UserInfo;
import com.example.expection.BussinessExpection;
import com.example.service.LoginService;
import com.example.service.cache.RedisService;
import jdk.internal.org.objectweb.asm.Handle;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * token登录验证
 * 登录拦截器
 */
@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

//    private static final String LOGIN_URL = "/login/userLogin.web";
//    private static final String REGISTER_URL = "/login/userLogin.web";
    /**
     * url白名单集合
     */
    private static List<String> urlList = new ArrayList();
    static {
        //登录模块url,无需拦截
        urlList.add("/login/userLogin.web");
        urlList.add("login/userRegister.web");
    }

    @Autowired
    private LoginService loginService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("登录验证拦截器开始工作");
        String requestURI = request.getRequestURI();
        log.info("请求URI:{}",requestURI);
        HandlerMethod handlerMethod = (HandlerMethod)handler;
        Method method = handlerMethod.getMethod();

        LoginRequired loginRequired = method.getAnnotation(LoginRequired.class);
        //方法上知否存在@LoginRequired注解
        if(null == loginRequired){
            //不存在表示不需要拦截,请求放行
            return true;
        }else{
            //请求需要拦截，判断请求是否属于登录模块URI
            //是否是登录模块URI标识（默认为false）
            Boolean isLoginUrl = false;
            //判断请求是否需要拦截(默认需要拦截)
            for(String url : urlList){
                if(url.equals(isLoginUrl)){
                    isLoginUrl = true;
                }
            }
            if(true){
                //请求属于登录模块，请求放行
                return true;
            }else{
                //请求不属于登录模块，开始进行登录验证
                String token = request.getHeader("token");
                if(token == null){
                    throw new BussinessExpection("900001","无token，请重新登录");
                }
                Long userId;
                try{
                    userId = Long.parseLong(JWT.decode(token).getAudience().get(0));
                }catch (JWTDecodeException e){
                    throw new BussinessExpection("900002","无效token，请重新登录");
                }
                try{
                    UserInfo user = loginService.selectByUserId(userId);
                }catch (BussinessExpection e){
                    throw new BussinessExpection("900003","用户不存在，请重新登录");
                }
//                try {
//                    JWTVerifier verifier =  JWT.require(Algorithm.HMAC256(user.getPassword())).build();
//                    try {
//                        verifier.verify(token);
//                    } catch (JWTVerificationException e) {
//                        throw new RuntimeException("token无效，请重新登录");
//                    }
//                } catch (UnsupportedEncodingException ignore) {}
//                request.setAttribute("currentUser", user);
                return true;
            }
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }


}
