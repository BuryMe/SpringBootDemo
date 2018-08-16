package com.example.web;

import com.example.constant.ExpectCode;
import com.example.domain.common.ResultJson;
import com.example.domain.mybatis.UserInfo;
import com.example.expection.BussinessExpection;
import com.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 登录控制器
 * Created by constanting on 2018/7/3.
 */
@RestController("/login/")
@Slf4j
public class LoginController {

    @Autowired
    private LoginService loginService;

//    @RequestMapping("/userLogin")
//    public Map<String,Object> login(HttpServletRequest request){
//        log.info("用户登录开始");
//        Map<String,Object> resMap = new HashMap<>(2);
//        try{
//            String userName = request.getParameter("userName");
//            String userPwd = request.getParameter("userPwd");
//            UserInfo userInfo = new UserInfo();
//            userInfo.setUserName(userName);
//            userInfo.setUserPwd(userPwd);
//            loginService.verifyLoginInfo(userInfo);
//            resMap.put("resCode","000000");
//            resMap.put("resMag","登录成功");
//        }catch (BussinessExpection e){
//            resMap.put("resCode",e.getCode());
//            resMap.put("resMag",e.getMsg());
//        }catch (Exception e){
//            resMap.put("resCode","900000");
//            resMap.put("resMag","系统异常");
//        }
//        return resMap;
//    }

    @RequestMapping("/userLogin")
    public ResultJson login(HttpServletRequest request){
        ResultJson resultJson = new ResultJson();
        log.info("用户登录开始");
        Map<String,Object> resMap = new HashMap<>(2);
        try{
            String userName = request.getParameter("userName");
            String userPwd = request.getParameter("userPwd");
            UserInfo userInfo = new UserInfo();
            userInfo.setUserName(userName);
            userInfo.setUserPwd(userPwd);
            loginService.verifyLoginInfo(userInfo);
            resultJson.setCode("000000");
            resultJson.setMsg("登录成功");
        }catch (BussinessExpection e){
            resultJson.setCode(e.getCode());
            resultJson.setMsg(e.getMsg());
        }catch (Exception e){
            resultJson.setCode(ExpectCode.EXPEXTION_NORMAL);
            resultJson.setMsg("登录异常");
        }
        return resultJson;
    }

}
