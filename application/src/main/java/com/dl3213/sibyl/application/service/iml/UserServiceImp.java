package com.dl3213.sibyl.application.service.iml;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dl3213.sibyl.application.mapper.UserMapper;
import com.dl3213.sibyl.application.pojo.User;
import com.dl3213.sibyl.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<User> getAllUser() {
        return userMapper.selectList(null);
    }

    @Override
    public Page<User> getPageOfUser() {
        Page<User> userPage = new Page<>(1, 2);
        return userMapper.selectPage(userPage,null);
    }
}
