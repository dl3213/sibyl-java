package com.sibyl.nacosconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname ConsumerController
 * @Description TODO
 * @Date 2021/8/7 18:02
 * @Created by dyingleaf3213
 */
@RestController
@RefreshScope
public class ConsumerController {

    @Value("${player.pid}")
    private String pid;

    @Value("${player.name}")
    private String pname;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/conGet")
    public String get(){

        return "get from consumer" + " => " +
                restTemplate.getForObject(
                        "http://nacos-service-provicer/proGet",String.class) +
                " ==> " + pid + " " + pname;
    }
}
