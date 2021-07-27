package com.dl3213.sibyl.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dl3213.sibyl.application.pojo.User;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/7/27 20:42
 * @Created by dyingleaf3213
 */
public interface UserService {

    Page<User> getBy();
}
