package com.sibyl.test.strategy.item;


import com.sibyl.test.Item;

public interface ItemPredicate {
    boolean predicate(Item item);
}
