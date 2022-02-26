package com.sibyl.reactor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @Classname User
 * @Description TODO
 * @Date 2021/8/22 19:38
 * @Created by dyingleaf3213
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer belongs2;
}
