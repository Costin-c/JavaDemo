package com.mybatis.dao;

import com.mybatis.pojo.Blog;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public interface BlogMapper {

    //插入数据
    int addBlog(Blog blog);

    //查询博客
    List<Blog> queryBlogIF(Map map);
    List<Blog> queryBlogIF2(Map map);

    //选择查询
    List<Blog> queryBlogChoose(Map map);

    //遍历查询
    List<Blog> queryBlogForeach(Map map);
}
