package com.sibyl.sshm.entity;


import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/7/27 22:31
 * @Created by dyingleaf3213
 */
//@Entity
//@Table(name = "role_menu")
@Data
@ToString
public class RoleMenu implements Serializable {

    private Long id;

    private Long roleId;
    private Long menuId;

//    private Role role;


}
