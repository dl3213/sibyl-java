package com.sibyl.sshm.dao;

import com.sibyl.sshm.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserDao
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 12:47
 */
@Repository
public interface UserDao {
//    @Select("SELECT * FROM user WHERE id = #{id}")
    User findUserById(int id);
}
