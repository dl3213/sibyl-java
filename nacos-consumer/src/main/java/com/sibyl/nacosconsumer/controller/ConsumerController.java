package com.sibyl.nacosconsumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.sibyl.nacosconsumer.mapper.OrderMapper;
import com.sibyl.pojo.Order;
import com.sibyl.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

/**
 * @Classname ConsumerController
 * @Description TODO
 * @Date 2021/8/7 18:02
 * @Created by dyingleaf3213
 */
@RestController
@RefreshScope
@Component
public class ConsumerController {

    @Value("${player.pid}")
    private String pid;

    @Value("${player.name}")
    private String pname;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderMapper orderMapper;

    @Reference(check = false)
    private StorageService storageService;

    @RequestMapping("/orderCreate")
    @GlobalTransactional
    public String orderCreate(Long uid,Long pid){
        int insert = orderMapper.insert(new Order()
                .setUserId(uid)
                .setProductId(pid)
                .setMoney(BigDecimal.valueOf(97.89)).setStatus(0));
        int object = storageService.updateSto(pid,2);
        return insert+ " => " + object;
    }

    @RequestMapping("/conGet")
    public String get(){

        return "get from consumer" + " => " +
                restTemplate.getForObject(
                        "http://nacos-service-provicer/proGet",String.class) +
                " ==> " + pid + " " + pname;
    }
}
