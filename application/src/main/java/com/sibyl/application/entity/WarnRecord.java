package com.sibyl.application.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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
@TableName("warn_record")
public class WarnRecord {
    private Long id;
    private String uid;
    private Integer psychoPass;
    private Date createTime;
//    private LocalDateTime updateTime;
}
