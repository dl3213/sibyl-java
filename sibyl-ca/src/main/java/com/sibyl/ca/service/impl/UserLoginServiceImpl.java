package com.sibyl.ca.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.sibyl.base.domain.R;
import com.sibyl.base.entity.User;
import com.sibyl.ca.util.JwtUtil;
import com.sibyl.ca.util.RedisUtil;
import com.sibyl.ca.domain.LoginUser;
import com.sibyl.ca.service.UserLoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @Classname UserLoginServiceImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/26 11:27
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private RedisUtil redisUtil;

    @Override
    public R login(User user) {

        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());

        Authentication authenticate = authenticationManager.authenticate(token);

        Assert.notNull(authenticate,"登录失败");

        LoginUser loginUser = (LoginUser) authenticate.getPrincipal();

        String uid = loginUser.getUser().getUsername();

        String jwt = JwtUtil.createJwt(uid, loginUser.getUser().getUsername(), JSONObject.parseObject(JSONObject.toJSONString(loginUser.getUser())));

        redisUtil.set("login:"+uid, loginUser);

        return R.success(200,"登录成功",jwt);
    }

    @Override
    public R logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Object principal = authentication.getPrincipal();

        LoginUser loginUser = (LoginUser) principal;
        String username = loginUser.getUser().getUsername();
        redisUtil.delete("login:"+username);

        return R.success("注销成功");
    }
}
