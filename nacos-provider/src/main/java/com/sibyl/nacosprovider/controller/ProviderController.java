package com.sibyl.nacosprovider.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.sibyl.nacosprovider.mapper.StorageMapper;
import com.sibyl.nacosprovider.pojo.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @Classname ProviderController
 * @Description TODO
 * @Date 2021/8/8 2:52
 * @Created by dyingleaf3213
 */
@RestController
public class ProviderController {

    @Autowired
    private StorageMapper storageMapper;

    @RequestMapping("/orderCreate")
    public Integer orderCreate(Long pid,Integer used){

        LambdaQueryWrapper<Storage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Storage::getProductId,pid);
        Storage storage = storageMapper.selectOne(lambdaQueryWrapper);

        storage.setTotal(storage.getTotal()-used);
//        int i = 1/0;
        storage.setUsed(storage.getUsed()+used);

        return storageMapper.updateById(storage);
    }
}
