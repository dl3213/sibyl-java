package com.sibyl.nacosconsumer.service.impl;

import com.sibyl.dubbo.provider.service.OrderService;
import com.sibyl.nacosconsumer.service.mapper.OrderMapper;
import com.sibyl.dubbo.comsumer.pojo.Order;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
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
