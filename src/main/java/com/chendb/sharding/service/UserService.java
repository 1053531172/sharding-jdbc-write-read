package com.chendb.sharding.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendb.sharding.dto.UserDTO;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/8 22:45
 * @Version 1.0
 **/
public interface UserService {

    /**
     * 新增或者更新
     * @param userDTO
     * @return
     */
    boolean saveOrUpdate(UserDTO userDTO);

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    UserDTO selectOneById(Long id);

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @param schoolKey
     * @return
     */
    Page<UserDTO> page(Integer pageIndex, Integer pageSize, String schoolKey);
}
