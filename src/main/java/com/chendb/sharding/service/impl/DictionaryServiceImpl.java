package com.chendb.sharding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendb.sharding.dto.DictionaryDTO;
import com.chendb.sharding.mapper.DictionaryMapper;
import com.chendb.sharding.model.WktDictionary;
import com.chendb.sharding.service.DictionaryService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/6 23:43
 * @Version 1.0
 **/
@Service("dictionaryService")
public class DictionaryServiceImpl extends ServiceImpl<DictionaryMapper, WktDictionary> implements DictionaryService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(DictionaryDTO dictionaryDTO) {
        WktDictionary dictionary = new WktDictionary();
        BeanUtils.copyProperties(dictionaryDTO, dictionary);
        return this.saveOrUpdate(dictionary);
    }

    @Override
    public boolean delete(Long id) {
        return this.removeById(id);
    }

    @Override
    public Page<DictionaryDTO> page(int pageIndex, int pageSize) {
        Page<WktDictionary> page = this.page(new Page<>(pageIndex, pageSize), new QueryWrapper<>());
        Page<DictionaryDTO> currentPage = new Page<>();
        BeanUtils.copyProperties(page, currentPage);
        return currentPage;
    }

    @Override
    public DictionaryDTO selectOneById(Long id) {
        WktDictionary dictionary = this.getById(id);
        DictionaryDTO dictionaryDTO = new DictionaryDTO();
        BeanUtils.copyProperties(dictionary, dictionaryDTO);
        return dictionaryDTO;
    }
}
