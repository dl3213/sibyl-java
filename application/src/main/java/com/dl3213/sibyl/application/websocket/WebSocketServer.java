package com.dl3213.sibyl.application.websocket;

import com.dl3213.sibyl.application.task.QuartzJob;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname WebSocketServer
 * @Description TODO
 * @Date 2021/7/25 0:21
 * @Created by dyingleaf3213
 */
@ServerEndpoint("/ws/{uid}")
@Component
@EqualsAndHashCode
@Slf4j
public class WebSocketServer {

    // 保存连接已连接对象（map键值对的保存方式）
    private static Map<String, Session> sessionPool = new HashMap<String, Session>();
    //静态变量，记录当前连接数量
    private static int onlineCount = 0;
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    // 与某一客户端的会话，需要通过客户标识获取对应的session
    private String uid;


    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session,  @PathParam(value="uid")String uid) throws SchedulerException {
        this.session = session;
        this.uid = uid;
        sessionPool.put(uid,session);
        addOnlineCount();  // 在线数加1
        log.info("有新连接加入！当前在线人数为" + getOnlineCount());

    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose(@PathParam(value="uid") String uid) {
        Map<String, Session> webSocketSet = this.getWebSocketSet();
        webSocketSet.remove(uid);//!
        sessionPool.remove(uid);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 接收客户端消息后调用的方法
     *
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        System.out.println("来自客户端的消息:" + message);
        sendOneMessage(uid,"hello socket");
    }

    /**
     * 发生错误时调用
     */
    @OnError
    public void onError(Session session, Throwable error) throws IOException {
        System.out.println("连接错误");
        session.close();
        error.printStackTrace();
    }

    // 此为单点消息
    public void sendOneMessage(String userNumber, String message) {
        System.out.println("单点消息: "+message);
        Session session = sessionPool.get(userNumber);
        if (session != null) {
            try {
                session.getAsyncRemote().sendText(message + getOnlineCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // 此为广播消息
    public void sendAllMessage(String message) {
        for (Map.Entry<String,Session> entry:sessionPool.entrySet()) {
            Session session = entry.getValue();
            String user = entry.getKey();
            if (session != null) {
                try {
                    session.getAsyncRemote().sendText(user + " 广播信息：  "  + message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 消息发送
    public void sendMessage(String message){
        try {
            if(sessionPool.size() == 0) return;
            this.session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("发送错误信息", uid,message);
        }
    }

    // synchronized :使用该关键字的作用是为了防止多个线程同时访问
    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    public Session getSession(){
        return session;
    }

    // 获取当前所有连接的客户端对象
    public Map<String,Session> getWebSocketSet() {
        return sessionPool;
    }

}
