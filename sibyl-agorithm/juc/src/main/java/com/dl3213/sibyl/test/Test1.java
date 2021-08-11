package com.dl3213.sibyl.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @Classname Test1
 * @Description TODO
 * @Date 2021/8/1 12:27
 * @Created by dyingleaf3213
 */
@Slf4j
public class Test1 {
    public static void main(String[] args) {
        Runnable r1 = () -> {
            log.debug("running ......");
        };
        Thread t1 = new Thread(r1,"t2");
        t1.start();
    }
}
