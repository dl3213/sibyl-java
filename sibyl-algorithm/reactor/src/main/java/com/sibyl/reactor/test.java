package com.sibyl.reactor;

import java.util.stream.IntStream;

/**
 * @Classname test
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/12 15:26
 */

public class test {
    public static void main(String[] args) {
        int[] ints = {1, 6, 8, 2, 4, 7, 9, -12, 22, 33};
        int min = IntStream.of(ints).parallel().min().getAsInt();
        System.err.println(min);

        TestInterface i1 = (i)-> i*2;
        TestInterface i2 = i-> i*2;
        TestInterface i3 = (int i)-> i*2;
        TestInterface i4 = (int i)->{
            System.err.println("-----");
            return  i*2;
        };
    }
}
@FunctionalInterface
interface TestInterface {
    int getNum(int i);
}