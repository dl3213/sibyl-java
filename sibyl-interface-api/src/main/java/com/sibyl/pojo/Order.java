package com.sibyl.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * @Classname Order
 * @Description TODO
 * @Date 2021/8/8 2:56
 * @Created by dyingleaf3213
 */
@Data
@Accessors(chain = true)
@ToString
@TableName("tab_order")
public class Order {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer count;
    private BigDecimal money;
    private Integer status;
}
