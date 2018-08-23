package com.example.service.impl;

import com.example.dao.UserInfoMapper;
import com.example.domain.mybatis.UserInfo;
import com.example.domain.mybatis.UserInfoKey;
import com.example.expection.BussinessExpection;
import com.example.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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

    @Override
    public void registerInfo(UserInfo userInfo) throws BussinessExpection {
        log.info("开始进行用户注册");
        String loginName = userInfo.getUserName();
        String loginPwd = userInfo.getUserPwd();
        if(null == loginName || "".equals(loginName)){
            log.error("注册用户名为空");
            throw new BussinessExpection("100002","注册用户名为空");
        }
        if(null == loginPwd || "".equals(loginPwd)){
            log.error("注册登录密码为空");
            throw new BussinessExpection("100003","注册登录密码为空");
        }
        //验证登录名是否重复
        UserInfo userInfo1 = null;
        try{
            userInfo1 = userInfoMapper.selectByUserName(loginName);
        }catch (Exception e){
            throw new BussinessExpection("999999","查询用户信息异常");
        }
        if( null != userInfo1){
            log.info("用户名重复，请更换用户名");
            throw new BussinessExpection("100004","用户名已存在，请更换");
        }
        LocalDateTime localDateTime = LocalDateTime.now();
        String localDateTimeStr = localDateTime.format(DateTimeFormatter.ofPattern("yyyyMMdd HHmmss"));
        userInfo.setUserRegTime(localDateTimeStr);
        //用户注册默认为0级表示为普通用户
        userInfo.setUserClass("0");
        //用户状态00表示为可用状态(默认)
        userInfo.setUserState("00");
        int result= userInfoMapper.insert(userInfo);
        if(result != 1){
            throw new BussinessExpection("100005","用户注册失败，请稍后再试");
        }
    }

    @Override
    public UserInfo selectByUserId(Long userId) throws BussinessExpection {
        UserInfo userInfo = new UserInfo();
        try{
            userInfo = userInfoMapper.selectByUserId(userId);
            if(null == userInfo){
                throw new BussinessExpection("100007","用户不存在");
            }
        }catch (Exception e){
            throw new BussinessExpection("100006","查询用户信息异常");
        }
        return userInfo;
    }
}
