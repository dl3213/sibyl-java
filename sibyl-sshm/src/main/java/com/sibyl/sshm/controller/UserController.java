package com.sibyl.sshm.controller;

import com.sibyl.sshm.entity.User;
import com.sibyl.sshm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * @Classname UserController
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/28 13:09
 */

@Controller //标记为MVC的控制器类，方便DispatcherServlet进行扫描定位
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("/findUser")
    public String findUser(Model model){
        int id = 3213;
        User user = userService.selectById(id);
        model.addAttribute("user", user);
        return "/app/save.jsp";
    }
}