package com.sibyl.sshm;

import com.sibyl.sshm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * @Classname SpringTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:21
 */

@RunWith(SpringJUnit4ClassRunner.class)  //进行测试要使用的工具
@ContextConfiguration("classpath:spring-mybatis.xml") //指定配置所在位置
public class SpringTest {

    @Resource
    private UserService userService;

    @Test
    public void test6() throws IOException {
        System.err.println(userService.selectById(3210));
        System.err.println(userService.selectById(3213));
    }

}
