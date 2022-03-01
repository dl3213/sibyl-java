package com.sibyl.sshm.service.impl;

import com.sibyl.sshm.hbmDao.RoleDao;
import com.sibyl.sshm.entity.Role;
import com.sibyl.sshm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname RoleServiceImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/03/01 13:53
 */
@Service("roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role findById(int id) {
        Role bookById = roleDao.findBookById(id);
        System.err.println(bookById);
        return bookById;
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }
}
