package com.sibyl.sshm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname AppRestController
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/03/05 22:23
 */
@RestController
@RequestMapping("/rest")
public class AppRestController {

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }
}
