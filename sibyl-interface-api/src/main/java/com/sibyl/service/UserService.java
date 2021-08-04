package com.sibyl.service;

import com.sibyl.pojo.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/8/3 20:51
 * @Created by dyingleaf3213
 */
public interface UserService {

    public User selectById(Long id);
}
