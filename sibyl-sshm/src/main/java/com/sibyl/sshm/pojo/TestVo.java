package com.sibyl.sshm.pojo;

import com.sibyl.base.entity.User;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Classname TestVo
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/27 16:44
 */
@Data
@ToString
public class TestVo {
    private List<User> userList;
}
