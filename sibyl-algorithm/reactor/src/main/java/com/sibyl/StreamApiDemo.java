package com.sibyl;

import java.util.stream.Stream;

/**
 * @Classname com.sibyl.StreamApiDemo
 * @Description TODO
 * @Date 2021/8/11 21:10
 * @Created by dyingleaf3213
 */
public class StreamApiDemo {

    public static void main(String[] args) {
        // Stream => 1->2->3->...(串行)
        // Stream 运算模式:
        // 串行
        Stream.of(1,2,3,4,5).forEach(System.err::println);
        System.err.println("=================");
        //  并行
        Stream.of(1,2,3,4,5).parallel().forEach(System.err::println);//forEachOrdered
    }
}
