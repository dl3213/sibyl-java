package com.sibyl.sshm.service.impl;

import com.sibyl.sshm.dao.UserDao;
import com.sibyl.sshm.service.UserService;
import lombok.Setter;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:09
 */

public class UserServiceImpl implements UserService {

    @Setter
    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.err.println("service save");
        userDao.save();
    }
}
