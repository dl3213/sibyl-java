package com.sibyl.application.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import lombok.experimental.Accessors;

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
@EqualsAndHashCode
@Accessors(chain = true)
@ToString(callSuper = true)
public class User extends BaseEntity{
    private Long id;
    private String uid;
    private String name;
    private Integer age;
    private String email;
}
