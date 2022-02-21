package com.sibyl.application.mq.rabbit.test1;

import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate.ConfirmCallback;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.UUID;

/**
 * @Classname RabbitSender
 * @Description https://blog.csdn.net/lt326030434/article/details/107162309/
 * @Author dyingleaf3213
 * @Create 2022/02/17 20:04
 */
@Component
public class RabbitSender {

    @Resource
    private RabbitTemplate rabbitTemplate;

    final RabbitTemplate.ConfirmCallback confirmCallback = new ConfirmCallback(){

        @Override
        public void confirm(CorrelationData correlationData, boolean ack, String cause) {
            System.err.println("rabbit ack=>"+ ack + " " + correlationData.getId());
        }
    };

    public void send(Object message , Map<String,Object> properties)throws Exception{
        MessageHeaders headers = new MessageHeaders(properties);
        Message<?> msg = MessageBuilder.createMessage(message,headers);
        rabbitTemplate.setConfirmCallback(confirmCallback);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        MessagePostProcessor mpp = new MessagePostProcessor() {

            @Override
            public org.springframework.amqp.core.Message postProcessMessage(org.springframework.amqp.core.Message message) throws AmqpException {
                System.err.println(" ==> post to do : " + message);
                return message;
            }
        };
        rabbitTemplate.convertAndSend("exchange-1","springboot.rabbit",msg,mpp,correlationData);
    }
}
