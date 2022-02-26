package com.sibyl.application.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname BaseEntity
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/25 16:12
 */
@Data
@SuperBuilder(toBuilder = true)
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

    private Integer isDeleted = 0;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime = new Date();

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
}
