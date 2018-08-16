package com.example.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by constanting on 2018/7/5.
 */
@Slf4j
@Order(value = 2)
@WebFilter(urlPatterns = "*.web",filterName = "Demo2")
public class Demo2Filter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("****filter*********");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
