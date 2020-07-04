package com.whiterose.springboot.dao.impl;


import com.whiterose.springboot.dao.IUserDao;
import com.whiterose.springboot.entities.User;
import com.whiterose.springboot.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//实现类
public class UserDaoImpl implements IUserDao {

    //查询用户是否存在
    public boolean isExist(String uno) {
        return queryUserByUno(uno) == null ? false : true;
    }

    //增加用户管理
    public boolean addUser(User user) {
        String sql = "insert into user values(?, ?)";
        Object[] params = {user.getUno(), user.getUpwd()};
        return DBUtil.executeUpdate(sql, params);
    }

    //根据用户名删除用户
    public boolean deleteUserByUno(String uno) {
        String sql = "delete from user where uno=?";
        Object[] params = {uno};
        return DBUtil.executeUpdate(sql, params);
    }


    //根据uno修改用户信息
    public boolean updateUserByUno(String uno, User user) {
        String sql = "update user set upwd=? where uno=?";
        Object[] params = {user.getUpwd(), uno};
        return DBUtil.executeUpdate(sql, params);
    }

    //查询全部管理用户
    public List<User> queryAllUser() {
        List<User> users = new ArrayList<>();
        ResultSet rs = null;
        //封装学生
        User user = null;
        try {
            String sql = "select * from user";
            rs = DBUtil.executeQuery(sql, null);
            while (rs.next()) {
                String uno = rs.getString("uno");
                String upwd = rs.getString("upwd");
                user = new User(uno, upwd);
                users.add(user);
            }
            return users;
        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个grade
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            DBUtil.closeAll(rs, DBUtil.pstmt, DBUtil.conn);
        }
    }

    //select * from student where sno=?
    //根据学生的学号来查询用户的具体信息
    public User queryUserByUno(String uno) {
        ResultSet rs = null;
        //封装用户
        User user = null;
        try {
            String sql = "select * from user where uno=?";
            Object[] params = {uno};
            rs = DBUtil.executeQuery(sql, params);
            if (rs.next()) {
                String upwd = rs.getString("upwd");
                user = new User(uno, upwd);
            }
            return user;
        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个user
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (DBUtil.conn != null) DBUtil.conn.close();
                if (DBUtil.pstmt != null) DBUtil.pstmt.close();
                if (DBUtil.rs != null) DBUtil.rs.close();
                if (rs != null) rs.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }
        }
    }

    //判定当输入信息正确，返回true
    public boolean checkUser(String uno, String upwd) {

        if (isExist(uno)) {
            User user = queryUserByUno(uno);
            if (user.getUpwd().equals(upwd)) {
                return true;
            }
        }

        return false;


    }
}
