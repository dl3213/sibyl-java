package com.sibyl.application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/25 16:12
 */
@Data
@ToString
public class BaseEntity {

    private Integer isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
