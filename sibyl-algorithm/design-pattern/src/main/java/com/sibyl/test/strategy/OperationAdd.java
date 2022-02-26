package com.sibyl.test.strategy;

/**
 * @Classname OperationAdd
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/10/10 20:37
 */

public class OperationAdd implements Strategy{
    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
