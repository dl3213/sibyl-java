package com.sibyl.application.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Classname ScheduleConfig
 * @Description TODO
 * @Date 2021/7/25 0:22
 * @Created by dyingleaf3213
 */
@Configuration
@EnableScheduling
public class ScheduleConfig {

    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor(){

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(7);//配置核心线程数
        executor.setMaxPoolSize(10);//配置最大线程数
        executor.setQueueCapacity(15);//配置队列大小
        executor.setThreadNamePrefix("sibyl-worker-");//线程的名称前缀
        //AbortPolicy:丢弃任务并抛出RejectedExecutionException异常
        //DiscardPolicy:丢弃任务，但是不抛出异常。如果线程队列已满，则后续提交的任务都会被丢弃，且是静默丢弃。
        //DiscardOldestPolicy:丢弃队列最前面的任务，然后重新提交被拒绝的任务。
        //CallerRunsPolicy:由调用线程处理该任务
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }
}
