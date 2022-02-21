package com.sibyl.application.mq.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname KafkaController
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/16 20:45
 */
@RestController("/kafka")
public class KafkaController {

    private final static String TOPIC_NAME = "zhTest"; //topic的名称

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @RequestMapping("/send")
    public void send() {
        //发送功能就一行代码~
        kafkaTemplate.send(TOPIC_NAME,  "key", "test message send~");
    }
    @RequestMapping("/send2")
    public void send2() {
        //发送功能就一行代码~
        kafkaTemplate.send(TOPIC_NAME,  "key", "test message send~")
                .addCallback(success->{
                    System.err.println("success");
                },failure->{
                    System.err.println("failure");
                });
    }

    //kafka的监听器，topic为"zhTest"，消费者组为"zhTestGroup"
    @KafkaListener(topics = "zhTest", groupId = "sibyl")
    public void listenZhugeGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.err.println("get");
        System.out.println(value);
        System.out.println(record);
        //手动提交offset
        ack.acknowledge();
    }

    /*//配置多个消费组
    @KafkaListener(topics = "zhTest",groupId = "sibyl2")
    public void listenTulingGroup(ConsumerRecord<String, String> record, Acknowledgment ack) {
        String value = record.value();
        System.out.println(value);
        System.out.println(record);
        ack.acknowledge();
    }*/
}
