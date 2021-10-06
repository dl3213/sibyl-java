package com.sibyl;

/**
 * @Classname MainTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/10/06 22:15
 */

public class MainTest {
    static final int SHARED_SHIFT   = 16;
    static final int SHARED_UNIT    = (1 << SHARED_SHIFT);
    static final int MAX_COUNT      = (1 << SHARED_SHIFT) - 1;
    static final int EXCLUSIVE_MASK = (1 << SHARED_SHIFT) - 1;

    public static void main(String[] args) {
        //整型是占用四个字节32位
        Integer i = 1024000;//
        int ib = 0b11111111111111110000000000000000;
        System.err.println(ib);
        System.err.println(Integer.toBinaryString(ib));
        System.err.println(Integer.toBinaryString(ib >>> (0x10))); //取高16位
        System.err.println(Integer.toBinaryString(ib & (0xffff+1))); //取低16位

        System.err.println("NULL");
    }

    static int sharedCount(int c)    { return c >>> SHARED_SHIFT; }
    static int exclusiveCount(int c) { return c & EXCLUSIVE_MASK; }
}
