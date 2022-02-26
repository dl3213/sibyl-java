package com.sibyl.dubbo.provider.service;

import com.sibyl.dubbo.entity.MeetingPub;

/**
 * @Classname MeetingPubService
 * @Description TODO
 * @Date 2021/8/3 20:56
 * @Created by dyingleaf3213
 */
public interface MeetingPubService {

    public MeetingPub getByPcode(String pcode);
}
