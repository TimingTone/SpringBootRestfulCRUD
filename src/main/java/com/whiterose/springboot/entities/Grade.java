package com.whiterose.springboot.entities;

public class Grade {

    private Integer id;
    private String lastName;
    private Integer math;
    private Integer physics;
    private Integer english;
    private Integer c;
    private Integer polity;

    public Grade(Integer id, String lastName, Integer math, Integer physics, Integer english, Integer c, Integer polity){
        super();
        this.id = id;
        this.lastName = lastName;
        this.math = math;
        this.physics = physics;
        this.english = english;
        this.c = c;
        this.polity = polity;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", math=" + math +
                ", physics=" + physics +
                ", english=" + english +
                ", c=" + c +
                ", polity=" + polity +
                '}';
    }

    public Grade() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMath() {
        return math;
    }

    public void setMath(Integer math) {
        this.math = math;
    }

    public Integer getPhysics() {
        return physics;
    }

    public void setPhysics(Integer physics) {
        this.physics = physics;
    }

    public Integer getEnglish() {
        return english;
    }

    public void setEnglish(Integer english) {
        this.english = english;
    }

    public Integer getC() {
        return c;
    }

    public void setC(Integer c) {
        this.c = c;
    }

    public Integer getPolity() {
        return polity;
    }

    public void setPolity(Integer polity) {
        this.polity = polity;
    }
}
