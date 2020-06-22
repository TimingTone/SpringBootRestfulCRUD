package com.whiterose.springboot.dao.impl;


import com.whiterose.springboot.dao.IGradeDao;
import com.whiterose.springboot.entities.Grade;
import com.whiterose.springboot.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//实现类
public class GradeDaoImpl implements IGradeDao {


    //查询成绩是否存在
    public boolean isExist(int id){
        return queryGradeByID(id)==null? false:true;
    }

    //增加成绩
    public boolean addGrade(Grade grade){
        String sql = "insert into grade values(?, ?, ?, ?, ?, ?, ?)";
        Object[] params = {grade.getId(), grade.getLastName(), grade.getMath(), grade.getPhysics(), grade.getEnglish(), grade.getC(), grade.getPolity()};
        return DBUtil.executeUpdate(sql, params);
    }

    //根据学号删除学生
    public boolean deleteGradeByID(int id){
        String sql = "delete from Grade where id=?";
        Object[] params = {id};
        return DBUtil.executeUpdate(sql, params);
    }


    //根据学号修改学生信息(根据学号找人然后修改信息)（成绩）
    public boolean updateGradeByID(int id, Grade grade){
        String sql = "update grade set lastname=?, math=?, physics=?, english=?, c=?, polity=? where id=?";
        Object[] params = {grade.getId(), grade.getLastName(), grade.getMath(), grade.getPhysics(), grade.getEnglish(), grade.getC(), grade.getPolity(), id};
        return DBUtil.executeUpdate(sql, params);
    }

    //select * from student
    //查询全部学生成绩
    public List<Grade> queryAllGrade(){
        List<Grade> grades = new ArrayList<>();
        ResultSet rs = null;
        //封装学生
        Grade grade = null;
        try {
            String sql = "select * from grade";
            rs = DBUtil.executeQuery(sql, null);
            while (rs.next()) {
                int id = rs.getInt("id");
                String lastname = rs.getString("lastname");
                int math = rs.getInt("math");
                int physics = rs.getInt("physics");
                int english = rs.getInt("english");
                int c = rs.getInt("c");
                int polity = rs.getInt("polity");
                grade = new Grade(id, lastname, math, physics, english, c, polity);
                grades.add(grade);
            }
            return grades;
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
    //根据学生的学号来查询学生的具体信息
    public Grade queryGradeByID(int id) {
        ResultSet rs = null;
        //封装学生
        Grade grade = null;
        try {
            String sql = "select * from grade where id=?";
            Object[] params = {id};
            rs = DBUtil.executeQuery(sql, params);
            if (rs.next()) {
                String lastname = rs.getString("lastname");
                int math = rs.getInt("math");
                int physics = rs.getInt("physics");
                int english = rs.getInt("english");
                int c = rs.getInt("c");
                int polity = rs.getInt("polity");
                grade = new Grade(id, lastname, math, physics, english, c, polity);
            }
            return grade;
        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个grade
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
}