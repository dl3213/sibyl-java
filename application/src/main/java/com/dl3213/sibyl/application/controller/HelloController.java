package com.dl3213.sibyl.application.controller;

import com.dl3213.sibyl.application.Application;
import com.dl3213.sibyl.application.task.DynamicTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    private DynamicTask task;

    @RequestMapping("/task")
    public void test() throws Exception {
        // 开启定时任务，对象注解Scope是多利的。
        task.startCron();

    }
    @RequestMapping("/stop")
    public void stop() throws Exception {
        // 提前测试用来测试线程1进行对比是否关闭。
        ScheduledFuture scheduledFuture = Application.map.get("http-nio-8081-exec-1");
        if(scheduledFuture == null) return;
        scheduledFuture.cancel(true);
        // 查看任务是否在正常执行之前结束,正常true
        boolean cancelled = scheduledFuture.isCancelled();
        while (!cancelled) {
            scheduledFuture.cancel(true);
        }
    }

    @GetMapping("/get")
    public String hello(){
        return "hello,world";
    }

    public String fun1(){
        return "fun1";
    }
}
