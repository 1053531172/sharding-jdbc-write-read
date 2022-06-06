package com.chendb.sharding.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;

/**
 * 字典表（用于配置广播表）
 * @Author chendengbin
 * @Date 2022/6/6 23:36
 * @Version 1.0
 **/
@Data
public class WktDictionary extends Model<WktDictionary> implements Serializable {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;

    /**
     * 名称
     */
    private String name;
}
