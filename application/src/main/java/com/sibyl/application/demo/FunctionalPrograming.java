package com.sibyl.application.demo;

import java.util.Arrays;
import java.util.List;

/**
 * @Classname FunctionalPrograming
 * @Description TODO
 * @Date 2021/8/22 19:28
 * @Created by dyingleaf3213
 */
public class FunctionalPrograming {


    public static void main(String[] args) {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
//        integers.forEach(i->{
//            if(i<3) System.err.println(i);
//            return;
//        });
        for (int i : integers) {
            if(i < 3) {
                System.err.println(i);
                return;
            }
            System.err.println(i);
        }

    }
}
