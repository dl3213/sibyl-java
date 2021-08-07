package com.sibyl.nacosconsumer.service;

import com.sibyl.nacosconsumer.pojo.Order;
import org.springframework.stereotype.Service;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2021/8/8 3:03
 * @Created by dyingleaf3213
 */
public interface OrderService {
    public Integer saveOrder(Order order);
}
