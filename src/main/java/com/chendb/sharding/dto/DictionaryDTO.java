package com.chendb.sharding.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/6 23:46
 * @Version 1.0
 **/
@Data
public class DictionaryDTO implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 名称
     */
    private String name;
}
