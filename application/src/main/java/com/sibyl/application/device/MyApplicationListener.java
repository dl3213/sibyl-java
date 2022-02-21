package com.sibyl.application.device;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @Classname MyApplicationListener
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/17 13:04
 */
@Component
public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

    public void onApplicationEvent(MyApplicationEvent event) {
        System.out.println("接收到事件："+event.getClass());
    }

}