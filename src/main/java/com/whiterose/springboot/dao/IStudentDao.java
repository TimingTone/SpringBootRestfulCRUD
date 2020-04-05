package com.whiterose.springboot.dao;



import com.whiterose.springboot.entities.Student;

import java.util.List;

public interface IStudentDao {

    //根据学生的学号来查询学生的具体信息
    public Student queryStudentByID(int id) ;

    //查询学生是否存在
    public boolean isExist(int id);


    //增加学生
    public boolean addStudent(Student student);

    //根据学号删除学生
    public boolean deleteStudentByID(int id);

    //根据学号修改学生信息(根据学号找人然后修改信息)
    public boolean updateStudentByID(int id, Student student);


    //查询全部学生
    public List<Student> queryAllStudents();

}
