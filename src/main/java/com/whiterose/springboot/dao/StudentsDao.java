package com.whiterose.springboot.dao;


import com.whiterose.springboot.dao.impl.StudentDaoImpl;
import com.whiterose.springboot.entities.Faculty;
import com.whiterose.springboot.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentsDao {
    private static Map<Integer, Student> students = null;

    @Autowired
    private FacultyDao facultyDao;


    private static Integer initId = 1006;


    //修改学生信息
    public void update(Student student){
        if(student.getId() == null){
            student.setId(initId++);
        }

        IStudentDao studentDao = new StudentDaoImpl();
        student.setFacultyID(student.getFaculty().getId());
        student.setFaculty(FacultyDao.getFaculty(student.getFaculty().getId()));
        studentDao.updateStudentByID(student.getId(), student);
    }

    //增加学生
    public void add(Student student){
        if(student.getId() == null){
            student.setId(initId++);
        }

        IStudentDao studentDao = new StudentDaoImpl();
        student.setFacultyID(student.getFaculty().getId());
        student.setFaculty(FacultyDao.getFaculty(student.getFaculty().getId()));
        //防止ID重复
        studentDao.deleteStudentByID(student.getId());
        studentDao.addStudent(student);
    }

    //查询所有学生
    public Collection<Student> getAll(){
        return students.values();
    }

    public Student get(Integer id){
        return students.get(id);
    }

    public void delete(Integer id){
        students.remove(id);
    }


}
