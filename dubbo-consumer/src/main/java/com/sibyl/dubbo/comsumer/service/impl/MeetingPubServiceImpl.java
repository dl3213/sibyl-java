package com.sibyl.dubbo.comsumer.service.impl;

import com.sibyl.dubbo.provider.service.MeetingPubService;
import com.sibyl.base.mapper.MeetingPubMapper;
import com.sibyl.dubbo.entity.MeetingPub;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname MeetingPubServiceImpl
 * @Description TODO
 * @Date 2021/8/3 20:57
 * @Created by dyingleaf3213
 */
@Service
public class MeetingPubServiceImpl implements MeetingPubService {

    @Resource
    private MeetingPubMapper meetingPubMapper;

    @Override
    public MeetingPub getByPcode(String pcode) {
        MeetingPub meetingPub = new MeetingPub();
//        meetingPub.setId(10001L);
//        meetingPub.setPCode(pcode);
//        meetingPub.setTitle("dubbo learn");
//        meetingPub.setContent("using dubbo");
//        meetingPub.setUid(1L);

        return meetingPub;
    }
}
