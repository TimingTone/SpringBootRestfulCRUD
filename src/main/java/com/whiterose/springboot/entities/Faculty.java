package com.whiterose.springboot.entities;

public class Faculty {

    private Integer id;
    private String FacultyName;

    public Faculty(){
    }

    public Faculty(Integer id, String FacultyName) {
        this.id = id;
        this.FacultyName = FacultyName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFacultyName() {
        return FacultyName;
    }

    public void setFacultyName(String facultyName) {
        FacultyName = facultyName;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", FacultyName='" + FacultyName + '\'' +
                '}';
    }
}
