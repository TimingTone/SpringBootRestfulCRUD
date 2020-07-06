package com.whiterose.springboot.controller;

import com.whiterose.springboot.dao.*;
import com.whiterose.springboot.dao.impl.GradeDaoImpl;
import com.whiterose.springboot.dao.impl.StudentDaoImpl;
import com.whiterose.springboot.entities.Grade;
import com.whiterose.springboot.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class GradeController {
    @Autowired
    GradeDao gradeDao;
    IGradeDao iGradeDao = new GradeDaoImpl();
    IStudentDao iStudentDao = new StudentDaoImpl();

    //查询所有学生成绩返回列表页面(GET请求方式)
    @GetMapping("/grds")
    public String list(Model model){
        Collection<Grade> grades = iGradeDao.queryAllGrade();
        //放在请求域中
        model.addAttribute("grds", grades);
        //classpath:/templates/xxxx.html(xxxx为返回值)
        return "grd/list_grd";
    }

    //进入学生成绩添加页面
    @GetMapping("/grd")
    public String toAddPage(Model model){
        //查出部门并显示
        Collection<Grade> grades = iGradeDao.queryAllGrade();
        model.addAttribute("facus",grades);
        return "grd/add_grd";
    }

    //提交学生成绩添加
    @PostMapping("/grd")
    public String AddGrd(Grade grade){
        gradeDao.save(grade);
        //来到学生成绩列表页面,转到list_stu页面
        return "redirect:/grds";
    }

    //进入学生信息页面
    @GetMapping("/grd/{id}")
    public String toEditStu(@PathVariable("id") Integer id, Model model){
        Grade grade = iGradeDao.queryGradeByID(id);
        model.addAttribute("grd",grade);
        return "grd/add_grd";
    }

    //学生成绩修改
    @PutMapping("/grd")
    public String updateStudent(Grade grade){
        gradeDao.save(grade);
        return "redirect:/grds";
    }

    //学生成绩删除
    @DeleteMapping("/grd/{id}")
    public String deleteGrade(@PathVariable("id") Integer id){
        Student student = iStudentDao.queryStudentByID(id);
        if(student.getState() == 0)
            iGradeDao.deleteGradeByID(id);
        return "redirect:/grds";
    }

}
