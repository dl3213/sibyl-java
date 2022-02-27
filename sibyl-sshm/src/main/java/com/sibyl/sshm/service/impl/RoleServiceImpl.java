package com.sibyl.sshm.service.impl;

import com.sibyl.sshm.dao.RoleDao;
import com.sibyl.sshm.service.RoleService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:09
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Value("${jdbc.url}")
    private String username;

    @Resource
    private RoleDao roleDao;

    @Override
    public void saveRole() {
        System.err.println(username);
        System.err.println("service saveRole ");
        roleDao.saveRole();
    }
}
