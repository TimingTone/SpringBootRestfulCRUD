package com.whiterose.springboot.dao.impl;


import com.whiterose.springboot.dao.IStudentDao;
import com.whiterose.springboot.entities.Student;
import com.whiterose.springboot.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

;

//第四步， 编写数据访问层（Dao层）原子性的增删改查
//实现类
public class StudentDaoImpl implements IStudentDao {


    //查询学生是否存在
    public boolean isExist(int id){
        return queryStudentByID(id)==null? false:true;
    }

    //增加学生
    public boolean addStudent(Student student){
        String sql = "insert into student values(?, ?, ?, ?, ?, ?)";
        Object[] params = {student.getId(), student.getLastName(), student.getEmail(), student.getGender(), student.getFacultyID(), student.getAge()};
        return DBUtil.executeUpdate(sql, params);
    }

    //根据学号删除学生
    public boolean deleteStudentByID(int id){
        String sql = "delete from student where id=?";
        String sql_grd = "delete from grade where id=?";
        Object[] params = {id};
        DBUtil.executeUpdate(sql_grd,params);//由于外键，必须先删除学生成绩
        return DBUtil.executeUpdate(sql, params);
    }


    //根据学号修改学生信息(根据学号找人然后修改信息)
    public boolean updateStudentByID(int id, Student student){
        String sql = "update student set lastname=?, email=?, gender=?, facultyID=?, age=? where id=?";
        Object[] params = {student.getLastName(), student.getEmail(), student.getGender(), student.getFacultyID(), student.getAge(), id};
        return DBUtil.executeUpdate(sql, params);
    }

//select * from student
    //查询全部学生
    public List<Student> queryAllStudents(){
        List<Student> students = new ArrayList<>();
        ResultSet rs = null;
        //封装学生
        Student student = null;
        try {
            String sql = "select * from student";
            rs = DBUtil.executeQuery(sql, null);
            while (rs.next()) {
                int id = rs.getInt("id");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int gender = rs.getInt("gender");
                int age = rs.getInt("age");
                Integer facultyID = rs.getInt("facultyID");
                student = new Student(id, lastname, email, gender, facultyID, age);
                students.add(student);
            }
            return students;
        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个student
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
    public Student queryStudentByID(int id) {
        ResultSet rs = null;
        //封装学生
        Student student = null;
        try {
            String sql = "select * from student where id=?";
            Object[] params = {id};
            rs = DBUtil.executeQuery(sql, params);
            if (rs.next()) {
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                int gender = rs.getInt("gender");
                int age = rs.getInt("age");
                Integer facultyID = rs.getInt("facultyID");
                student = new Student(id, lastname, email, gender, facultyID, age);
            }
            return student;
        } catch (SQLException se) {
            se.printStackTrace();
            //没有这个student
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






















