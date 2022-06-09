package com.chendb.sharding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendb.sharding.dto.CourseClassUserDTO;
import com.chendb.sharding.dto.UserCourseClassUserDTO;
import com.chendb.sharding.mapper.CourseClassUserMapper;
import com.chendb.sharding.model.WktCourseClassUser;
import com.chendb.sharding.service.CourseClassUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/9 21:44
 * @Version 1.0
 **/
@Service("courseClassUserService")
public class CourseClassUserServiceImpl extends ServiceImpl<CourseClassUserMapper, WktCourseClassUser> implements CourseClassUserService {

    @Resource(name = "courseClassUserMapper")
    private CourseClassUserMapper courseClassUserMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(CourseClassUserDTO courseClassUserDTO) {
        WktCourseClassUser courseClassUser = new WktCourseClassUser();
        BeanUtils.copyProperties(courseClassUserDTO, courseClassUser);
        return this.saveOrUpdate(courseClassUser);
    }

    @Override
    public boolean delete(Long id) {
        return this.removeById(id);
    }

    @Override
    public CourseClassUserDTO selectOneById(Long id) {
        WktCourseClassUser courseClassUser = this.getById(id);
        CourseClassUserDTO courseClassUserDTO = new CourseClassUserDTO();
        BeanUtils.copyProperties(courseClassUser, courseClassUserDTO);
        return courseClassUserDTO;
    }

    @Override
    public Page<CourseClassUserDTO> page(int pageIndex, int pageSize, Long userId) {

        Page<WktCourseClassUser> page = this.page(new Page<>(pageIndex, pageSize), new QueryWrapper<WktCourseClassUser>()
                .eq("user_id", userId));
        Page<CourseClassUserDTO> resultPage = new Page<>();
        BeanUtils.copyProperties(page, resultPage);
        return resultPage;
    }

    @Override
    public List<UserCourseClassUserDTO> listByUserId(Long userId) {
        List<UserCourseClassUserDTO> courseClassUserDTOS = courseClassUserMapper.listByUserId(userId);
        return courseClassUserDTOS;
    }
}
