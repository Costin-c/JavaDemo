package com.mybatis.dao;

import com.mybatis.pojo.Teacher;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class myTest {


    @Test
    public void teasTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        List<Teacher> list = mapper.getTeachers();
        for (Teacher teacher : list) {
            System.out.println(teacher);
        }

        sqlSession.close();
    }

    @Test
    public void teaTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);

        Teacher teacher = mapper.getTeacher(1);

        System.out.println(teacher);
    }
}
