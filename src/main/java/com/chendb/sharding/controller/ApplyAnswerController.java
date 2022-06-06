package com.chendb.sharding.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendb.sharding.dto.ApplyAnswerDTO;
import com.chendb.sharding.service.ApplyAnswerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @Author chendengbin
 * @Date 2022/6/1 15:01
 * @Version 1.0
 **/
@RestController
public class ApplyAnswerController {

    @Resource(name = "applyAnswerService")
    private ApplyAnswerService applyAnswerService;

    @PostMapping("/sharding/apply/answer/delete")
    public boolean delete(Long id) {
        return applyAnswerService.delete(id);
    }

    @GetMapping("/sharding/apply/answer/listByClassId")
    public List<ApplyAnswerDTO> listByClassId(Long classId) {
        return applyAnswerService.listByClassId(classId);
    }

    @PostMapping("/sharding/apply/answer/saveOrUpdate")
    public boolean saveOrUpdate(ApplyAnswerDTO applyAnswerDTO) {
        return applyAnswerService.saveOrUpdate(applyAnswerDTO);
    }

    @GetMapping("/sharding/apply/answer/selectOneById")
    public ApplyAnswerDTO selectOneById(Long id) {
        return applyAnswerService.selectOneById(id);
    }

    @GetMapping("/sharding/apply/answer/page")
    public Page<ApplyAnswerDTO> page(int pageIndex, int pageSize, Long classId) {
        return applyAnswerService.page(pageIndex, pageSize, classId);
    }
}
