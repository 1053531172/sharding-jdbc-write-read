package com.chendb.sharding.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendb.sharding.dto.CourseClassUserDTO;
import com.chendb.sharding.dto.UserCourseClassUserDTO;
import com.chendb.sharding.dto.UserDTO;
import com.chendb.sharding.service.CourseClassUserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/9 22:12
 * @Version 1.0
 **/
@RestController
public class CourseClassUserController {

    @Resource(name = "courseClassUserService")
    private CourseClassUserService courseClassUserService;

    @PostMapping("/sharding/courseClassUser/saveOrUpdate")
    public boolean saveOrUpdate(CourseClassUserDTO courseClassUserDTO) {
        return courseClassUserService.saveOrUpdate(courseClassUserDTO);
    }

    @PostMapping("/sharding/courseClassUser/delete")
    public boolean delete(Long id) {
        return courseClassUserService.delete(id);
    }

    @GetMapping("/sharding/courseClassUser/selectOneById")
    public CourseClassUserDTO selectOneById(Long id) {
        return courseClassUserService.selectOneById(id);
    }

    @GetMapping("/sharding/courseClassUser/page")
    public Page<CourseClassUserDTO> page(Integer pageIndex, Integer pageSize, Long userId) {
        return courseClassUserService.page(pageIndex, pageSize, userId);
    }

    @GetMapping("/sharding/courseClassUser/listByUserId")
    public List<UserCourseClassUserDTO> listByUserId(Long userId) {
        return courseClassUserService.listByUserId(userId);
    }
}
