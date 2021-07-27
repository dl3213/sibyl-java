//package com.dl3213.sibyl.application.task;
//
//import com.dl3213.sibyl.application.websocket.WebSocketServer;
//import org.quartz.DisallowConcurrentExecution;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.quartz.PersistJobDataAfterExecution;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//
//import javax.websocket.Session;
//import java.util.Date;
//import java.util.Map;
//
///**
// * @Classname QuartzJob
// * @Description TODO
// * @Date 2021/7/25 2:01
// * @Created by dyingleaf3213
// */
//@PersistJobDataAfterExecution
////@DisallowConcurrentExecution
//public class QuartzJob extends QuartzJobBean {
//
//    private Integer count=0;
//
//    @Override
//    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//        try {
//            Thread.sleep(3000);
//            System.err.println(context.getScheduler().getSchedulerInstanceId());
//            System.err.println("taskName => " + context.getJobDetail().getKey().getName());
//            System.err.println("exc time => " + new Date());
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
