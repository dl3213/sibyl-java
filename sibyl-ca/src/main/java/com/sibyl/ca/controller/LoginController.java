package com.sibyl.ca.controller;

import com.sibyl.base.domain.R;
import com.sibyl.base.entity.User;
import com.sibyl.ca.service.UserLoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname LoginController
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/26 11:25
 */
@RestController
public class LoginController {

    @Resource
    private UserLoginService userLoginService;

    @PostMapping("/user/login")
    public R login(@RequestBody User user){
        return userLoginService.login(user);
    }

    @GetMapping("/user/logout")
    public R logout(){
        return userLoginService.logout();
    }
}
