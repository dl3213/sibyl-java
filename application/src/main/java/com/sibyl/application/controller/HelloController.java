package com.sibyl.application.controller;

import com.sibyl.application.base.ResponseUtil;
import com.sibyl.application.service.UserService;
import com.sibyl.application.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@RestController
@Slf4j
@RequestMapping("/sys")
public class HelloController {

    @Autowired
    private UserService userServiceImp;

    @RequestMapping("/getUser")
    public ResponseUtil getUser(){
        return ResponseUtil.success(new UserVo().setDateTime(new Date()));
    }

    @RequestMapping("/get")
    public String hello(){
        return "hello,world";
    }

}
