package com.mybatis.dao;

import com.mybatis.pojo.User;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void test(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> list = mapper.getUsers();
        //查询集合
        //for (User user : list) {
        //     System.out.println(user);
        //}

        //通过id查询
        //User user = mapper.getUserById(2);
        //System.out.println(user);

        //添加用户
        //设置了自动提交事务，因此不用手动再写
        //mapper.addUser(new User(5,"hello","741852"));

        //更新用户
        //mapper.updateUser(new User(5,"tom","852132"));

        //删除用户
        mapper.deleteUser(5);

        //增删改需要提交事务
        sqlSession.commit();

        sqlSession.close();
    }

}
