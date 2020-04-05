package com.whiterose.springboot.dao;

import com.whiterose.springboot.entities.Faculty;

import java.util.Collection;

public interface IFacultyDao {

    //查询所有的部门
    public Collection<Faculty> queryAllFaculties();

    //根据系的id来查询系的具体信息
    public Faculty queryFacultyByID(int id);

    //根据facultyName来查询系的具体信息
    public Faculty queryFacultyByName(String name);
}
