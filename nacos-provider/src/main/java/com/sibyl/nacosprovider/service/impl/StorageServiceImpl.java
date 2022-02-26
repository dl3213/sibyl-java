package com.sibyl.nacosprovider.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sibyl.nacosprovider.service.mapper.StorageMapper;
import com.sibyl.dubbo.comsumer.pojo.Storage;
import com.sibyl.dubbo.provider.service.StorageService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Classname StorageServiceImpl
 * @Description TODO
 * @Date 2021/8/8 2:51
 * @Created by dyingleaf3213
 */
//@Service
@DubboService
@com.alibaba.dubbo.config.annotation.Service
@Component
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    public int saveStorageRecord(Long uid,Long pid) {

        return storageMapper.insert(new Storage().setId(uid).setProductId(pid));
    }

    @Override
    public int updateSto(Long pid, Integer used) {

        LambdaQueryWrapper<Storage> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Storage::getProductId,pid);
        Storage storage = storageMapper.selectOne(lambdaQueryWrapper);

        storage.setTotal(storage.getTotal()-used);
//        int i = 1/0;
        storage.setUsed(storage.getUsed()+used);
        return storageMapper.updateById(storage);
    }
}
