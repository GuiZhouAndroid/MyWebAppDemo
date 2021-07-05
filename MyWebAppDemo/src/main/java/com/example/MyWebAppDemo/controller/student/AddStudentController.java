package com.example.MyWebAppDemo.controller.student;

import com.example.MyWebAppDemo.BaseStudentController;
import com.example.MyWebAppDemo.model.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddStudentController")
public class AddStudentController extends BaseStudentController {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //步骤1.设置字符编码格式
        req.setCharacterEncoding("utf-8");
        //步骤2.从请求中获取JSP页面的学生数据
        String strStuNo = req.getParameter("stu_no");//获取学号
        String strStuName = req.getParameter("stu_name");//获取姓名
        String strStuClass = req.getParameter("stu_class");//获取班级
        String strStuAge = req.getParameter("stu_age");//获取年龄
        String strStuSex = req.getParameter("stu_sex");//获取性别
        String strStuBirthday = req.getParameter("stu_birthday");//获取生日

        System.out.println("获取JSP页面学号=" + strStuNo);
        System.out.println("获取JSP页面姓名=" + strStuName);
        System.out.println("获取JSP页面班级=" + strStuClass);
        System.out.println("获取JSP页面年龄=" + strStuAge);
        System.out.println("获取JSP页面性别=" + strStuSex);
        System.out.println("获取JSP页面生日=" + strStuBirthday);

        //判断添加内容是否存在空填项
        if (strStuNo.isEmpty() && strStuSex.equals("") || strStuName.isEmpty() && strStuName.equals("")
                || strStuClass.isEmpty() && strStuClass.equals("") || strStuAge.isEmpty() && strStuAge.equals("")
                || strStuSex.isEmpty() && strStuSex.equals("") || strStuBirthday.isEmpty() && strStuBirthday.equals("")) {
            req.setAttribute("stuAddNullMessage", "添加失败，请填写所有添加信息！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuAddNullMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            return;//跳出当前的doPost()方法，这个return语句以下的代码块永远不执行
        }
        //信息填好后，传入学号开始数据库操作
        StudentBean student_dbs = studentService.queryStudentServiceBySnoInfo(Integer.parseInt(strStuNo));
        System.out.println("信息填好后，数据库返回的student_dbs===" + student_dbs);
        if (student_dbs != null) {// student_dbs不为空，说明数据库返回了该学号及其相关数据
            if (student_dbs.getStu_no().equals(strStuNo)) {//匹配输入学号与存在学号
                //学号相同时，跳转失败消息页面
                req.setAttribute("stuAddErrorMessage", "添加失败，学号'" + strStuNo + "'已存在！");
                req.getRequestDispatcher("/view/student/message/stuAddErrorMessage.jsp").forward(req, resp);
            }
        } else {//student_dbs为空 说明数据库不存在该学号及其相关数据，开始添加数据
            //学生信息封装到实体类——StudentBean.java中
            StudentBean studentBean = new StudentBean();//创建一个学生
            //开始封装
            studentBean.setStu_no(strStuNo);//封装学号
            studentBean.setStu_name(strStuName);//封装姓名
            studentBean.setStu_class(strStuClass);//封装班级
            studentBean.setStu_age(strStuAge);//封装年龄
            studentBean.setStu_sex(strStuSex);//封装性别
            studentBean.setStu_birthday(strStuBirthday);//封装生日
            System.out.println("封装后的studentBean====" + studentBean);

            //数据库添加信息
            int flag = studentService.addStudentServiceInfo(studentBean);
            System.out.println("添加成功数据库返回的i=======" + flag);
            if (flag > 0) {
                req.setAttribute("stuAddSuccessMessage", "添加成功！");
                req.getRequestDispatcher("/view/student/message/stuAddSuccessMessage.jsp").forward(req, resp);
            } else {
                //添加失败，跳转失败消息页面————比如性别输入数字，超过varchar(2)范围等原因
                req.setAttribute("stuAddOtherMessage", "添加失败，格式不正确！");
                req.getRequestDispatcher("/view/student/message/stuAddOtherMessage.jsp").forward(req, resp);
            }
        }
    }
}
