package com.whiterose.springboot.entities;

import java.util.Date;

public class Student {
    private Integer id;
    private String lastName;

    private String email;
    //1 male, 0 female
    private Integer gender;
    private Faculty faculty;
    private Date birth;

    public Student(Integer id, String lastName, String email, Integer gender, Faculty faculty) {
        super();
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.faculty = faculty;
        this.birth = new Date();
    }


    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", faculty=" + faculty +
                ", birth=" + birth +
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

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
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

    public Faculty getFaculty() {
        return faculty;
    }

    public Date getBirth() {
        return birth;
    }
}
