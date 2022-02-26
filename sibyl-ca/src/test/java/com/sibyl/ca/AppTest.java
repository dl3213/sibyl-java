package com.sibyl.ca;

import com.sibyl.ca.mapper.MenuMapper;
import com.sibyl.ca.mapper.UserMapper;
import com.sibyl.ca.util.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Classname AppTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/26 10:16
 */

@SpringBootTest
public class AppTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private MenuMapper menuMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test(){
        System.err.println(menuMapper.selectKeysByUserId(3213L));

        //userMapper.selectList(null).forEach(System.err::println);
//        System.err.println(redisUtil);
//        redisUtil.set("test", LocalDateTime.now());
    }
}
