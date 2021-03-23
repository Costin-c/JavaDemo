package com.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

//工具类 SqlSessionFactory  SqlSession
public class MybatisUtils {

    //提升作用域
    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            //使用mybatis第一步：获取sqlSessionFactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //    既然有了 SqlSessionFactory，顾名思义，我们可以从中获得 SqlSession 的实例。
    //    org.apache.ibatis.session.SqlSession 提供了在数据库执行 org.apache.ibatis.jdbc.SQL 命令所需的所有方法。你可以通过 SqlSession 实例来直接执行已映射的 SQL 语句
    public static SqlSession getSqlSession() {
        //  设置为true表示自动提交事务
        //  return sqlSessionFactory.openSession(true);
        return sqlSessionFactory.openSession();
    }
}
