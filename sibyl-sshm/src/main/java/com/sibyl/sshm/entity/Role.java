package com.sibyl.sshm.entity;


import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/7/27 22:31
 * @Created by dyingleaf3213
 */
@Entity
@Table(name = "role")
@Data
@ToString
public class Role implements Serializable {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String key;

//    private Set<RoleMenu> menus;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
