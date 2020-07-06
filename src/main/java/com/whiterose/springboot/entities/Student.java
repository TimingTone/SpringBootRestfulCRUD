package com.whiterose.springboot.entities;

import com.whiterose.springboot.dao.IFacultyDao;
import com.whiterose.springboot.dao.impl.FacultyDaoImpl;

import java.util.Date;



public class Student {
    private Integer id;
    private String lastName;
    private String address;
    private String email;
    //1 male, 0 female
    private Integer gender;
    private Faculty faculty;
    private Date birth;
    private Integer age;
    private Double grade;//学分
    private Integer state;////是否在读 1：yes 0：no
    //外键
    private Integer facultyID;
    IFacultyDao facultyDao = new FacultyDaoImpl();


    public Student(Integer id, String lastName, String address, String email, Integer gender, Faculty faculty, Date birth, Integer age, Double grade, Integer state) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.faculty = faculty;
        this.birth = birth;
        this.age = age;
        this.grade = grade;
        this.state = state;
    }

    public Student(Integer id, String lastName, String address, String email, Integer gender, Integer facultyID, Date birth, Integer age, Double grade, Integer state) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.facultyID = facultyID;
        this.birth = birth;
        this.age = age;
        this.grade = grade;
        this.state = state;
    }

//    @Override
//    public String toString() {
//        return "Students{" +
//                "id=" + id +
//                ", lastName='" + lastName + '\'' +
//                ", email='" + email + '\'' +
//                ", gender=" + gender +
//                ", facultyID=" + facultyID +
//                ", age=" + age +
//                '}';
//    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", age=" + age +
                ", grade=" + grade +
                ", state=" + state +
                ", facultyID=" + facultyID +
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
//        facultyID = faculty.getId();
    }
}
