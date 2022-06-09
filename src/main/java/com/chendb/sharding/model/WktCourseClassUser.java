package com.chendb.sharding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/9 21:38
 * @Version 1.0
 **/
@Data
public class WktCourseClassUser extends Model<WktCourseClassUser> implements Serializable {

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    private Long courseId;

    private Long classId;

    private Long userId;

    private Date createdTime;

    private Long groupId;

    private Date updateTime;
}
