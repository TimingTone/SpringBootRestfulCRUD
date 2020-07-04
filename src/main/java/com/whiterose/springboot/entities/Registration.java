package com.whiterose.springboot.entities;

import java.util.Date;

public class Registration {

    private Integer id;
    private String lastName;
    private String address;
    private Faculty faculty;
    private Integer facultyID;
    private Date birth;
    private Integer grade;//学分
    private Integer state;//是否在读 1：yes 0：no

    public Registration(Integer id, String lastName, String address, Faculty faculty, Date birth, Integer grade, Integer state) {
        this.id = id;
        this.lastName = lastName;
        this.address = address;
        this.faculty = faculty;
        this.birth = birth;
        this.grade = grade;
        this.state = state;
    }
}
