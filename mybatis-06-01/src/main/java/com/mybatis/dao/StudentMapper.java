package com.mybatis.dao;

import com.mybatis.pojo.Student;

import java.util.List;

public interface StudentMapper {
    //查询所有的学生的信息，以及对应的老师的信息
    public List<Student> getStudent();

    //方法二：按照结果嵌套处理
    public List<Student> getStudent2();

}
