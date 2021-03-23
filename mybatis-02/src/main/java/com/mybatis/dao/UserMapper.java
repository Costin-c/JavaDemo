package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();
}
