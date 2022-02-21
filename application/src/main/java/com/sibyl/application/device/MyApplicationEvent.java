package com.sibyl.application.device;

/**
 * @Classname MyApplicationEvent
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/17 13:04
 */

import org.springframework.context.ApplicationEvent;

/**
 * 定义事件
 *
 */
public class MyApplicationEvent extends ApplicationEvent {

    private static final long serialVersionUID = 1L;

    public MyApplicationEvent(Object source) {
        super(source);
    }
}
