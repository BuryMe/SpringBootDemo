package com.example.filter;


import com.example.constant.ExpectCode;
import com.example.domain.common.ResultJson;
import lombok.extern.slf4j.Slf4j;

import org.springframework.core.annotation.Order;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 项目测试过滤器
 * Created by constanting on 2018/7/1.
 */
@Slf4j
@Order(value = 1)
@WebFilter(urlPatterns = "*.web",filterName = "demo")
public class DemoFilter implements Filter {

    private static final String CONTEXT_PATH = "/demo/";

//    @Value("")
    private static String[] filterUris = {CONTEXT_PATH+"login/userLogin.web",CONTEXT_PATH+"register.web"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request,response);
//        log.info("------------filter---------------");
//        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
//        HttpServletResponse httpServletResponse = (HttpServletResponse)response;
//        HttpSession httpSession = httpServletRequest.getSession(false);
//        String uri = httpServletRequest.getRequestURI();
//        String contextPath = httpServletRequest.getContextPath();
//        String url = ((HttpServletRequest) request).getRequestURL().toString();
//        log.info("上下文路径：{}",contextPath);
//        log.info("请求路径：{}",uri);
//        log.info("url:{}",url);
//        Boolean isNeedFilter = needFilter(uri);
//        if(isNeedFilter){
//            //非登录注册接口，开始进行登录验证
//            log.info("开始进行session验证");
//            if(null != httpSession && httpSession.getAttribute("user") != null){
//                log.info("已经登录");
//                chain.doFilter(request,response);
//            }else{
//                ResultJson resultJson = new ResultJson();
//                resultJson.setCode(ExpectCode.EXPECTION_SYS);
//                resultJson.setMsg("请先登录");
//                httpServletResponse.setCharacterEncoding("utf-8");
//                httpServletResponse.setContentType("text/html;charset=UTF-8");
//
//                chain.doFilter(request,response);
////                没有登陆，判断是否为ajax请求
//                String requestType = httpServletRequest.getHeader("X-Request-With");
//                if(null != requestType && "XMLHttpRequest".equals(requestType)){
//                    //ajax请求
//                    chain.doFilter(request,response);
//                }
//            }
//        }else{
//            //登录注册请求，不需要过滤，直接传递给下一个过滤器
//            chain.doFilter(request,response);
//        }
    }

    @Override
    public void destroy() {

    }

    /**
     * 判断请求uri是否需要过滤
     * @param requestUri
     * @return
     */
    private Boolean needFilter(String requestUri){
        for (String uri:filterUris) {
            log.info(uri);
            log.info(requestUri);
            if(uri.equals(requestUri)){
                log.info("不需要拦截");
                return false;
            }
        }
        return true;
    }
}
