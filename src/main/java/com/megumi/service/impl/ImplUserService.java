package com.megumi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.megumi.common.PageResult;
import com.megumi.dao.UserDao;
import com.megumi.domain.User;
import com.megumi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImplUserService implements UserService {
    @Autowired(required = true)
    private UserDao userDao;
    @Override
    public User findUserById(Integer id) {
        User user =  userDao.findById(id);
        return user;
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public PageResult findByPage(Integer pageSize, Integer pageNum) {
        PageHelper.startPage(pageSize, pageNum);
        List<User> users = userDao.findAll();
        PageInfo pageInfo = new PageInfo(users);
        PageResult<User> pageResult = new PageResult<>(pageInfo.getPageNum(), pageInfo.getPageSize(), (int) pageInfo.getTotal(), users);
        return pageResult;
    }


}
