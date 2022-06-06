package com.chendb.sharding.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendb.sharding.dto.DictionaryDTO;
import com.chendb.sharding.service.DictionaryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/6 23:45
 * @Version 1.0
 **/
@RestController
public class DictionaryController {

    @Resource(name = "dictionaryService")
    private DictionaryService dictionaryService;

    @PostMapping("/sharding/dictionary/saveOrUpdate")
    public boolean saveOrUpdate(DictionaryDTO dictionaryDTO) {
        return dictionaryService.saveOrUpdate(dictionaryDTO);
    }

    @PostMapping("/sharding/dictionary/delete")
    public boolean delete(Long id) {
        return dictionaryService.delete(id);
    }

    @GetMapping("/sharding/dictionary/page")
    public Page<DictionaryDTO> page(int pageIndex, int pageSize) {
        return dictionaryService.page(pageIndex, pageSize);
    }

    @GetMapping("/sharding/dictionary/selectOneById")
    public DictionaryDTO selectOneById(Long id) {
        return dictionaryService.selectOneById(id);
    }
}
