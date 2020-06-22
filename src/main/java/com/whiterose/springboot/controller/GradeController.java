package com.whiterose.springboot.controller;

import com.whiterose.springboot.dao.*;
import com.whiterose.springboot.dao.impl.GradeDaoImpl;
import com.whiterose.springboot.entities.Grade;
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

    //提交学生添加
    @PostMapping("/grd")
    public String AddGrd(Grade grade){
//        System.out.println("保存的学生信息：" + student);
        gradeDao.save(grade);
        //来到学生列表页面,转到list_stu页面
        return "redirect:/grds";
    }

    //进入学生信息页面
    @GetMapping("/grd/{id}")
    public String toEditStu(@PathVariable("id") Integer id, Model model){
        Grade grade = iGradeDao.queryGradeByID(id);
        model.addAttribute("grd",grade);

//        Collection<Faculty> faculties = facultyDao.queryAllFaculties();
//        model.addAttribute("facus", faculties);
        return "grd/add_grd";
    }

    //学生修改
    @PutMapping("/grd")
    public String updateStudent(Grade grade){
        gradeDao.save(grade);
        return "redirect:/grds";
    }

    //学生删除
    @DeleteMapping("/grd/{id}")
    public String deleteGrade(@PathVariable("id") Integer id){
        iGradeDao.deleteGradeByID(id);
        return "redirect:/grds";
    }

}