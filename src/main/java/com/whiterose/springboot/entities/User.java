package com.whiterose.springboot.entities;
//权限用户实体类
public class User {
    private String uno;
    private String upwd;

    public String getUno() {
        return uno;
    }

    public void setUno(String uno) {
        this.uno = uno;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }

    public User(String uno, String upwd) {
        this.uno = uno;
        this.upwd = upwd;
    }

    public User(){};

    @Override
    public String toString() {
        return "User{" +
                "uno='" + uno + '\'' +
                ", upwd='" + upwd + '\'' +
                '}';
    }
}
