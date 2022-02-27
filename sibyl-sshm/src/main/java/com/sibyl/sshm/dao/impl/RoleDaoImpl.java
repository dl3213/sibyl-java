package com.sibyl.sshm.dao.impl;

import com.sibyl.sshm.dao.RoleDao;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:48
 */
@Repository("roleDao")
public class RoleDaoImpl implements RoleDao {

    @Override
    public void saveRole() {
        System.err.println("dao saveRole ");
    }
}
