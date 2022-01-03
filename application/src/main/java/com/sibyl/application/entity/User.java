package com.sibyl.application.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/7/27 22:31
 * @Created by dyingleaf3213
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@TableName("user")
public class User {
    private Long id;
    private String uid;
    private String name;
    private Integer age;
    private String email;
}
