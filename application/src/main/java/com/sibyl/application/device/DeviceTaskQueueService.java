package com.sibyl.application.device;

import lombok.Getter;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Classname DeviceTaskQueueService
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/17 11:19
 */
@Component
public class DeviceTaskQueueService {

    @Getter
    private Map<String, DeviceQueue> map = new ConcurrentHashMap<>();

    @Resource
    private ConfigurableApplicationContext context;

    public void addDeviceTask(DeviceTask task){
        addDeviceTask(task.getDeviceCode(),task);
    }
    public void addDeviceTask(String deviceCode, Object task){

        if(CollectionUtils.isEmpty(getDeviceTaskQueue(deviceCode))){
            map.put(deviceCode,new DeviceQueue(context));
        }
        getDeviceTaskQueue(deviceCode).add(task);
    }

    public Object getDeviceTask(String deviceCode){
        ConcurrentLinkedQueue deviceTaskQueue = getDeviceTaskQueue(deviceCode);
        return CollectionUtils.isEmpty(deviceTaskQueue) ? null : deviceTaskQueue.poll();
    }

    private DeviceQueue getDeviceTaskQueue(String deviceCode){
        return map.get(deviceCode);
    }

}
