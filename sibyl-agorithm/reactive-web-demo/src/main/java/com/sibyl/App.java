package com.sibyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.Optional;

/**
 * @Classname com.sibyl.App
 * @Description TODO
 * @Date 2021/8/16 20:11
 * @Created by dyingleaf3213
 */
@SpringBootApplication
@ServletComponentScan(basePackages = "com.sibyl")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
//        Optional.ofNullable()
    }
}
