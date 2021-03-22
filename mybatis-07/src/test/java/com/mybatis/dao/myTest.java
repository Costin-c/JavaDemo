package com.mybatis.dao;

import com.mybatis.pojo.Blog;
import com.mybatis.utils.IDUtils;
import com.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@SuppressWarnings("all")
public class myTest {

    @Test
    public void addInitBlog(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDUtils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("张三");
        blog.setCreateTime(new Date());
        blog.setViews(9999);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("Java如此简单");
        blog.setAuthor("李四");
        blog.setCreateTime(new Date());
        blog.setViews(8888);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("JavaScript如此简单");
        blog.setAuthor("王五");
        blog.setCreateTime(new Date());
        blog.setViews(7777);
        mapper.addBlog(blog);

        blog.setId(IDUtils.getId());
        blog.setTitle("C#如此简单");
        blog.setAuthor("赵六");
        blog.setCreateTime(new Date());
        blog.setViews(6666);
        mapper.addBlog(blog);

        //记得提交事务
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void queryBlogIFTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        map.put("title", "Java如此简单");
        List<Blog> blogList = mapper.queryBlogIF(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }
    }

    @Test
    public void queryBlogChooseTest(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        //添加条件
        map.put("author", "赵六");
        map.put("views", 9999);
        List<Blog> blogList = mapper.queryBlogChoose(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }
    }

    @Test
    public void queryBlogIFTest2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        HashMap map = new HashMap();
        // map.put("title", "Java如此简单");
        map.put("author", "张三");
        List<Blog> blogList = mapper.queryBlogIF2(map);

        for (Blog blog : blogList) {
            System.out.println(blog);
        }
    }

    @Test
    public void queryBlogForeach(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);

        ArrayList<Integer> ids = new ArrayList<Integer>();
        ids.add(4);
        ids.add(3);
        ids.add(2);

        HashMap map = new HashMap();
        map.put("ids", ids);

        List<Blog> blogs = mapper.queryBlogForeach(map);
        for (Blog blog : blogs) {
            System.out.println(blog);
        }
    }

}
