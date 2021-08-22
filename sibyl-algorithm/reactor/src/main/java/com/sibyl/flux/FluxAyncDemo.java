package com.sibyl.flux;


import com.sibyl.Utils;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

/**
 * @Classname FluxAyncDemo
 * @Description TODO
 * @Date 2021/8/9 21:16
 * @Created by dyingleaf3213
 */
public class FluxAyncDemo {
    public static void main(String[] args) throws InterruptedException {
        //当前线程执行
//        Flux.range(0,10)
//                .publishOn(Schedulers.immediate())
//                .subscribe(Utils::prinf);

        //单线程异步执行
//        Flux.range(0,10)
//                .publishOn(Schedulers.single())
//                .subscribe(Utils::prinf);

        //弹性线程池异步执行
//        Flux.range(0,10)
//                .publishOn(Schedulers.elastic())
//                .subscribe(Utils::prinf);

        //并行线程池异步执行
        Flux.range(0,10)
                .publishOn(Schedulers.parallel())
                .subscribe(Utils::prinf);

        //强制让主线程执行完毕
        Thread.currentThread().join(1* 1000L);
    }
}
