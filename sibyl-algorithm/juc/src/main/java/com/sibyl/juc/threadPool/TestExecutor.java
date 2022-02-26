package com.sibyl.juc.threadPool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Classname TestExecutor
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/23 21:25
 */
@Slf4j
public class TestExecutor {
    public static void main(String[] args) {
        //任务量已知，相对耗时
        ExecutorService pool = Executors.newFixedThreadPool(2, new ThreadFactory() {
            private AtomicInteger t = new AtomicInteger(1);
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r,"newFixedThreadPool-"+ t.getAndIncrement());
            }
        });
        //任务数密集，任务执行时间短
        //ExecutorService pool = Executors.newCachedThreadPool();
        //任务排队执行
//        ExecutorService pool = Executors.newSingleThreadExecutor();
        pool.execute(()->{
            log.debug("1");
            int i = 1/0;
        });
        pool.execute(()->{
            log.debug("2");
        });
        pool.execute(()->{
            log.debug("3");
        });
    }
}
