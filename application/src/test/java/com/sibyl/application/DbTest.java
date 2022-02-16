package com.sibyl.application;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sibyl.Application;
import com.sibyl.application.entity.WarnRecord;
import com.sibyl.application.mapper.WarnRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

/**
 * @Classname DbTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/16 21:13
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = Application.class)
@Slf4j
public class DbTest {
    @Resource
    private WarnRecordMapper warnRecordMapper;
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void warnTest(){
        LocalDateTime start = LocalDateTime.parse("2021-01-01 00:00:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        LocalDateTime now = LocalDateTime.now();

        while (start.isBefore(now)){
            WarnRecord record = new WarnRecord();
            record.setUid("dl3123");
            record.setPsychoPass((int) (Math.random()*100 +1));
            record.setCreateTime(start);
                    //.setCreateTime(Date.from(start.atZone(ZoneId.systemDefault()).toInstant()));
            warnRecordMapper.insert(record);
            start = start.plusSeconds(1);
        }
    }
}
