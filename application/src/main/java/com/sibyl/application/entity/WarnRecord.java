package com.sibyl.application.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

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
    private LocalDateTime createTime;
//    private LocalDateTime updateTime;
}
