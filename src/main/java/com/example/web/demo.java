package com.example.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * Created by constanting on 2018/5/23.
 */
@Slf4j
@Controller
public class demo {

    @RequestMapping("/hello")
    @ResponseBody
    public String index(){
        log.error("error");
        log.debug("debug");
        log.info("info");
        log.warn("warn");
        log.trace("trace");
        return "hello,world";
    }

    @RequestMapping("/thy")
    public String thyDemo(ModelMap modelMap){
        modelMap.addAttribute("host","www.baidu.com");
        return "index";
    }

    @ModelAttribute
    public void demo01(){
        System.out.println("方法01");
    }

    @ModelAttribute
    public void demo02(){
        System.out.println("方法02");
    }

    @RequestMapping(value = "/mTest",method = RequestMethod.GET)
    public void mTest(){
        System.out.println("moduleTest方法");
    }
}
