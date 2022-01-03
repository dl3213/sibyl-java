package com.sibyl.application.service.fun;

import com.sibyl.application.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

/**
 * @Classname ConsumerMain
 * @Description 消费者
 * @Author dyingleaf3213
 * @Create 2021/11/07 17:40
 */
@Component
public class ConsumerMain {

    public User userHandler(User user) {
        method(user,(u)->{
            System.err.println("handlering ......");
            System.err.println(u);
        });
        return user;
    }

    public void method(User user, Consumer<User> consumer){
        consumer.accept(user);
    }
}
