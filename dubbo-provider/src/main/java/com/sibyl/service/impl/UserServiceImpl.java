package com.sibyl.service.impl;

import com.sibyl.mapper.UserMapper;
import com.sibyl.pojo.User;
import com.sibyl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Date 2021/8/3 20:52
 * @Created by dyingleaf3213
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectById(Long id) {

        return userMapper.selectById(id);
    }
}
