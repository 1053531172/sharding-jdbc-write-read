package com.chendb.sharding.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/9 21:58
 * @Version 1.0
 **/
@Data
public class UserCourseClassUserDTO implements Serializable {
    private Long userId;

    private String userName;

    private Long groupId;
}
