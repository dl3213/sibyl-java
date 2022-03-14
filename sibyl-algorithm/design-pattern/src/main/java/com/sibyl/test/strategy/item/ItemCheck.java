package com.sibyl.test.strategy.item;

import com.sibyl.test.Item;

/**
 * @Classname ItemCheck
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/03/14 19:08
 */

public class ItemCheck implements ItemPredicate{

    @Override
    public boolean predicate(Item item) {
        System.err.println(item);
        System.err.println("check");
        return false;
    }
}
