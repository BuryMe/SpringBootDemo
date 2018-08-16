package com.example.expection;

import org.springframework.boot.web.servlet.error.ErrorController;

/**
 * http异常处理
 * Created by constanting on 2018/7/1.
 */
public class HttpErrorHandler implements ErrorController{

    @Override
    public String getErrorPath() {
        return null;
    }
}
