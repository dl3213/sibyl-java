package com.dl3213.sibyl.application.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dl3213.sibyl.application.mapper.UserMapper;
import com.dl3213.sibyl.application.pojo.User;
import com.dl3213.sibyl.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImp
 * @Description TODO
 * @Date 2021/7/27 20:42
 * @Created by dyingleaf3213
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Page<User> getBy() {

        LambdaQueryWrapper<User> userLambdaQueryWrapper = Wrappers.lambdaQuery();
        Page<User> userPage = new Page<>(1, 2);
        LambdaQueryWrapper<Object> objectLambdaQueryWrapper = Wrappers.lambdaQuery();
        return userMapper.selectPage(userPage,null);
    }
}
