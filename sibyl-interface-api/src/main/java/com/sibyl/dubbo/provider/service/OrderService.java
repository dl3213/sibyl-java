package com.sibyl.dubbo.provider.service;

import com.sibyl.dubbo.entity.Order;

/**
 * @Classname OrderService
 * @Description TODO
 * @Date 2021/8/8 3:03
 * @Created by dyingleaf3213
 */
public interface OrderService {
    public Integer saveOrder(Order order);
}
