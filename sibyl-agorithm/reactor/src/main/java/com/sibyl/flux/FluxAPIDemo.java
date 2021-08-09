package com.sibyl.flux;

import com.sibyl.util.Utils;
import reactor.core.publisher.Flux;

import java.util.Random;

/**
 * @Classname FluxAPIDemo
 * @Description TODO
 * @Date 2021/8/9 21:10
 * @Created by dyingleaf3213
 */
public class FluxAPIDemo {

    public static void main(String[] args) {

        Random random = new Random();

        Flux.generate(()->0,(value,sink)->{
            if(value == 3){
                sink.complete();//主动完成
            }else {
                sink.next("value => " + value);
            }
            return value+1;
        }).subscribe(Utils::prinf,Utils::prinf,()->{
            Utils.prinf("sub is done !");
        });
    }
}
