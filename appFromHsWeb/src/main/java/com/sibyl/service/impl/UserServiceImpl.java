package com.sibyl.service.impl;

import com.sibyl.dao.UserDao;
import com.sibyl.pojo.User;
import com.sibyl.service.UserService;
import org.hswebframework.web.dao.CrudDao;
import org.hswebframework.web.id.IDGenerator;
import org.hswebframework.web.service.GenericEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname UserServiceImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/14 21:17
 */
@Service
public class UserServiceImpl extends GenericEntityService<User,Long>
        implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    protected IDGenerator<Long> getIDGenerator() {
        return IDGenerator.SNOW_FLAKE;
    }

    @Override
    public CrudDao<User, Long> getDao() {
        return userDao;
    }
}
