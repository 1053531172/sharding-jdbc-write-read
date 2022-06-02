package com.chendb.sharding.utils;

import io.shardingsphere.core.keygen.DefaultKeyGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * 雪花算法主键生成器工具类
 * @Author chendengbin
 * @Date 2022/6/2 22:59
 * @Version 1.0
 **/
public class SnowFlakeKeyGeneratorUtils {

    /**
     * 获取主键
     * @return
     */
    public static Long getId() {
        DefaultKeyGenerator key = new DefaultKeyGenerator();
        Number orderIdKey = key.generateKey();
        Long id = orderIdKey.longValue();

        return id;
    }

    /**
     * 批量获取主键
     * @return
     */
    public static List<Long> listIds(Integer size) {
        if (size == null || size == 0) {
            size = 10;
        }

        DefaultKeyGenerator key = new DefaultKeyGenerator();
        List<Long> ids = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Number orderIdKey = key.generateKey();
            Long id = orderIdKey.longValue();
            ids.add(id);
        }

        return ids;
    }
}
