package com.whiterose.springboot.entities;

import com.whiterose.springboot.dao.IFacultyDao;
import com.whiterose.springboot.dao.impl.FacultyDaoImpl;

import java.util.Date;



public class Student {
    private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private Faculty faculty;
//    private Date birth;
    private Integer age;
    //外键
    private Integer facultyID;
    IFacultyDao facultyDao = new FacultyDaoImpl();


    public Student(Integer id, String lastName, String email, Integer gender, Faculty faculty, Integer age) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.faculty = faculty;
        this.age = age;
    }

    public Student(Integer id, String lastName, String email, Integer gender, Integer facultyID, Integer age) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.facultyID = facultyID;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", facultyID=" + facultyID +
                ", age=" + age +
                '}';
    }

    public Student(){
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public void setFacultyID(Integer facultyID) {
        this.facultyID = facultyID;
    }

    public Integer getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public Integer getGender() {
        return gender;
    }

    public Integer getFacultyID() {
        return facultyID;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Faculty getFaculty() {
       return faculty;
    }

    public Faculty gotFaculty(){
        return facultyDao.queryFacultyByID(facultyID);
    }



    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
        this.facultyID = faculty.getId();
    }
}
