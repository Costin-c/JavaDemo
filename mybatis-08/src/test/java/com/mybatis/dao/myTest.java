package com.mybatis.dao;

import com.mybatis.pojo.User;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

@SuppressWarnings("all")
public class myTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);

//        sqlSession.clearCache();
        System.out.println("==============================");
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        System.out.println(user1 == user2);


//        int aaa = mapper.updateUser(new User(2, "aaa", "789456"));
//        System.out.println(user2);

        sqlSession.close();
    }
}