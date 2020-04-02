package com.whiterose.springboot.dao;


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

    static{
        students = new HashMap<Integer, Student>();

        students.put(20183000, new Student(20183000, "E-AA", "aa@163.com", 1, new Faculty(101, "计算机系")));
        students.put(20183001, new Student(20183001, "E-BB", "bb@163.com", 1, new Faculty(102, "数学系")));
        students.put(20183002, new Student(20183002, "E-CC", "cc@163.com", 0, new Faculty(103, "外语系")));
        students.put(20183003, new Student(20183003, "E-DD", "dd@163.com", 0, new Faculty(104, "经管系")));
        students.put(20183004, new Student(20183004, "E-EE", "ee@163.com", 1, new Faculty(105, "航天系")));
    }

    private static Integer initId = 1006;

    public void save(Student student){
        if(student.getId() == null){
            student.setId(initId++);
        }

        student.setFaculty(FacultyDao.getFaculty(student.getFaculty().getId()));
        students.put(student.getId(), student);
    }

    //查询所有员工
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
