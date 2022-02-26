package com.sibyl.dubbo.provider.controllor;

import com.sibyl.dubbo.comsumer.pojo.User;
import com.sibyl.dubbo.provider.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

/**
 * @Classname UserControllor
 * @Description TODO
 * @Date 2021/8/4 20:21
 * @Created by dyingleaf3213
 */
@RestController
@RequestMapping("/sys")
public class UserControllor {

    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/user/get")
    public User getById(@PathParam("id") Long id){
        return userService.selectById(id);
    }
}
