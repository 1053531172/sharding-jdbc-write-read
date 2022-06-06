package com.chendb.sharding.algorithm;

import com.chendb.sharding.utils.DateUtils;
import com.google.common.collect.Range;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.RangeShardingValue;

import java.util.*;

/**
 * 用于条件范围匹配时的路由（between、<、>等）
 * @Author chendengbin
 * @Date 2022/6/5 23:31
 * @Version 1.0
 **/
public class DateRangeShardingAlgorithm implements RangeShardingAlgorithm<Date> {

    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, RangeShardingValue<Date> shardingValue) {

        List<String> list = new ArrayList<>();
        Range<Date> valueRange = shardingValue.getValueRange();
        Date lowerDate = valueRange.lowerEndpoint();
        Date upperDate = valueRange.upperEndpoint();

        TreeSet<String> suffixList = DateUtils.getSuffixListForRange(lowerDate, upperDate);
        for (String tableName : availableTargetNames) {
            if (containTableName(suffixList, tableName)) {
                list.add(tableName);
            }
        }
        return list;
    }

    private boolean containTableName(Set<String> suffixList, String tableName) {
        boolean flag = false;
        for (String s : suffixList) {
            if (tableName.endsWith(s)) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
