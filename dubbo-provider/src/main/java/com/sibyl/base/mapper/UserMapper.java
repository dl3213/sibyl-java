package com.sibyl.base.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sibyl.dubbo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2021/8/4 20:08
 * @Created by dyingleaf3213
 */
@Repository
public interface UserMapper extends BaseMapper<User>{
}
