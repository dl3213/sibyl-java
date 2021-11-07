package com.sibyl.lembdaStreamFunction;

import java.util.function.*;

/**
 * @Classname FunctionTest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/12 17:14
 */

public class FunctionTest {
    public static void main(String[] args) {
        // 断言
        Predicate<Integer> predicate = i -> i>0;
        //IntPredicate
        System.err.println(predicate.test(-9));

        // 消费
        //IntConsumer
        Consumer<String> consumer = s -> System.err.println(s);
        consumer.accept("input string");

        //
        //Function
        //Supplier
        //UnaryOperator
        //BiFunction
        //BinaryOperator
    }
}
