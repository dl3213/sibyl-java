package com.sibyl.es;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Classname App
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/01/02 21:02
 */
@SpringBootApplication
@EnableScheduling
public class SearchApp {
    public static void main(String[] args) {
        SpringApplication.run(SearchApp.class, args);
    }
}
