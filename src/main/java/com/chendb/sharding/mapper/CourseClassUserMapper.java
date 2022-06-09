package com.chendb.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chendb.sharding.dto.UserCourseClassUserDTO;
import com.chendb.sharding.model.WktCourseClassUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/9 21:37
 * @Version 1.0
 **/
@Mapper
public interface CourseClassUserMapper extends BaseMapper<WktCourseClassUser> {

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    List<UserCourseClassUserDTO> listByUserId(@Param(value = "userId") Long userId);
}
