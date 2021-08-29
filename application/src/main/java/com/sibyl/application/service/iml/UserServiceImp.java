package com.sibyl.application.service.iml;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sibyl.application.mapper.UserMapper;
import com.sibyl.application.pojo.User;
import com.sibyl.application.service.UserService;
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

    @Override
    public User findById(Long id) {
        return userMapper.selectById(id);
    }
}
