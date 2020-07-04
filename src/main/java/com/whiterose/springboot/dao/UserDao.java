package com.whiterose.springboot.dao;

import com.whiterose.springboot.dao.impl.StudentDaoImpl;
import com.whiterose.springboot.dao.impl.UserDaoImpl;
import com.whiterose.springboot.entities.Student;
import com.whiterose.springboot.entities.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Map;

@Repository
public class UserDao {
    private static Map<String, User> user = null;



    //修改用户信息
    public void update(User user){
        IUserDao userDao = new UserDaoImpl();
        userDao.updateUserByUno(user.getUno(), user);
    }

    public void add(User user){


        IUserDao userDao = new UserDaoImpl();
        userDao.deleteUserByUno(user.getUno());
        userDao.addUser(user);
    }

    public Collection<User> getAll(){return user.values();}

    public User get(String uno){ return user.get(uno);}

    public void delete(String uno){user.remove(uno);}


}
