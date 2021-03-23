package com.mybatis.dao;

import com.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    //limit查询
    List<User> getUserByLimit(Map<String,Integer> map);
}
