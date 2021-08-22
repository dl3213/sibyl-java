package com.dl3213.sibyl.application;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dl3213.sibyl.Application;
import com.dl3213.sibyl.application.base.CommonBeanUtils;
import com.dl3213.sibyl.application.mapper.UserMapper;
import com.dl3213.sibyl.application.pojo.User;
import com.dl3213.sibyl.application.service.iml.UserServiceImp;
import com.dl3213.sibyl.application.vo.UserVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,classes = Application.class)
@Slf4j
class ApplicationTests {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserServiceImp userServiceImp;

    @Test
    public void funTest(){
        List<User> allUser = userServiceImp.getAllUser();
        User user = allUser.stream().max(Comparator.comparing(User::getAge)).get();
        System.err.println(user);
    }

    @Test
    public void sqlTest(){
        List<UserVo> userVoList = new ArrayList<>();

        Page<User> users = userServiceImp.getPageOfUser();
        users.getRecords().forEach(item ->{
            System.err.println(item.getName());
        });
        final List<UserVo> userVos =
                CommonBeanUtils.copyListProperties(users.getRecords(), UserVo.class);
        System.err.println("");
    }

    @Test
    void contextLoads() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime);
    }

}
