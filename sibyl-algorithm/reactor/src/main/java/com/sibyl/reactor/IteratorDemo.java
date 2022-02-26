package com.sibyl.reactor;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname IteratorDemo
 * @Description 迭代器模式：拉模式
 * @Date 2021/8/9 20:27
 * @Created by dyingleaf3213
 */
public class IteratorDemo {

    public static void main(String[] args) {
        //数据源
        List<Integer> valus = Arrays.asList(1,2,3,4,5);

        //迭代
        //消费数据
        Iterator<Integer> iterator = valus.iterator();
        while (iterator.hasNext()){//过程类似向server请求是否还有数据：拉模式
            Integer v = iterator.next();//主动获取数据
            System.err.println(v);

        }
        System.err.println("NULL");
    }
}
