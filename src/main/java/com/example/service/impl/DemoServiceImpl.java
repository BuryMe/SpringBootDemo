package com.example.service.impl;

import com.example.dao.UserInfoMapper;
import com.example.service.DemoService;
import com.example.util.DateUtil;
import com.example.util.NumberUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by constanting on 2018/5/23.
 */
@Service
@Slf4j
public class DemoServiceImpl implements DemoService{

    @Autowired
    private UserInfoMapper userInfoMapper;
    /**
     * 测试3
     */
    @Override
    public void test3(){
//        log.info("进入test3路由");
//        UserInfo userInfo = new UserInfo();
//        userInfo.setUserId(NumberUtil.getSqlID());
//        userInfo.setUserName("admin");
//        userInfo.setUserPwd("123456");
//        userInfo.setUserState("00");
//        userInfo.setUserClass("admin");
//        userInfo.setUserLogInTime(DateUtil.getDateTimeByFormat(DateUtil.YYYYMMDDHHMMSS));
//        userInfo.setUserRegTime(DateUtil.getDateTimeByFormat(DateUtil.YYYYMMDDHHMMSS));
//        userInfo.setUserToken("1");
//        userInfoMapper.insert(userInfo);

    }
}
