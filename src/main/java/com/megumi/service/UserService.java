package com.megumi.service;

import com.megumi.common.PageResult;
import com.megumi.domain.User;

import java.util.List;

public interface UserService {
    User findUserById(Integer id);

    List<User> findAll();

    PageResult findByPage(Integer pageSize, Integer pageNum);
}
