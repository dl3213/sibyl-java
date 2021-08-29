//package com.dl3213.sibyl.application.task;
//
//import com.dl3213.sibyl.application.websocket.WebSocketServer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import javax.websocket.Session;
//import java.util.Date;
//import java.util.Map;
//
///**
// * @Classname tesk
// * @Description TODO
// * @Date 2021/7/25 0:25
// * @Created by dyingleaf3213
// */
//@Component
//@EnableScheduling
//public class Task {
//
//    @Autowired
//    private WebSocketServer webSocketServer;
//
//    private Integer count=0;
//
//    // 5秒推送一次
////    @Scheduled(cron = "*/5 * * * * ?")
//    public void sendMsg(){
//        Map<String, Session> sessionMap = webSocketServer.getWebSocketSet();
//        if(sessionMap == null || sessionMap.size() == 0) {
//            count = 0;
//            return;
//        }else
//            count ++ ;
//
//        System.err.println("now => " + count + " => " + new Date());
//        if(count % 5 == 0) {
//            System.err.println("now 2 ....u need to do something...." + new Date());
//        }
//        for (Map.Entry<String,Session> entry:sessionMap.entrySet()) {
//            Session session = entry.getValue();
//            String val = entry.getKey();
//            if (session != null && session.isOpen()) {
//                try {
//                    System.err.println(new Date() +"**********定时任务执行***********" + count);
//                    session.getAsyncRemote().sendText(val + " 次数：  "  + count);
////                    count++;
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
//}