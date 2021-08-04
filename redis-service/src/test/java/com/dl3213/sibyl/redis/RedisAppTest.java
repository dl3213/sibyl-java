package com.dl3213.sibyl.redis;

import com.dl3213.sibyl.redis.pojo.Player;
import com.dl3213.sibyl.redis.util.RedisUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @Classname com.dl3213.sibyl.redis.RedisAppTest
 * @Description TODO
 * @Date 2021/7/29 22:38
 * @Created by dyingleaf3213
 */
@SpringBootTest(classes = RedisApp.class)
public class RedisAppTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void test2(){
        redisUtil.set("name","redisUtil");
        System.err.println(redisUtil.get("name"));
    }

    @SneakyThrows
    @Test
    public void redisTest(){
        System.err.println("****");
        Player player = new Player(1L, "dl3213", "player1");
        String json = new ObjectMapper().writeValueAsString(player);
        redisTemplate.opsForValue().set("player1",json);
        System.err.println(redisTemplate.opsForValue().get("player1"));
    }
}
