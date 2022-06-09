package com.chendb.sharding.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.chendb.sharding.dto.UserDTO;
import com.chendb.sharding.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * TODO
 *
 * @Author chendengbin
 * @Date 2022/6/8 22:56
 * @Version 1.0
 **/
@RestController
public class UserController {

    @Resource(name = "userService")
    private UserService userService;

    @PostMapping("/sharding/user/saveOrUpdate")
    public boolean saveOrUpdate(UserDTO userDTO) {
        return userService.saveOrUpdate(userDTO);
    }

    @PostMapping("/sharding/user/delete")
    public boolean delete(Long id) {
        return userService.delete(id);
    }

    @GetMapping("/sharding/user/selectOneById")
    public UserDTO selectOneById(Long id) {
        return userService.selectOneById(id);
    }

    @GetMapping("/sharding/user/page")
    public Page<UserDTO> page(Integer pageIndex, Integer pageSize, String schoolKey) {
        return userService.page(pageIndex, pageSize, schoolKey);
    }
}
