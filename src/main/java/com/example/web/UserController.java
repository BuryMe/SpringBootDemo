package com.example.web;

import com.example.domain.entity.UserEntity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * Created by constanting on 2018/5/23.
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    /**
     * 创建线程安全的map
     */
    static Map<Long,UserEntity> user = Collections.synchronizedMap(new HashMap<Long, UserEntity>());

    /**
     * 查询列表
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public List<UserEntity> getUserList(){
        List<UserEntity> rList = new ArrayList<UserEntity>(user.values());
        return rList;
    }

    /**
     * 新增
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/",method = RequestMethod.POST)
    public String postUser(@ModelAttribute UserEntity userEntity){
        user.put(userEntity.getId(),userEntity);
        return "success";
    }

    /**
     * 查询单个
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public UserEntity getUser(@PathVariable Long id){
        return user.get(id);
    }

    /**
     * 更新
     * @param id
     * @param userEntity
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id,@ModelAttribute UserEntity userEntity){
        UserEntity userEntity1 = user.get(id);
        userEntity1.setName(userEntity.getName());
        userEntity1.setAge(userEntity.getAge());
        user.put(id,userEntity1);
        return "success";
    }

    /**
     * 根据ID删除
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id){
        user.remove(id);
        return "success";
    }
}
