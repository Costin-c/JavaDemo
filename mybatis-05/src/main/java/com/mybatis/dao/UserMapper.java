package com.mybatis.dao;

import com.mybatis.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select id,name,pwd as password from mybatisuser")
    List<User> getUsers();

    @Select("select * from mybatisuser where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into mybatisuser(id,name,pwd) values(#{id},#{name},#{password})")
    int addUser(User user);

    @Update("update mybatisuser set name=#{name},pwd=#{password} where id = #{id}")
    int updateUser(User user);

    @Delete("delete from mybatisuser where id = #{uid}")
    int deleteUser(@Param("uid") int id);
}
