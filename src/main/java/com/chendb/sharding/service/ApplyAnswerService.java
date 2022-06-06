package com.chendb.sharding.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendb.sharding.dto.ApplyAnswerDTO;

import java.util.List;

/**
 *
 * @Author chendengbin
 * @Date 2022/6/1 14:37
 * @Version 1.0
 **/
public interface ApplyAnswerService {

    /**
     * 删除
     * @param id
     * @return
     */
    boolean delete(Long id);

    /**
     * 通过班级id查询
     * @param id
     * @return
     */
    List<ApplyAnswerDTO> listByClassId(Long id);

    /**
     * 新增或者更新
     * @param applyAnswerDTO
     * @return
     */
    boolean saveOrUpdate(ApplyAnswerDTO applyAnswerDTO);

    /**
     * 查询单个数据
     * @param id
     * @return
     */
    ApplyAnswerDTO selectOneById(Long id);

    /**
     * 分页查询
     * @param pageIndex
     * @param pageSize
     * @param classId
     * @return
     */
    Page<ApplyAnswerDTO> page(int pageIndex, int pageSize, Long classId);
}
