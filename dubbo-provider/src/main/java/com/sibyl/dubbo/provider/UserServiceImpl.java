package com.sibyl.dubbo.provider;

import com.sibyl.dubbo.comsumer.pojo.User;
import com.sibyl.dubbo.provider.service.UserService;
import com.sibyl.base.mapper.UserMapper;
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
