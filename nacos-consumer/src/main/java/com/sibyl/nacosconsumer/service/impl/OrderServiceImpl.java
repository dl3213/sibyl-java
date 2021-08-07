package com.sibyl.nacosconsumer.service.impl;

import com.sibyl.nacosconsumer.mapper.OrderMapper;
import com.sibyl.nacosconsumer.pojo.Order;
import com.sibyl.nacosconsumer.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Classname OrderServiceImpl
 * @Description TODO
 * @Date 2021/8/8 3:03
 * @Created by dyingleaf3213
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    @Transactional
    @GlobalTransactional
    public Integer saveOrder(Order order) {
        log.info("order start ===>");
        int insert = orderMapper.insert(order);
//        storageService.
        log.info("order end ===>");
        return insert;
    }
}
