package com.sibyl.nacosconsumer.controller;

import com.sibyl.nacosconsumer.mapper.OrderMapper;
import com.sibyl.nacosconsumer.pojo.Order;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
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
public class ConsumerController {

    @Value("${player.pid}")
    private String pid;

    @Value("${player.name}")
    private String pname;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private OrderMapper orderMapper;

    @RequestMapping("/orderCreate")
    @GlobalTransactional
    public String orderCreate(Long uid,Long pid){
        int insert = orderMapper.insert(new Order()
                .setUserId(uid)
                .setProductId(pid)
                .setMoney(BigDecimal.valueOf(97.89)).setStatus(0));
        String object = restTemplate.getForObject(
                "http://nacos-service-provicer/orderCreate?pid="+ pid + "&used=1", String.class);
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
