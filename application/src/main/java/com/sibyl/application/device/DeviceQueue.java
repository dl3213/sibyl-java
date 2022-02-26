package com.sibyl.application.device;

import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @Classname DeviceQueue
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/02/17 12:14
 */

public class DeviceQueue extends ConcurrentLinkedQueue<Object> {

    private ConfigurableApplicationContext context;

    //监听器
    private DeviceListener deviceListener;
    //事件源
    private DeviceEventImpl event = new DeviceEventImpl();

    public DeviceQueue() {
    }

    public DeviceQueue(DeviceListener taskQueueListener) {
        this.deviceListener = taskQueueListener;
        event.setListener(taskQueueListener);
    }


    public DeviceQueue(ConfigurableApplicationContext context) {
        this.context = context;
    }

    @Override
    public boolean add(Object o) {
        //event.doBefore();
        boolean add = super.add(o);
        //event.doAfter();
        context.publishEvent(new MyApplicationEvent(new Object()));
        return add;
    }

    @Override
    public boolean offer(Object o) {
        return super.offer(o);
    }

    @Override
    public Object poll() {
        //event.doBefore();
        Object poll = super.poll();
        //event.doAfter();
        return poll;
    }

    @Override
    public Object peek() {
        return super.peek();
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

    @Override
    public int size() {
        return super.size();
    }

    @Override
    public boolean contains(Object o) {
        return super.contains(o);
    }

    @Override
    public boolean remove(Object o) {
        return super.remove(o);
    }

    @Override
    public boolean addAll(Collection<?> c) {
        return super.addAll(c);
    }
}
