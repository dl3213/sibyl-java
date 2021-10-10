package com.sibyl.strategy;

/**
 * @Classname OperationMultiply
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/10/10 20:38
 */

public class OperationMultiply implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 * num2;
    }
}
