package com.dl3213.sibyl.sync;

import lombok.extern.slf4j.Slf4j;

/**
 * @Classname SyncTest
 * @Description TODO
 * @Date 2021/8/1 14:42
 * @Created by dyingleaf3213
 */
@Slf4j
public class SyncTest {

    public static void main(String[] args) throws InterruptedException {
        Room room = new Room();
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room){
                    room.plus1();
                }

            }
        },"t1");

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 5000; i++) {
                synchronized (room){
                    room.subs1();
                }

            }
        },"t2");

        t1.start();;
        t2.start();
        t1.join();
        t2.join();

        log.debug(room.getCounter()+ "");

    }



}
//synchronized 修饰方法时，等价于synchronized(this)
//synchronized 修饰static方法时，等价于synchronized(this.class)
class Room{
    private int counter = 0;
    public void plus1(){
        synchronized (this){
            counter ++;
        }
    }
    public void subs1(){
        synchronized (this){
            counter --;
        }
    }

    public int getCounter(){
        synchronized (this){
            return counter;
        }

    }
}