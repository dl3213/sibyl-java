package com.sibyl.nacosprovider.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @Classname Storage
 * @Description TODO
 * @Date 2021/8/8 2:45
 * @Created by dyingleaf3213
 */
@Data
@Accessors(chain = true)
@TableName("tab_storage")
public class Storage {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
}
