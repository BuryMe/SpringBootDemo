package com.example.service.impl;

import com.example.dao.UserInfoMapper;
import com.example.domain.mybatis.UserInfo;
import com.example.domain.mybatis.UserInfoKey;
import com.example.expection.BussinessExpection;
import com.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by constanting on 2018/7/4.
 */
@Service
@Slf4j
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public void verifyLoginInfo(UserInfo loginUserInfo)throws BussinessExpection {
        log.info("开始登录信息验证");
        String loginName = loginUserInfo.getUserName();
        String loginPwd = loginUserInfo.getUserPwd();
        if(null == loginName || "".equals(loginName)){
            log.error("登录名为空");
            throw new BussinessExpection("100002","登录名不得为空");
        }
        if(null == loginPwd || "".equals(loginPwd)){
            log.error("登录密码为空");
            throw new BussinessExpection("100003","登录密码不得为空");
        }
        UserInfoKey userInfoKey = new UserInfoKey();
        userInfoKey.setUserName(loginUserInfo.getUserName());
        UserInfo userInfo = userInfoMapper.selectByPrimaryKey(userInfoKey);
        if(null == userInfo){
            log.error("登录信息不存在 ，登录失败");
            throw new BussinessExpection("100001","登录信息有误，请重新输入");
        }
        String userPwd = userInfo.getUserPwd();
        if(loginPwd.equals(userPwd)){
            log.info("登录成功");
        }
    }
}
