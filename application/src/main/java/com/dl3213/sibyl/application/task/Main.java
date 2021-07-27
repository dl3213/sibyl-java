//package com.dl3213.sibyl.application.task;
//
//import com.dl3213.sibyl.application.task.HelloJob;
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.context.annotation.Bean;
//
///**
// * @Classname Main
// * @Description TODO
// * @Date 2021/7/25 1:03
// * @Created by dyingleaf3213
// */
//public class Main {
//
//    public static void main(String[] args) {
//        int count = 0;
//        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
//                .withIdentity("job1","g1")
//                .usingJobData("job","jobDetail")
//                .usingJobData("uid","3123")
//                .usingJobData("count",count)
//                .build();
//        Trigger trigger = TriggerBuilder.newTrigger()
//                .withIdentity("trigger1","t1")
//                .usingJobData("trigger","trigger")
//                .usingJobData("uid","3120")
//                .usingJobData("count",count)
//                .startNow()
//                .withSchedule(
//                        SimpleScheduleBuilder
//                                .simpleSchedule()
//                                .withIntervalInSeconds(3)
//                                .repeatForever())
//                .build();
//
//        try {
//            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();//i need
//            scheduler.scheduleJob(jobDetail,trigger);
//            scheduler.start();
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//}
