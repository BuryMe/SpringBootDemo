package com.example.expection;

import com.example.constant.ExpectCode;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局异常处理器
 * Created by constanting on 2018/6/30.
 */
@ControllerAdvice
@RestController
public class GlobalExpectionHandler {

    /**
     * web controller 层异常处理器
     * @param e
     * @return
     */
    @ExceptionHandler(value = BussinessExpection.class)
    public Map<String,Object> WebDateExpectionHandler(BussinessExpection e){
        Map<String,Object> result = new HashMap<>(3);
        e.printStackTrace();
        result.put("resCode",e.getCode());
        result.put("resMsg",e.getMsg());
        return result;
    }

    /**
     * 默认异常处理
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    public Map<String,Object> defaultExpectionHandler(Exception e){
        Map<String,Object> result = new HashMap<>(3);
        result.put("resCode", ExpectCode.EXPECTION_SYS);
        result.put("resMag","系统异常");
        return result;
    }
//    @ExceptionHandler(HttpClientErrorException.class)
//    @ResponseBody
//    public Map<String,Object> HttpExpectionHandler(){
//        Map<String,Object> result = new HashMap<>(3);
//        result.put("resCode","404");
//        result.put("resMsg","网络波动，请稍后再试");
//        return result;
//    }
}
