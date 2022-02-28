package com.sibyl.application;

import com.sibyl.Application;
import com.sibyl.application.entity.User;
import com.sibyl.application.entity.WarnRecord;
import com.sibyl.application.mapper.UserMapper;
import com.sibyl.application.mapper.WarnRecordMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.util.DigestUtils;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Classname DbTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/16 21:13
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = Application.class)
@Slf4j
public class DbTest {

    public static void main(String[] args) {

    }

    @Resource
    private WarnRecordMapper warnRecordMapper;
    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;
    @Resource
    private UserMapper userMapper;

    @Resource
    DataSource dataSource;

    @Test
    public void test02(){
        userMapper.getAll().forEach(System.err::println);
    }

    @Test
    public void test01(){
        String s = DigestUtils.md5DigestAsHex(("123456"+"sibyl").getBytes());
        System.err.println(DigestUtils.md5DigestAsHex(s.getBytes()));
    }



    @Test
    public void warnTest111(){

        System.err.println(dataSource.getClass());

        //x(x(8));//18
        //extractedTest();

//        ArrayList<Object> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.remove((Object) 1);
//
//        System.err.println(integers.toString());

        double v = 0.1234;
        float v1 = 0.1234f;
        System.err.println();
    }

    private void extractedTest() {
        try {
            throw new RuntimeException();
            //throw new UnsupportedOperationException();
        }catch (UnsupportedOperationException e){
            System.err.println(1);
        }catch (RuntimeException e){
            System.err.println(2);
        } catch (Exception e){
            System.err.println(3);
        }finally {
            System.err.println(4);
        }
    }


    public int x(int n){
        System.err.println(1);
        if(n<=3) return 1;
        return x(n-2)+ x(n-4) + 1;
    }

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

    @Test
    public void warnTest1(){
        User user = new User().setName("dl3213");
        User user2 = new User().setName("dl3213");
        System.err.println(user == user2);
        System.err.println(user.equals(user2));
        System.err.println(user.hashCode());
        System.err.println(user2.hashCode());

        HashMap<User, Object> map = new HashMap<>();
        map.put(user,"test");
        map.put(user2,"test2");
        System.err.println(map.toString());
    }
}
