package com.sibyl.controller;

import com.sibyl.pojo.User;
import com.sibyl.service.UserService;
import org.hswebframework.web.commons.entity.param.QueryParamEntity;
import org.hswebframework.web.controller.SimpleGenericEntityController;
import org.hswebframework.web.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Classname UserController
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/14 21:20
 */
@RestController
@RequestMapping("/user")
public class UserController implements SimpleGenericEntityController<User, Long, QueryParamEntity> {
    @Autowired
    private UserService userService;

    @Override
    public CrudService<User, Long> getService() {
        return userService;
    }

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.select();
    }
}
