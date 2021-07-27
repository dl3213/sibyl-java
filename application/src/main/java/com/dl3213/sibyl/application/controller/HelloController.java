package com.dl3213.sibyl.application.controller;

import com.dl3213.sibyl.application.base.ResponseUtil;
import com.dl3213.sibyl.application.service.iml.UserServiceImp;
import com.dl3213.sibyl.application.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Date;


@RestController
@Slf4j
@RequestMapping("/sys")
public class HelloController {

    @Autowired
    private UserServiceImp userServiceImp;

    @RequestMapping("/getUser")
    public ResponseUtil getUser(){
        return ResponseUtil.success(new UserVo().setDateTime(new Date()));
    }

    @GetMapping("/get")
    public String hello(){
        return "hello,world";
    }

    public String fun1(){
        return "fun1";
    }
}
