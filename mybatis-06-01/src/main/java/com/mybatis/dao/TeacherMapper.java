package com.mybatis.dao;

import com.mybatis.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

public interface TeacherMapper {

    Teacher getTeacher(@Param("id") int id);
//    Teacher getTeacher2(@Param("id") int id);
}
