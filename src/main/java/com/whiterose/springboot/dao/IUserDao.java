package com.whiterose.springboot.dao;

import com.whiterose.springboot.entities.User;

import java.util.List;

public interface IUserDao {
    public boolean isExist(String uno);

    public User queryUserByUno(String uno);

    public boolean addUser(User user);

    public boolean deleteUserByUno(String uno);

    public List<User> queryAllUser();

    public boolean checkUser(String uno, String upwd);
}
