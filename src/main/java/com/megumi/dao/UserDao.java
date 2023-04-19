package com.megumi.dao;

import com.megumi.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    User findById(Integer id);

    List<User> findAll();
}
