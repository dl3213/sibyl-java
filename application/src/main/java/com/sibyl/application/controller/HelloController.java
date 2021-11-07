package com.sibyl.application.controller;

import com.sibyl.application.base.ResponseUtil;
import com.sibyl.application.service.UserService;
import com.sibyl.application.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


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

    @RequestMapping("/getUser")
    public ResponseUtil getUser(){
        return ResponseUtil.success(200,userService.getPageOfUser());
    }

    @RequestMapping("/get")
    public String hello(){
        return "hello,world";
    }

}
