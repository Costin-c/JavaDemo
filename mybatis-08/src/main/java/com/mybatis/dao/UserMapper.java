package com.mybatis.dao;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
//    根据id查询user
    User queryUserById(@Param("id") int id);

//    修改
    int updateUser(User user);
}
