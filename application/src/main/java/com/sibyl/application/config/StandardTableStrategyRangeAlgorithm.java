package com.sibyl.application.config;

import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.Arrays;
import java.util.Collection;

/**
 * @Classname StandardTableStrategyAlgorithm
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/01/06 21:15
 */

public class StandardTableStrategyRangeAlgorithm implements RangeShardingAlgorithm<Long> {
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Long> shardingValue) {
        Long upperEndpoint = shardingValue.getValueRange().upperEndpoint();
        Long lowerEndpoint = shardingValue.getValueRange().lowerEndpoint();
        String logicTableName = shardingValue.getLogicTableName();

        return Arrays.asList("warn_record_1","warn_record_2");
    }
}
