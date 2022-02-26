package com.sibyl.test.strategy;

/**
 * @Classname Context
 * @Description 策略使用者
 * @Author dyingleaf3213
 * @Create 2021/10/10 20:38
 */

public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}