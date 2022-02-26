package com.sibyl.dubbo.comsumer.pojo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Classname MeetingPub
 * @Description TODO
 * @Date 2021/8/3 20:54
 * @Created by dyingleaf3213
 */
@Data
@Accessors(chain = true)
public class MeetingPub implements Serializable {
    private Long id;
    private String pCode;
    private String title;
    private String content;
    private Long uid;
    private User user;
}
