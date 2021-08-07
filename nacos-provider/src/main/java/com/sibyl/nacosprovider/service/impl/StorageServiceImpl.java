package com.sibyl.nacosprovider.service.impl;

import com.sibyl.nacosprovider.mapper.StorageMapper;
import com.sibyl.nacosprovider.pojo.Storage;
import com.sibyl.nacosprovider.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Classname StorageServiceImpl
 * @Description TODO
 * @Date 2021/8/8 2:51
 * @Created by dyingleaf3213
 */
@Service
public class StorageServiceImpl implements StorageService {

    @Autowired
    private StorageMapper storageMapper;

    @Override
    public int saveStorageRecord(Long uid,Long pid) {
        return storageMapper.insert(new Storage().setId(uid).setProductId(pid));
    }
}
