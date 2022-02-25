package com.sibyl.application.controller;

import com.sibyl.application.base.R;
import com.sibyl.application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequestMapping("/sys")
public class HelloController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String test(){
        System.err.println(System.currentTimeMillis());
        userService.test();
        System.err.println(System.currentTimeMillis());
        return "test";
    }

    @GetMapping("/user/page")
    public R getUser(){
        return R.success(200,userService.pageOfUser());
    }

    @RequestMapping("/get")
    public String hello(){
        return "hello,world";
    }

}
