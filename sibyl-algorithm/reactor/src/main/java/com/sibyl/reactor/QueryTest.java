package com.sibyl.reactor;

//import io.reactivex.Observable;
//import io.reactivex.schedulers.Schedulers;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.concurrent.*;

/**
 * @Classname ReturnNew
 * @Description TODO
 * @Date 2021/8/11 20:31
 * @Created by dyingleaf3213
 */
public class QueryTest {


    public static void main(String[] args) {
        blockingMode();//阻塞 => 250+
        concurrentMode();//并发 => 150+
        reactiveMode(); // 方法1:400+ just()完全调用A()B() >= 同步阻塞
                        // 方式2：100+

        sleep(100000L);//等待线程结束，查看结果
    }

    //响应式
    public static void reactiveMode(){  //new => reactiveMode(com.sibyl.QueryTest queryTest,Observable<com.sibyl.QueryTest> observable){}
        QueryTest test = new QueryTest();
        Long startTime = System.currentTimeMillis();

        // 与下方写法类似
        // Flowable<Integer[]> flowable = Flowable.just(test.queryA());

        //发布,方法1:错误写法
//        Observable<Integer[]> observableA =
//                Observable.just(test.queryA());
//        Observable<Integer[]> observableB =
//                Observable.just(test.queryB());

        //发布,方法2:
        Observable<Integer[]> observableA =
                Observable.fromCallable(test::queryA);

        observableA
                .subscribeOn(Schedulers.newThread())
                .subscribe();//没有订阅没有执行

        Observable<Integer[]> observableB =
                Observable.fromCallable(test::queryB);

        //流式处理,类似Stream
        //开发人员不需要关注并发或线程池
        observableB
                .subscribeOn(Schedulers.newThread())//决定同步/异步
                .doOnNext(value->{//数据消费正常逻辑

                })
                .doOnError(e->{//数据消费异常逻辑

                })
//                .doOnComplete(()->{ //doOnComplete or doFinally
//                    //执行结束逻辑
//                }
//                )
        ;

        //可合并操作:[1,2,...]+[5,6,...]=[1,...,10]
//        observableA.mergeWith(observableB).forEach();

        Long cost = System.currentTimeMillis() - startTime;
        System.err.println("cost => " + cost);
    }

    //并发
    public static void concurrentMode(){
        QueryTest test = new QueryTest();
        Long startTime = System.currentTimeMillis();

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<Integer[]> futureA = executorService.submit(test::queryA);
        Future<Integer[]> futureB = executorService.submit(test::queryB);

        try {
            futureA.get();//阻塞
            futureB.get();//阻塞
        } catch (Exception e) {
        }


        Long cost = System.currentTimeMillis() - startTime;

        executorService.shutdown();
        System.err.println("cost => " + cost);
    }

    //阻塞
    public static void blockingMode() {
        QueryTest test = new QueryTest();
        Long startTime = System.currentTimeMillis();
        Integer[] a = test.queryA();
        Integer[] b = test.queryB();
        Long cost = System.currentTimeMillis() - startTime;
        System.err.println("cost => " + cost);
    }

    public Integer[] queryA(){
        sleep(100L);
        System.err.println("A is doing => " + Thread.currentThread().getName());
        return of(1,2,3,4,5);
    }

    public Integer[] queryB(){
        sleep(150L);
        System.err.println("B is doing => " + Thread.currentThread().getName());
        return of(6,7,8,9,10);
    }
    public static void sleep(Long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static <T> T[] of(T... value){
        return value;
    }
}
