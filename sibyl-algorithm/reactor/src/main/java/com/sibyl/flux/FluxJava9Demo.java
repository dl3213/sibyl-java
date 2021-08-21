package com.sibyl.flux;

import com.sibyl.util.Utils;

import java.util.Random;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

/**
 * @Classname FluxJava9Demo
 * @Description java9以上
 * @Date 2021/8/9 21:28
 * @Created by dyingleaf3213
 */
public class FluxJava9Demo {

    public static void main(String[] args) throws InterruptedException {

        //发布者
        try(SubmissionPublisher<String> publisher = new SubmissionPublisher<>()){
            //订阅
            publisher.subscribe(new StringSubscriber("a"));
            publisher.subscribe(new StringSubscriber("b"));
            publisher.subscribe(new StringSubscriber("c"));

            //发布
            publisher.submit("hello,world");
        }
        //主线程等待
        Thread.currentThread().join(2*1000L);

    }


    //订阅者
    private static class StringSubscriber implements Flow.Subscriber<String>{

        private final String name;
        private Flow.Subscription subscription;
        private static final Random random = new Random();

        private StringSubscriber(String name) {
            this.name = name;
        }


        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            Utils.prinf("订阅者["+ name+"] start publishing");
            //向服务器反向请求
            subscription.request(1);
            this.subscription = subscription;
        }

        @Override
        public void onNext(String item) {
            Utils.prinf("订阅者["+ name+"] accept data => " + item);
            if(random.nextBoolean()){
                subscription.cancel();//之后不会到onComplete
            }else {
                throw new RuntimeException();
            }

        }

        @Override
        public void onError(Throwable throwable) {
            Utils.prinf("订阅者["+ name+"] 订阅 异常：" + throwable.getMessage());
        }

        @Override
        public void onComplete() {
            Utils.prinf("订阅者["+ name+"] 完成 publishing");
        }
    }
}
