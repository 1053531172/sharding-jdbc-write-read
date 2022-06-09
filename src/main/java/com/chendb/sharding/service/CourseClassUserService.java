package com.chendb.sharding.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendb.sharding.dto.CourseClassUserDTO;
import com.chendb.sharding.dto.UserCourseClassUserDTO;

import java.util.List;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/9 21:44
 * @Version 1.0
 **/
public interface CourseClassUserService {

    /**
     * 新增或者修改
     * @param courseClassUserDTO
     * @return
     */
    boolean saveOrUpdate(CourseClassUserDTO courseClassUserDTO);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    CourseClassUserDTO selectOneById(Long id);

    /**
     * 分页
     * @param pageIndex
     * @param pageSize
     * @param userId
     * @return
     */
    Page<CourseClassUserDTO> page(int pageIndex, int pageSize, Long userId);

    /**
     * 根据用户id查询
     * @param userId
     * @return
     */
    List<UserCourseClassUserDTO> listByUserId(Long userId);
}
