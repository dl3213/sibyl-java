package com.sibyl.spring;

import com.sibyl.util.Utils;
import org.springframework.core.task.AsyncListenableTaskExecutor;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;

/**
 * @Classname SimpleAsyncTaskExecutorDemo
 * @Description TODO
 * @Date 2021/8/9 20:45
 * @Created by dyingleaf3213
 */
public class ListenableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AsyncListenableTaskExecutor executor =
                new SimpleAsyncTaskExecutor("ListenableFutureDemo-");

        //ListenableFuture实例
        ListenableFuture<Integer> future = executor.submitListenable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 1;
            }
        });
        //添加callback
        future.addCallback(new ListenableFutureCallback<Integer>() {
            @Override
            public void onFailure(Throwable ex) {
                Utils.prinf(ex);
            }

            @Override
            public void onSuccess(Integer result) {
                Utils.prinf(result);
            }
        });

        future.get();

        future = executor.submitListenable(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 2;
            }
        });
        //添加callback
        future.addCallback(new ListenableFutureCallback<Integer>() {
            @Override
            public void onFailure(Throwable ex) {
                Utils.prinf(ex);
            }

            @Override
            public void onSuccess(Integer result) {
                Utils.prinf(result);
            }
        });

        //future直到计算结束(阻塞)
        future.get();
    }
}
