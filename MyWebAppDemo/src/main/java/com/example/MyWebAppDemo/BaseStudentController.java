package com.example.MyWebAppDemo;

import com.example.MyWebAppDemo.service.student.StudentService;
import com.example.MyWebAppDemo.service.student.impl.StudentServiceImpl;

import javax.servlet.http.HttpServlet;

public class BaseStudentController extends HttpServlet {
    //-->注入学生业务层接口
    public StudentService studentService = new StudentServiceImpl();
}
