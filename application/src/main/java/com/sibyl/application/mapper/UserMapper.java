package com.sibyl.application.mapper;

import com.sibyl.application.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2021/7/27 20:42
 * @Created by dyingleaf3213
 */
@Repository
@Mapper
public interface UserMapper extends BaseDao<User> {
}
