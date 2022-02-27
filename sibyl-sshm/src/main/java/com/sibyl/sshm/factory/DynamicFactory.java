package com.sibyl.sshm.factory;

import com.sibyl.sshm.service.UserService;
import com.sibyl.sshm.service.impl.UserServiceImpl;

/**
 * @Classname DynamicFactory
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:35
 */

public class DynamicFactory {
    public UserService getUserDao(){
        return new UserServiceImpl();
    }
}
