package com.example.MyWebAppDemo.controller.student;

import com.example.MyWebAppDemo.BaseStudentController;
import com.example.MyWebAppDemo.model.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/UpdateStudentController")
public class UpdateStudentController extends BaseStudentController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决客户端和服务端传递中文数据时乱码问题(setAttribute与getParameter)
        req.setCharacterEncoding("UTF-8");
        //获取学生更新的数据
        String stuInputId = req.getParameter("stuInputId");//id
        String stuInputNo = req.getParameter("stuInputNo");//学号
        String stuInputName = req.getParameter("stuInputName");//姓名
        String stuInputClass = req.getParameter("stuInputClass");//班级
        String stuInputAge = req.getParameter("stuInputAge");//年龄
        String stuInputSex = req.getParameter("stuInputSex");//性别
        String stuInputBirthday = req.getParameter("stuInputBirthday");//生日

        System.out.println("需要修改stuInputId====" + stuInputId);//id
        System.out.println("需要修改stuInputNo====" + stuInputNo);//学号
        System.out.println("需要修改stuInputName====" + stuInputName);//姓名
        System.out.println("需要修改stuInputClass====" + stuInputClass);//班级
        System.out.println("需要修改stuInputAge====" + stuInputAge);//年龄
        System.out.println("需要修改stuInputSex====" + stuInputSex);//性别
        System.out.println("需要修改stuInputNo====" + stuInputBirthday);//生日

        StudentBean studentBean = new StudentBean();
        studentBean.setStu_id(Integer.parseInt(stuInputId));//id
        studentBean.setStu_no(stuInputNo);//学号
        studentBean.setStu_name(stuInputName);//姓名
        studentBean.setStu_class(stuInputClass);//班级
        studentBean.setStu_age(stuInputAge);//年龄
        studentBean.setStu_sex(stuInputSex);//性别
        studentBean.setStu_birthday(stuInputBirthday);//生日
        System.out.println("待更新studentBean====" + studentBean);
        int flag = studentService.updateStudentServiceByStudent(studentBean);

        if (flag > 0) {
            //开始数据库操作
            System.out.println("Integer.parseInt(stuInputId)===" + Integer.parseInt(stuInputId));
            StudentBean student_db = studentService.queryStudentServiceBySnoInfo(Integer.parseInt(stuInputNo));
            req.getSession().setAttribute("student_db", student_db);
            System.out.println("准备在jsp解析的学生对象数据=====" + student_db);
            HttpSession session = req.getSession();
            session.setAttribute("student_db", student_db);
            //跳转消息信息
            req.setAttribute("stuUpdateSuccessMessage", "更新成功！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuUpdateSuccessMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            System.out.println("更新成功！");
        } else {
            req.setAttribute("stuUpdateErrorMessage", "更新失败，学号已存在或输入格式有误！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuUpdateErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            System.out.println("更新失败！");
        }
    }
}
