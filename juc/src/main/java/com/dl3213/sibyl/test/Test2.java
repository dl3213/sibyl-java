package com.dl3213.sibyl.test;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Classname Test2
 * @Description TODO
 * @Date 2021/8/1 12:33
 * @Created by dyingleaf3213
 */
@Slf4j
public class Test2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                log.debug("running .....");
                Thread.sleep(2000);
                return 100;
            }
        });

        Thread t1 = new Thread(task,"task");
        t1.start();

        log.debug("{}" ,task.get());
    }
}
