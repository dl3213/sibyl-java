package com.sibyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @Classname App
 * @Description TODO
 * @Date 2021/8/3 20:50
 * @Created by dyingleaf3213
 */
@SpringBootApplication
@MapperScan("com.sibyl.mapper")
public class DubboProviderApp {

    public static void main(String[] args){
        SpringApplication.run(DubboProviderApp.class, args);
    }
}
