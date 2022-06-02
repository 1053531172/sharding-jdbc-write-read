package com.chendb.sharding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendb.sharding.annotation.MasterSelect;
import com.chendb.sharding.dto.ApplyAnswerDTO;
import com.chendb.sharding.mapper.ApplyAnswerMapper;
import com.chendb.sharding.model.ApplyAnswer;
import com.chendb.sharding.service.ApplyAnswerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @Author chendengbin
 * @Date 2022/6/1 14:39
 * @Version 1.0
 **/
@Service("applyAnswerService")
public class ApplyAnswerServiceImpl extends ServiceImpl<ApplyAnswerMapper, ApplyAnswer> implements ApplyAnswerService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    @MasterSelect
    public boolean delete(Long id) {
        ApplyAnswer applyAnswer = this.getById(id);
        if (applyAnswer != null) {
            return this.removeById(id);
        }

        return false;
    }

    @Override
    public List<ApplyAnswerDTO> listByClassId(Long classId) {
        List<ApplyAnswer> applyAnswers = this.list(new QueryWrapper<ApplyAnswer>()
                .eq("class_id", classId));

        if (CollectionUtils.isEmpty(applyAnswers)) {
            return Collections.emptyList();
        }

        List<ApplyAnswerDTO> applyAnswerDTOS = new ArrayList<>();
        for (ApplyAnswer applyAnswer : applyAnswers) {
            ApplyAnswerDTO applyAnswerDTO = new ApplyAnswerDTO();
            BeanUtils.copyProperties(applyAnswer, applyAnswerDTO);
            applyAnswerDTOS.add(applyAnswerDTO);
        }

        return applyAnswerDTOS;
    }

    @Override
    public boolean saveOrUpdate(ApplyAnswerDTO applyAnswerDTO) {
        ApplyAnswer applyAnswer = new ApplyAnswer();
        BeanUtils.copyProperties(applyAnswerDTO, applyAnswer);
        return this.saveOrUpdate(applyAnswer);
    }
}
