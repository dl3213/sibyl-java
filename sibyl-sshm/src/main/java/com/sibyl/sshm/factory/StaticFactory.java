package com.sibyl.sshm.factory;

import com.sibyl.sshm.service.UserService;
import com.sibyl.sshm.service.impl.UserServiceImpl;

/**
 * @Classname StaticFactory
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:32
 */

public class StaticFactory {
    public static UserService getUserDao(){
        return new UserServiceImpl();
    }
}
