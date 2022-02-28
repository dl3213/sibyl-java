package com.sibyl.sshm.service.impl;

import com.sibyl.sshm.dao.UserDao;
import com.sibyl.sshm.entity.User;
import com.sibyl.sshm.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:09
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserDao userDao;

    @Override
    public User selectById(int id) {
        return userDao.findUserById(id);
    }
}
