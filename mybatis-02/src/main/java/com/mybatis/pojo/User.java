package com.mybatis.pojo;

//实体类
public class User {
    private int uid;
    private String uname;
    private String usex;

    public User() {
    }

    public User(int uid, String uname, String usex) {
        this.uid = uid;
        this.uname = uname;
        this.usex = usex;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUsex() {
        return usex;
    }

    public void setUsex(String usex) {
        this.usex = usex;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", usex='" + usex + '\'' +
                '}';
    }
}
