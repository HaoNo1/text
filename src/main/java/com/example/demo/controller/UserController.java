package com.example.demo.controller;


import com.example.demo.entity.UserEntity;
import com.example.demo.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userjpa;

    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public List<UserEntity> list(){
        return userjpa.findAll();
    }
    /**
     * 添加更新
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity entity){

        return userjpa.save(entity);
    }
    /**
     * 删除
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(long id){
        userjpa.deleteById(id);
        return userjpa.findAll();
    }

}
