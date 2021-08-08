package com.sibyl.nacosprovider.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sibyl.nacosprovider.mapper.StorageMapper;
import com.sibyl.nacosprovider.service.impl.StorageServiceImpl;
import com.sibyl.pojo.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname ProviderController
 * @Description TODO
 * @Date 2021/8/8 2:52
 * @Created by dyingleaf3213
 */
@RestController
public class ProviderController {

    @Autowired
    private StorageServiceImpl storageService;

    @RequestMapping("/stodb")
    public Integer stodb(Long pid,Integer used){
        return storageService.updateSto(pid,used);
    }
}
