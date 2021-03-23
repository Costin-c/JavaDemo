
package com.mybatis.pojo;

import org.apache.ibatis.type.Alias;

/**
 * springtest数据库中user表的持久类
 */
@Alias("user")
public class MyUser {
    private Integer uid; // 主键
    private String uname;
    private SexEnum usex;
    // 此处setter和getter方法

    public MyUser() {
    }

    public MyUser(Integer uid, String uname, SexEnum usex) {
        this.uid = uid;
        this.uname = uname;
        this.usex = usex;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public SexEnum getUsex() {
        return usex;
    }

    public void setUsex(SexEnum usex) {
        this.usex = usex;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", usex=" + usex +
                '}';
    }
}


