package com.sibyl.util;

/**
 * @Classname Utils
 * @Description TODO
 * @Date 2021/8/9 20:49
 * @Created by dyingleaf3213
 */
public class Utils {
    public static void prinf(Object str){
        System.err.printf("[thread: %s ] : %s \n" ,
                Thread.currentThread().getName(),String.valueOf(str));//valuesOf有空值保护
    }
}
