package com.whiterose.springboot.dao;

import com.whiterose.springboot.entities.Grade;

import java.util.List;

public interface IGradeDao {

    //根据学生的学号来查询学生的具体信息
    public Grade queryGradeByID(int id) ;

    //查询学生是否存在
    public boolean isExist(int id);


    //增加学生成绩
    public boolean addGrade(Grade grade);

    //根据学号删除学生成绩
    public boolean deleteGradeByID(int id);

    //根据学号修改学生信息(根据学号找人然后修改信息)(成绩）
    public boolean updateGradeByID(int id, Grade grade);


    //查询全部学生成绩
    public List<Grade> queryAllGrade();


}
