package com.chendb.sharding.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendb.sharding.dto.DictionaryDTO;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/6 23:42
 * @Version 1.0
 **/
public interface DictionaryService {
    /**
     * 新增或者更新
     * @param dictionaryDTO
     * @return
     */
    boolean saveOrUpdate(DictionaryDTO dictionaryDTO);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Page<DictionaryDTO> page(int pageIndex, int pageSize);

    /**
     * 根据id获取
     * @param id
     * @return
     */
    DictionaryDTO selectOneById(Long id);
}
