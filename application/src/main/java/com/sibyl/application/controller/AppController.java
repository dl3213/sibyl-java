package com.sibyl.application.controller;

import com.sibyl.application.device.DeviceTask;
import com.sibyl.application.device.DeviceTaskQueueService;
import com.sibyl.application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Classname AppController
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/11/07 16:39
 */
@RestController
@Slf4j
public class AppController {


    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @GetMapping("/poolTest")
    public Object poolTest() throws ExecutionException, InterruptedException {

        AtomicReference<String> ret = new AtomicReference<>("test ret");

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(() -> {
            String future11 = "future1";
            System.err.println(future11);
            System.err.println(Thread.currentThread().toString());
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(future11);
            ret.set(future11);
        }, threadPoolTaskExecutor);

        CompletableFuture<Void> future2 = CompletableFuture.runAsync(() -> {
            String future21 = "future2";
            System.err.println(future21);
            System.err.println(Thread.currentThread().toString());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.err.println(future21);
            ret.set(future21);
        }, threadPoolTaskExecutor);

        CompletableFuture.allOf(future1,future2).get();

        return ret;
    }


    @Resource
    private UserService userService;
    @Resource
    private DeviceTaskQueueService deviceTaskQueueService;
    @GetMapping("/taskGet")
    public void taskGet(){
        System.err.println(deviceTaskQueueService.getDeviceTask("testDevice"));
    }
    @GetMapping("/taskAdd")
    public void taskAdd(){
        DeviceTask task = new DeviceTask().setDeviceCode("testDevice").setTaskName("test")
                .setExpiresTime(-1);
        deviceTaskQueueService.addDeviceTask("testDevice", task);
    }
    @GetMapping("/task")
    public void task(){
        System.err.println(deviceTaskQueueService.getMap());
    }

    @GetMapping("/hanlder")
    public void handler(){
        userService.userHandler();
    }
}
