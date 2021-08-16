package com.sibyl.utils;

/**
 * @Classname Utils
 * @Description TODO
 * @Date 2021/8/16 20:21
 * @Created by dyingleaf3213
 */
public class Utils {
    public static void prinf(Object value){
        System.err.printf("[thread:%s] %s \n",Thread.currentThread().getName(),value);
    }
}
