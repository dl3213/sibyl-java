package com.sibyl.test;

import lombok.Data;
import lombok.ToString;

/**
 * @Classname Item
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/03/14 19:06
 */
@Data
@ToString
public class Item {
    private Integer type;
    private Object key;
    private Object value;
}
