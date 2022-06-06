package com.chendb.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendb.sharding.model.WktApplyAnswer;
import com.chendb.sharding.model.WktDictionary;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/6 23:42
 * @Version 1.0
 **/
@Mapper
public interface DictionaryMapper extends BaseMapper<WktDictionary> {
}
