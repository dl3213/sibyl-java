package com.sibyl.sync8;

import lombok.extern.slf4j.Slf4j;

/**
 * @Classname SyncTest8
 * @Description TODO
 * @Date 2020/8/28 21:59
 * @Created by dyingleaf3213
 */
public class SyncTest8 {

}
@Slf4j
class Number8{
    public static synchronized void a(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("a");
    }
    public static synchronized void b(){
        log.debug("b");
    }
    // ab  两者锁的对象相同
    public static void main(String[] args) {
        Number8 number81 = new Number8();
        Number8 number82 = new Number8();
        new Thread(()->{ Number8.a(); }).start();
        new Thread(()->{ Number8.b(); }).start();
    }
}

@Slf4j
class Number7{
    public static synchronized void a(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("a");
    }
    public synchronized void b(){
        log.debug("b");
    }
    // ba 两者锁的对象不同，不会互斥
    public static void main(String[] args) {
        Number7 number71 = new Number7();
        Number7 number72 = new Number7();
        new Thread(()->{ Number7.a(); }).start();
        new Thread(()->{ number72.b(); }).start();
    }
}

@Slf4j
class Number6{
    public static synchronized void a(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("a");
    }
    public static synchronized void b(){
        log.debug("b");
    }
    // ab? 两者锁的对象相同
    public static void main(String[] args) {
        Number6 number6 = new Number6();
        new Thread(()->{ Number6.a(); }).start();
        new Thread(()->{ Number6.b(); }).start();
    }
}

@Slf4j
class Number5{
    public static synchronized void a(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("a");
    }
    public synchronized void b(){
        log.debug("b");
    }
    // ba 两者锁的对象不同，不会互斥
    public static void main(String[] args) {
        Number5 number5 = new Number5();
        new Thread(()->{ Number5.a(); }).start();
        new Thread(()->{ number5.b(); }).start();
    }
}


@Slf4j
class Number4{
    public synchronized void a(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("a");
    }
    public synchronized void b(){
        log.debug("b");
    }
    // ba 两者锁的对象不同，不会互斥
    public static void main(String[] args) {
        Number4 number41 = new Number4();
        Number4 number42 = new Number4();
        new Thread(()->{ number41.a(); }).start();
        new Thread(()->{ number42.b(); }).start();
    }
}

@Slf4j
class Number3{
    public synchronized void a(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("a");
    }
    public synchronized void b(){
        log.debug("b");
    }
    public void c(){
        log.debug("c");
    }
    // cab bca cba
    public static void main(String[] args) {
        Number3 number3 = new Number3();
        new Thread(()->{ number3.a(); }).start();
        new Thread(()->{ number3.b(); }).start();
        new Thread(()->{ number3.c(); }).start();
    }
}

@Slf4j
class Number2{
    public synchronized void a(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("a");
    }
    public synchronized void b(){
        log.debug("b");
    }
    // a->b 小概率 b->a
    public static void main(String[] args) {
        Number2 number2 = new Number2();
        new Thread(()->{ number2.a(); }).start();
        new Thread(()->{ number2.b(); }).start();
    }
}

@Slf4j
class Number1{
    public synchronized void a(){
        log.debug("a");
    }
    public synchronized void b(){
        log.debug("b");
    }
    // a->b 小概率 b->a
    public static void main(String[] args) {
        Number1 number1 = new Number1();
        new Thread(()->{ number1.a(); }).start();
        new Thread(()->{ number1.b(); }).start();
    }
}