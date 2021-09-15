package com.sibyl.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hswebframework.web.commons.entity.SimpleGenericEntity;

/**
 * @Classname User
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/14 21:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends SimpleGenericEntity<Long> {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
