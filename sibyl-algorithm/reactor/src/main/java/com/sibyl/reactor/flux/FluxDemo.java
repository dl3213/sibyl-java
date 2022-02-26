package com.sibyl.reactor.flux;

import com.sibyl.reactor.SimpleDataSourse;
import com.sibyl.reactor.User;
import reactor.core.publisher.Flux;

import java.util.Comparator;

/**
 * @Classname FluxDemo
 * @Description TODO
 * @Date 2021/8/22 19:37
 * @Created by dyingleaf3213
 */
public class FluxDemo {


    /**
     * 根据belongs2分组，获取各组中age最大的一个
     */
    public static Flux<User> getMaxAgeFromUsers(Flux<User> users){
        return users.collectMultimap(User::getBelongs2)
                .flatMapMany(m -> Flux.fromIterable(m.entrySet()))
                .flatMap(e -> Flux.fromIterable(e.getValue())
                        .sort(Comparator.comparing(User::getAge).reversed())
                        .next())
                ;
    }

    public static void main(String[] args) {
        Flux<User> userFlux = getMaxAgeFromUsers(Flux.just(SimpleDataSourse.allUser()));
        userFlux =  userFlux.doOnNext(System.err::println); //重新接收一次
        System.err.println("???");
        userFlux.subscribe();
    }
}
