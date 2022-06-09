package com.chendb.sharding.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/9 21:46
 * @Version 1.0
 **/
@Data
public class CourseClassUserDTO implements Serializable {
    private Long id;

    private Long courseId;

    private Long classId;

    private Long userId;

    private Date createdTime;

    private Long groupId;

    private Date updateTime;
}
