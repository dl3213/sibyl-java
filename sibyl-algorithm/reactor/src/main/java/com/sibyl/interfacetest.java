package com.sibyl;

import java.text.DecimalFormat;
import java.util.function.Function;

/**
 * @Classname interfacetest
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/09/12 17:06
 */

public class interfacetest {
    public static void main(String[] args) {
        MyInput input = new MyInput(9876);
        Function<Integer, String> integerStringFunction = i -> new DecimalFormat("#,###").format(i);
        input.printf(integerStringFunction.andThen(s->"rmb"+s));
    }
}

//interface InputFormat{
//    String format(int i);
//}
class MyInput {
    private final int money;
    public MyInput(int m){
        this.money = m;
    }
    public void printf( Function<Integer,String> inputFormat){
        System.err.println("input: " + inputFormat.apply(this.money));
    }
}