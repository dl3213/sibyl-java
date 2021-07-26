//package com.dl3213.sibyl.application.task;
//
//import org.quartz.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationEvent;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
///**
// * @Classname AppStartListener
// * @Description TODO
// * @Date 2021/7/25 2:19
// * @Created by dyingleaf3213
// */
//
////@Component
//public class AppStartListener implements ApplicationListener<ContextRefreshedEvent> {
//
//    @Autowired
//    private Scheduler scheduler;
//
//    @Override
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//        TriggerKey triKey1 = TriggerKey.triggerKey("t1","g1");
//        try {
//            Trigger trigger = scheduler.getTrigger(triKey1);
//            if(trigger == null){
//                trigger = TriggerBuilder.newTrigger()
//                        .withIdentity(triKey1)
//                        .withSchedule(CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
//                        .startNow()
//                        .build();
//                JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class)
//                        .withIdentity("j1","g1")
//                        .build();
//                scheduler.scheduleJob(jobDetail,trigger);
//
//                scheduler.start();
//            }
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//}
