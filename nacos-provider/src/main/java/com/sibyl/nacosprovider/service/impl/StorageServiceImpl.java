package com.sibyl.nacosprovider.service.impl;

import com.sibyl.dubbo.provider.service.StorageService;
import com.sibyl.nacosprovider.service.mapper.StorageMapper;
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

        return 1;
    }

    @Override
    public int updateSto(Long pid, Integer used) {

        return 1;
    }
}
