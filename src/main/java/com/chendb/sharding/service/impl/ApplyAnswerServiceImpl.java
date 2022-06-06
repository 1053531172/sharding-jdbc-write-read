package com.chendb.sharding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendb.sharding.annotation.MasterSelect;
import com.chendb.sharding.dto.ApplyAnswerDTO;
import com.chendb.sharding.mapper.ApplyAnswerMapper;
import com.chendb.sharding.model.WktApplyAnswer;
import com.chendb.sharding.service.ApplyAnswerService;
import com.chendb.sharding.utils.DateUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 *
 * @Author chendengbin
 * @Date 2022/6/1 14:39
 * @Version 1.0
 **/
@Service("applyAnswerService")
public class ApplyAnswerServiceImpl extends ServiceImpl<ApplyAnswerMapper, WktApplyAnswer> implements ApplyAnswerService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    @MasterSelect
    public boolean delete(Long id) {
        WktApplyAnswer applyAnswer = this.getById(id);
        if (applyAnswer != null) {
            return this.removeById(id);
        }

        return false;
    }

    @Override
    public List<ApplyAnswerDTO> listByClassId(Long classId) {

        List<WktApplyAnswer> applyAnswers = this.list(new QueryWrapper<WktApplyAnswer>()
                .eq("class_id", classId)
                .ge("apply_time", DateUtils.format("2022-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"))
                .lt("apply_time", DateUtils.format("2022-01-31 23:59:59", "yyyy-MM-dd HH:mm:ss")));

        if (CollectionUtils.isEmpty(applyAnswers)) {
            return Collections.emptyList();
        }

        List<ApplyAnswerDTO> applyAnswerDTOS = new ArrayList<>();
        for (WktApplyAnswer applyAnswer : applyAnswers) {
            ApplyAnswerDTO applyAnswerDTO = new ApplyAnswerDTO();
            BeanUtils.copyProperties(applyAnswer, applyAnswerDTO);
            applyAnswerDTOS.add(applyAnswerDTO);
        }

        return applyAnswerDTOS;
    }

    @Override
    public boolean saveOrUpdate(ApplyAnswerDTO applyAnswerDTO) {
        WktApplyAnswer applyAnswer = new WktApplyAnswer();
        BeanUtils.copyProperties(applyAnswerDTO, applyAnswer);
        applyAnswer.setApplyTime(new Date());
        return this.saveOrUpdate(applyAnswer);
    }

    @Override
    public ApplyAnswerDTO selectOneById(Long id) {
        WktApplyAnswer applyAnswer = this.getById(id);
        ApplyAnswerDTO applyAnswerDTO = new ApplyAnswerDTO();
        BeanUtils.copyProperties(applyAnswer, applyAnswerDTO);
        return applyAnswerDTO;
    }

    @Override
    public Page<ApplyAnswerDTO> page(int pageIndex, int pageSize, Long classId) {
        Page<WktApplyAnswer> page = new Page<>(pageIndex, pageSize);
        Page<WktApplyAnswer> currentPage = this.page(page, new QueryWrapper<WktApplyAnswer>()
                        .eq("class_id", classId)
                        .ge("apply_time", DateUtils.format("2022-01-01 00:00:00", "yyyy-MM-dd HH:mm:ss"))
                        .lt("apply_time", DateUtils.format("2022-12-31 23:59:59", "yyyy-MM-dd HH:mm:ss")));

        Page<ApplyAnswerDTO> resultPage = new Page<>();
        BeanUtils.copyProperties(currentPage, resultPage);

        return resultPage;
    }
}
