package com.sibyl.dao;

import com.sibyl.pojo.User;
import org.hswebframework.web.dao.CrudDao;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDao
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/14 21:12
 */
@Repository
public interface UserDao extends CrudDao<User,Long> {
}
