package com.sibyl.test.strategy.item;

import com.sibyl.test.Item;

/**
 * @Classname ItemSeek
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/03/14 19:11
 */

public class ItemSeek implements ItemPredicate{
    @Override
    public boolean predicate(Item item) {
        System.err.println(item);
        System.err.println("seek");
        return false;
    }
}
