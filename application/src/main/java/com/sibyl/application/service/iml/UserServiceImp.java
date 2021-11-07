package com.sibyl.application.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sibyl.application.mapper.UserMapper;
import com.sibyl.application.pojo.User;
import com.sibyl.application.service.FunctionHandler;
import com.sibyl.application.service.UserService;
import com.sibyl.application.service.fun.ConsumerMain;
import org.apache.xmlbeans.impl.xb.xsdschema.Attribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.management.Query;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Handler;

/**
 * @Classname UserServiceImp
 * @Description TODO
 * @Date 2021/7/27 20:42
 * @Created by dyingleaf3213
 */
@Service
public class UserServiceImp implements UserService {

    @Resource
    private UserMapper userMapper;
    @Resource
    private ConsumerMain consumerMain;

    @Override
    public void userHandler() {
        User byId = findById(3213L);
        consumerMain.userHandler(byId);
        System.err.println(byId.getName());
    }


    @Override
    public List<User> getAllUser() {
        return userMapper.selectList(null);
    }

    @Override
    public Page<User> getPageOfUser() {
        Page<User> userPage = new Page<>(1, 10);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderBy(true,true,"uid");
        return userMapper.selectPage(userPage,queryWrapper);
    }

    @Override
    public User findById(Long id) {

        try {
            //int i = 1/0;
        }catch (Exception e){
            User user = new User();
            user.setName("err");
            return user;
        }

        return userMapper.selectById(id);
    }

    @Override
    @Async
    public void test(){
        try{
            System.err.println("@Async");
            Thread thread = Thread.currentThread();
            System.err.println(thread.toString());
            Thread.sleep(3000);
        }catch (Exception e){

        }
    }
}
