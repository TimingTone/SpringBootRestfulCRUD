package com.whiterose.springboot.dao.impl;

import com.whiterose.springboot.dao.IFacultyDao;
import com.whiterose.springboot.entities.Faculty;
import com.whiterose.springboot.entities.Student;
import com.whiterose.springboot.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FacultyDaoImpl implements IFacultyDao {

    //查询出所有的部门
    public Collection<Faculty> queryAllFaculties(){
        Collection<Faculty> faculties = new ArrayList<>();
        ResultSet rs = null;
        //封装学生
        Faculty faculty = null;
        try {
            String sql = "select * from faculty";
            rs = DBUtil.executeQuery(sql, null);
            while (rs.next()) {
                int id = rs.getInt("id");
                String FacultyName = rs.getString("FacultyName");
                faculty = new Faculty(id, FacultyName);
                faculties.add(faculty);
            }
            return faculties;
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


    //根据系的id来查询系的具体信息
    public Faculty queryFacultyByID(int id) {
        ResultSet rs = null;
        //封装学生
        Faculty faculty = null;
        try {
            String sql = "select * from faculty where id=?";
            Object[] params = {id};
            rs = DBUtil.executeQuery(sql, params);
            if (rs.next()) {

                String FacultyName = rs.getString("FacultyName");

                faculty = new Faculty(id, FacultyName);
            }
            return faculty;
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

    //根据facultyName来查询系的具体信息
    public Faculty queryFacultyByName(String name) {
        ResultSet rs = null;
        //封装学生
        Faculty faculty = null;
        try {
            String sql = "select * from faculty where FacultyName=?";
            Object[] params = {name};
            rs = DBUtil.executeQuery(sql, params);
            if (rs.next()) {

                Integer id = rs.getInt("id");

                faculty = new Faculty(id, name);
            }
            return faculty;
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
