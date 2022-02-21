package com.sibyl.application.device;

import lombok.Data;

/**
 * @Classname DeviceEventImpl
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/17 12:26
 */
@Data
public class DeviceEventImpl implements DeviceEvent {

    private IListener listener;
    private boolean before = false;
    private boolean after = false;

    public DeviceEventImpl() {
    }

    public DeviceEventImpl(IListener listener) {
        this.listener = listener;
    }

    public void doBefore(){
        if(before){
            before();
        }
    }
    public void doAfter(){
        System.err.println("wei?");
        System.err.println(listener);
        listener.doEvent(this);
        if(after){
            after();
        }
    }

    @Override
    public void setListener(IListener listener) {

    }

    @Override
    public void before() {
        System.err.println("before......");
    }

    @Override
    public void after() {
        System.err.println("after......");
    }
}
