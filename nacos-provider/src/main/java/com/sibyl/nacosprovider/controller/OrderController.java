package com.sibyl.nacosprovider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2021/8/7 17:35
 * @Created by dyingleaf3213
 */
@RestController
@RefreshScope
public class OrderController {

    @RequestMapping("/proGet")
    public String get(){
        System.err.println("be called ...");
        return "get from provider";
    }
}
