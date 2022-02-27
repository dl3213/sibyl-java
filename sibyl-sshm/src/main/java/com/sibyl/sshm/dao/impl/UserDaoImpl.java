package com.sibyl.sshm.dao.impl;

import com.sibyl.base.entity.User;
import com.sibyl.sshm.dao.UserDao;
import lombok.Setter;

import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @Classname UserDaoImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:48
 */
@Setter
public class UserDaoImpl implements UserDao {

    private long id;
    private String username;

    private List<String> iniList;
    private Map<String, User> userMap;
    private Properties properties;

    @Override
    public void save() {
        System.err.println("dao save");
        System.err.println(id + " " +username);
        System.err.println(iniList);
        System.err.println(userMap);
        System.err.println(properties);
    }

    public void init(){
        System.err.println("init...");
    }
    public void destroy(){
        System.err.println("destroy...");
    }
}
