package com.sibyl.application.controller;

import com.sibyl.application.device.DeviceTask;
import com.sibyl.application.device.DeviceTaskQueueService;
import com.sibyl.application.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

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

        long start = System.currentTimeMillis();

        System.err.println(threadPoolTaskExecutor);
        System.err.println("threadPoolTaskExecutor.getPoolSize() => " + threadPoolTaskExecutor.getPoolSize());
        System.err.println("threadPoolTaskExecutor.getCorePoolSize() => " + threadPoolTaskExecutor.getCorePoolSize());
        System.err.println("threadPoolTaskExecutor.getMaxPoolSize() => " + threadPoolTaskExecutor.getMaxPoolSize());
        System.err.println("threadPoolTaskExecutor.getActiveCount() => " + threadPoolTaskExecutor.getActiveCount());

        AtomicReference<String> ret = new AtomicReference<>("test ret");
        List<Integer> retList = new ArrayList<>();

        int[] arr = {1,2,3,4,5};

        //同步执行
//        Arrays.stream(arr).forEach(i->{
//            retList.add(threadFunctionTest(i));
//        });

        //异步执行
        List<CompletableFuture<?>> futures =
                Arrays.stream(arr)
                        .mapToObj(e-> CompletableFuture.runAsync(()->{
                            int get = threadFunctionTest(e);
                            retList.add(get);
                        },threadPoolTaskExecutor))
                        .collect(Collectors.toList());

        CompletableFuture.allOf(futures.toArray(new CompletableFuture<?>[futures.size()])).get();

        System.err.println("cost ==> " + (System.currentTimeMillis()-start));
        System.err.println(retList);
        return retList;
    }

    private int threadFunctionTest(int e) {
        int x = e * 100;
        System.err.println(Thread.currentThread().toString() + " get => " + x);
        try {
            Thread.sleep(x);
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        return x;
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
