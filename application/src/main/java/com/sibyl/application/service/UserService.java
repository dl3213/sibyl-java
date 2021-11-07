package com.sibyl.application.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.sibyl.application.pojo.User;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * @Classname UserService
 * @Description TODO
 * @Date 2021/7/27 20:42
 * @Created by dyingleaf3213
 */
public interface UserService {

    void userHandler();

    List<User> getAllUser();

    Page<User> getPageOfUser();

    User findById(Long id);

    void test();
}
