package com.chendb.sharding.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chendb.sharding.dto.UserDTO;
import com.chendb.sharding.mapper.UserMapper;
import com.chendb.sharding.model.LxxUser;
import com.chendb.sharding.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/8 22:45
 * @Version 1.0
 **/
@Service("userService")
public class UserServiceImpl extends ServiceImpl<UserMapper, LxxUser> implements UserService {

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveOrUpdate(UserDTO userDTO) {
        LxxUser user = new LxxUser();
        BeanUtils.copyProperties(userDTO, user);
        return this.saveOrUpdate(user);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean delete(Long id) {
        return this.removeById(id);
    }

    @Override
    public UserDTO selectOneById(Long id) {
        LxxUser user = this.getById(id);
        UserDTO userDTO = new UserDTO();
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

    @Override
    public Page<UserDTO> page(Integer pageIndex, Integer pageSize, String schoolKey) {
        Page<LxxUser> page = this.page(new Page<>(pageIndex, pageSize), new QueryWrapper<LxxUser>()
                .eq("school_key", schoolKey));
        Page<UserDTO> resultPage = new Page<>();
        BeanUtils.copyProperties(page, resultPage);
        return resultPage;
    }
}
