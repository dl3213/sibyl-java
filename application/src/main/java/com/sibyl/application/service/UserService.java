package com.sibyl.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sibyl.application.pojo.User;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/7/27 20:42
 * @Created by dyingleaf3213
 */
public interface UserService {

    List<User> getAllUser();

    Page<User> getPageOfUser();

    User findById(Long id);
}