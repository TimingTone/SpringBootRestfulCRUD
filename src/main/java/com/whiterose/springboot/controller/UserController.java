package com.whiterose.springboot.controller;

import com.whiterose.springboot.dao.IUserDao;
import com.whiterose.springboot.dao.UserDao;
import com.whiterose.springboot.dao.impl.UserDaoImpl;
import com.whiterose.springboot.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class UserController {
    @Autowired
    UserDao userDao;
    IUserDao iUserDao = new UserDaoImpl();

    //查询所有用户返回列表页面(GET请求方式)
    @GetMapping("/regs")
    public String list(Model model){
        Collection<User> users = iUserDao.queryAllUser();
        //放在请求域中
        model.addAttribute("regs", users);
        //classpath:/templates/xxxx.html(xxxx为返回值)
        return "reg/list_reg";
    }

    //进入用户添加页面
    @GetMapping("/reg")
    public String toAddPage(Model model){
        Collection<User> users = iUserDao.queryAllUser();
        return "reg/add_reg";
    }

    //提交用户添加
    @PostMapping("/reg")
    public String AddUser(User user){
        userDao.add(user);
        //来到学生成绩列表页面,转到list_stu页面
        return "redirect:/regs";
    }

    //进入用户页面
    @GetMapping("/reg/{uno}")
    public String toEditUser(@PathVariable("uno") String uno, Model model){
        User user = iUserDao.queryUserByUno(uno);
        model.addAttribute("reg",user);
        return "reg/add_reg";
    }

    //用户密码修改
    @PutMapping("/reg")
    public String updateUser(User user){
        userDao.update(user);
        return "redirect:/regs";
    }

    //用户删除
    @DeleteMapping("/reg/{uno}")
    public String deleteUser(@PathVariable("uno") String uno){
        iUserDao.deleteUserByUno(uno);
        return "redirect:/regs";
    }
}
