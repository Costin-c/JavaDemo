package com.mybatis.dao;

import com.mybatis.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherMapper {
    //获取老师
    List<Teacher> getTeachers();

    //获取指定老师下的所有信息及老师的信息
    Teacher getTeacher(@Param("tid") int id);
}
