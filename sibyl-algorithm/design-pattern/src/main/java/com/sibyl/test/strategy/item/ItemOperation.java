package com.sibyl.test.strategy.item;

import com.sibyl.test.Item;

/**
 * @Classname ItemOperation
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/03/14 19:13
 */

public class ItemOperation {
    private  ItemPredicate itemPredicate;

    public ItemOperation(ItemPredicate itemPredicate) {
        this.itemPredicate = itemPredicate;
    }

    public boolean exec(Item item){
        return itemPredicate.predicate(item);
    }
}
