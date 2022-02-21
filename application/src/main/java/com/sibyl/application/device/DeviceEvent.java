package com.sibyl.application.device;

public interface DeviceEvent extends IEvent{
    void before();
    void after();
}
