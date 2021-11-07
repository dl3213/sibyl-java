package com.sibyl.application.controller;

import com.sibyl.application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname AppController
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/11/07 16:39
 */
@RestController
@Slf4j
public class AppController {

    @Resource
    private UserService userService;

    @GetMapping("/hanlder")
    public void handler(){
        userService.userHandler();
    }
}
