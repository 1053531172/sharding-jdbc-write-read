package com.chendb.sharding.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/8 22:47
 * @Version 1.0
 **/
@Data
public class UserDTO implements Serializable {
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 头像地址
     */
    private String photo;

    /**
     * 电话号码
     */
    private String mobileNo;

    /**
     * 密码
     */
    private String password;

    /**
     * 学号
     */
    private String studentNo;

    /**
     * 性别
     */
    private String sex;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 评价
     */
    private String motto;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 用户类型
     */
    private Integer user_type;

    private Date create_time;

    private Date active_time;

    private String shortUserId;

    private String schoolKey;

    private Date updateTime;

    private String innerStudentNo;

    private String teacherNo;
}
