package com.dl3213.sibyl.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Classname RouterController
 * @Description TODO
 * @Date 2021/8/1 10:15
 * @Created by dyingleaf3213
 */

@Controller
public class RouterController {

    @RequestMapping({"/","index"})
    public String index(){
        return "index";
    }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "views/login";
    }
}
