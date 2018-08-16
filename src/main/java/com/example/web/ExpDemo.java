package com.example.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by constanting on 2018/6/30.
 */
@Slf4j
@RestController
public class ExpDemo {

    @RequestMapping("/exp")
    public void demo1()throws Exception{
        log.info("异常测试开始");
        log.info("异常测试开始2");
        log.info("异常测试开始3");
//        throw new BussinessExpection("8000","错误测试");
    }
}
