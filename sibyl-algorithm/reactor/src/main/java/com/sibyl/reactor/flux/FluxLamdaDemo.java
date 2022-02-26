package com.sibyl.reactor.flux;

import com.sibyl.reactor.Utils;
import reactor.core.publisher.Flux;

import java.util.Random;

/**
 * @Classname FluxDemo
 * @Description TODO
 * @Date 2021/8/9 21:02
 * @Created by dyingleaf3213
 */
public class FluxLamdaDemo {

    public static void main(String[] args) {

        Random random = new Random();

        Flux<Integer> flux = Flux.just(1,2,3);
        //订阅并输出
        flux.map(value->{
            //当随机数==3抛出异常
            if(random.nextInt() == 3 ){
                throw new RuntimeException("err msg");
            }
            return value + 1;
        }).subscribe(
                Utils::prinf,//处理数据，onNext()
                Utils::prinf,//处理异常，onError()
                ()->{
                    Utils.prinf("subscrition is done! ");
                }
        );
    }
}
