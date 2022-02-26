package com.sibyl.test.strategy;

/**
 * @Classname OperationSubtract
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/10/10 20:37
 */

public class OperationSubtract implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}