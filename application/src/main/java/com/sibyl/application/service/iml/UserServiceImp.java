package com.sibyl.application.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sibyl.application.mapper.UserMapper;
import com.sibyl.application.entity.User;
import com.sibyl.application.service.UserService;
import com.sibyl.application.service.fun.ConsumerMain;
//import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
//    @Retryable()
    public void userHandler() {
        User byId = selectById(3213L);
        consumerMain.userHandler(byId);
        System.err.println(byId.getName());
    }


    @Override
    public List<User> queryUsers() {
        return userMapper.selectList(null);
    }

    @Override
    public Page<User> pageOfUser() {
        Page<User> userPage = new Page<>(1, 10);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        //queryWrapper.orderBy(true,true,"uid");
        return userMapper.selectPage(userPage,queryWrapper);
    }

    @Override
    public User selectById(Long id) {

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
