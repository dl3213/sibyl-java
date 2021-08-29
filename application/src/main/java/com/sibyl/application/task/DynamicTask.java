//package com.dl3213.sibyl.application.task;
//
//import com.dl3213.sibyl.application.Application;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//import org.springframework.scheduling.support.CronTrigger;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.ScheduledFuture;
//
///**
// * @Classname DynamicTask
// * @Description TODO
// * @Date 2021/7/25 18:34
// * @Created by dyingleaf3213
// */
//@Component
//@Scope("prototype")
//@Slf4j
//public class DynamicTask {
//
//    private String cron;
//    @Autowired
//    private ThreadPoolTaskScheduler threadPoolTaskScheduler;
//    private ScheduledFuture future;
//
//    public void startCron() {
//        cron = "0/3 * * * * ?";
//        System.out.println(Thread.currentThread().getName());
//        String name = Thread.currentThread().getName();
//        future = threadPoolTaskScheduler.schedule(new myTask(name), new CronTrigger(cron));
//        Application.map.put(name, future);
//    }
//
//    public void stop() {
//        if (future != null) {
//            future.cancel(true);
//        }
//    }
//
//    private class myTask implements Runnable {
//        private String name;
//
//        myTask(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("test" + name);
//        }
//    }
//
//}
