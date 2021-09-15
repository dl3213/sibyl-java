package com.sibyl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname Application
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/13 22:33
 */
@SpringBootApplication
@MapperScan(basePackages = "com.sibyl.dao", markerInterface = org.hswebframework.web.dao.Dao.class)
public class ApplicationFromHsweb {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationFromHsweb.class,args);
    }
}
