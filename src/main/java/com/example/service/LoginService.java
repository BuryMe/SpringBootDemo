package com.example.service;

import com.example.domain.mybatis.UserInfo;
import com.example.expection.BussinessExpection;

/**
 * 登录模块业务
 * Created by constanting on 2018/7/4.
 */
public interface LoginService {

    /**
     * 验证信息是否可以登录
     * @param userInfo
     * @return
     */
    public void verifyLoginInfo(UserInfo userInfo)throws BussinessExpection;

    /**
     * 用户注册
     * @param userInfo
     * @throws BussinessExpection
     */
    public void registerInfo(UserInfo userInfo)throws BussinessExpection;

    public UserInfo selectByUserId(Long userId)throws BussinessExpection;

}
