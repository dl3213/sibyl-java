package com.sibyl.ca.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sibyl.base.entity.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Classname UserMapper
 * @Description TODO
 * @Date 2021/7/27 20:42
 * @Created by dyingleaf3213
 */
@Repository
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectKeysByUserId(Long uid);
}
