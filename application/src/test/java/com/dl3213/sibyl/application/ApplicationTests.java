package com.dl3213.sibyl.application;

import com.dl3213.sibyl.application.task.DynamicTask;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.ZonedDateTime;
import java.util.concurrent.ScheduledFuture;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = Application.class)
@Slf4j
class ApplicationTests {

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;


    @Test
    void contextLoads() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }

}
