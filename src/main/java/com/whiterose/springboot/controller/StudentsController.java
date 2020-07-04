package com.whiterose.springboot.controller;

import com.whiterose.springboot.dao.FacultyDao;
import com.whiterose.springboot.dao.IFacultyDao;
import com.whiterose.springboot.dao.IStudentDao;
import com.whiterose.springboot.dao.StudentsDao;
import com.whiterose.springboot.dao.impl.FacultyDaoImpl;
import com.whiterose.springboot.dao.impl.StudentDaoImpl;
import com.whiterose.springboot.entities.Faculty;
import com.whiterose.springboot.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class StudentsController {
    @Autowired
    StudentsDao studentsDao;
//    @Autowired
//    FacultyDao facultyDao;

    IStudentDao studentDao = new StudentDaoImpl();
    IFacultyDao facultyDao = new FacultyDaoImpl();

    //查询所有学生返回列表页面(GET请求方式)
    @GetMapping("/stus")
    public String list(Model model){
        Collection<Student> students = studentDao.queryAllStudents();
        //放在请求域中
        model.addAttribute("stus", students);
        //classpath:/templates/xxxx.html(xxxx为返回值)
        return "stu/list_stu";
    }

    //进入学生添加页面
    @GetMapping("/stu")
    public String toAddPage(Model model){
        //查出部门并显示
        Collection<Faculty> faculties = facultyDao.queryAllFaculties();
        model.addAttribute("facus",faculties);
        return "stu/add_stu";
    }

    //提交学生添加
    @PostMapping("/stu")
    public String AddStu(Student student){
//        System.out.println("保存的学生信息：" + student);
        studentsDao.add(student);
        //来到学生列表页面,转到list_stu页面
        return "redirect:/stus";
    }

    //进入学生信息页面
    @GetMapping("/stu/{id}")
    public String toEditStu(@PathVariable("id") Integer id, Model model){
        Student student = studentDao.queryStudentByID(id);
        model.addAttribute("stu",student);

        Collection<Faculty> faculties = facultyDao.queryAllFaculties();
        model.addAttribute("facus", faculties);
        return "stu/add_stu";
    }

    //学生修改
    @PutMapping("/stu")
    public String updateStudent(Student student){
        studentsDao.update(student);
        return "redirect:/stus";
    }

    //学生删除
    @DeleteMapping("/stu/{id}")
    public String deleteStudent(@PathVariable("id") Integer id){
        studentDao.deleteStudentByID(id);
        return "redirect:/stus";
    }

}
