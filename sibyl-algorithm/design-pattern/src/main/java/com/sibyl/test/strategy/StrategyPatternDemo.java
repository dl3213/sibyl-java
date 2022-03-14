package com.sibyl.test.strategy;

import com.sibyl.test.Item;
import com.sibyl.test.strategy.item.ItemCheck;
import com.sibyl.test.strategy.item.ItemOperation;
import com.sibyl.test.strategy.item.ItemSeek;

/**
 * @Classname StrategyPatternDemo
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2021/10/10 20:38
 */

public class StrategyPatternDemo {
    public static void main(String[] args) {
//        Context context = new Context(new OperationAdd());
//        System.out.println("10 + 5 = " + context.execute(10, 5));
//
//        context = new Context(new OperationSubtract());
//        System.out.println("10 - 5 = " + context.execute(10, 5));
//
//        context = new Context(new OperationMultiply());
//        System.out.println("10 * 5 = " + context.execute(10, 5));

        Item item = new Item();
        item.setType(0);

        Item item1 = new Item();
        item1.setType(1);

        new ItemOperation(new ItemCheck()).exec(item);
        new ItemOperation(new ItemSeek()).exec(item1);

    }
}
