package com.sibyl.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/8/3 20:47
 * @Created by dyingleaf3213
 */
@Data
@Accessors(chain = true)
@TableName("sys_user")
public class User implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String telphone;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
}
