package com.sibyl.dubbo.comsumer;

//import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname App
 * @Description TODO
 * @Date 2021/8/3 20:54
 * @Created by dyingleaf3213
 */
@SpringBootApplication
@MapperScan("com.sibyl.mapper")
public class DubboConsumerApp {

    public static void main(String[] args) {

        SpringApplication.run(DubboConsumerApp.class, args);
    }
}
