package com.sibyl.ca.redis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @Classname Player
 * @Description TODO
 * @Date 2021/7/29 22:48
 * @Created by dyingleaf3213
 */
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Accessors(chain = true)
public class Player implements Serializable {
    private Long id;
    private String pid;
    private String pname;
}
