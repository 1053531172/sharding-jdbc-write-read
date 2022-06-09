package com.chendb.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendb.sharding.model.LxxUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/8 22:44
 * @Version 1.0
 **/
@Mapper
public interface UserMapper extends BaseMapper<LxxUser>  {
}
