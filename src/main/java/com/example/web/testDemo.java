package com.example.web;

import com.example.dao.IdTestMapper;
import com.example.domain.mybatis.IdTest;
import com.example.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by constanting on 2018/6/26.
 */
@Slf4j
@RestController
public class testDemo {

    @Autowired
    private IdTestMapper idTestMapper;

    @Autowired
    private DemoService demoService;

    @RequestMapping("/test")
    public Object testIdTest(){
        log.info("开始测试");
        return idTestMapper.insert(null);
    }

    @RequestMapping("/test2")
    public int insertIdTest(){
        IdTest idTest = new IdTest();
        idTest.setId(000);
        idTest.setSize(100);
        return idTestMapper.insert(idTest);
    }

    @RequestMapping("/test3.web")
    public void test3(){
        log.info("测试方法3开始");
//        demoService.test3();
        log.info("测试方法3成功");
    }
}
