package com.sibyl.application.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.math.BigInteger;
import java.util.Collection;

/**
 * @Classname StandardTableStrategyAlgorithm
 * @Description TODO
 * @Author dyingleaf3213
 * @Create 2022/01/06 21:15
 */

public class StandardDatabaseStrategyPreciseAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingValue) {
        String logicTableName = shardingValue.getLogicTableName();
        String columnName = shardingValue.getColumnName();
        Long value = shardingValue.getValue();
        BigInteger bigInteger = BigInteger.valueOf(value);
        BigInteger add = bigInteger.mod(new BigInteger("2")).add(BigInteger.ONE);
        String key = "ds" + add;
        if(!availableTargetNames.contains(key)){
            throw new UnsupportedOperationException("tttttest");
        }
        return key;
    }
}
