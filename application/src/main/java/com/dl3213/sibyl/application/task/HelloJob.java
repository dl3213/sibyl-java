//package com.dl3213.sibyl.application.task;
//
//import lombok.Setter;
//import lombok.experimental.Accessors;
//import lombok.extern.slf4j.Slf4j;
//import lombok.val;
//import org.quartz.*;
//import org.springframework.stereotype.Component;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///**
// * @Classname HelloJob
// * @Description TODO
// * @Date 2021/7/25 0:57
// * @Created by dyingleaf3213
// */
//@Slf4j
////@Component
//@DisallowConcurrentExecution//禁止并发执行job
//@PersistJobDataAfterExecution//jobDataMap持久化(对triggermap中无效)
//public class HelloJob implements Job {
//
//    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
//
//    private String uid;
//
//    public void setUid(String uid) {
//        this.uid = uid;
//    }
//
//    @Override
//    public void execute(JobExecutionContext context) throws JobExecutionException {
////        log.info(" helloJob ==> " + sdf.format(new Date()));
////        JobDataMap jobMap = context.getJobDetail().getJobDataMap();
////        JobDataMap triggerMap = context.getTrigger().getJobDataMap();
////        JobDataMap mergedJobDataMap = context.getMergedJobDataMap();
////        System.err.println("job => " + jobMap.getString("job"));
////        System.err.println("tri => " + triggerMap.getString("trigger"));
////        System.err.println("mer => " + mergedJobDataMap.getString("trigger"));
////
////        System.err.println("uid => " + uid);
//
//
////        //@DisallowConcurrentExecution
////        System.err.println("jobDetail => " + System.identityHashCode(context.getJobDetail()));
////        System.err.println("job => " + System.identityHashCode(context.getJobInstance()));
////        System.err.println("exc => " + sdf.format(new Date()));
////        try {
////            Thread.sleep(5000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//
//
//        //@PersistJobDataAfterExecution
//        JobDataMap jobMap = context.getJobDetail().getJobDataMap();
//        jobMap.put("count" ,jobMap.getInt("count") + 1);
//        System.err.println(" count => " + jobMap.getInt("count"));
//
//
//    }
//}
