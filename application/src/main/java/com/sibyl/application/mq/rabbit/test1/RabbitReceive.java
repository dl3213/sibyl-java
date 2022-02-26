package com.sibyl.application.mq.rabbit.test1;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * @Classname RabbitReceive
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/17 20:36
 */
@Component
public class RabbitReceive {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "queue-1",durable = "true"),
            exchange = @Exchange(name = "exchange-1",durable = "true",type = "topic",ignoreDeclarationExceptions = "true"),
            key = "springboot.*"
        )
    )
    @RabbitHandler
    public void onMsg(Message message, Channel channel) throws Exception{
        System.err.println("----------");
        System.err.println("get => " + message.getPayload());

        //手工签收
//        Long o = (Long) message.getHeaders().get(AmqpHeaders.DELIVERY_TAG);
//        channel.basicAck(o,false);
    }
}
