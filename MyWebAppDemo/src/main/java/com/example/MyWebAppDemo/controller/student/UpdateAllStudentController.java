package com.example.MyWebAppDemo.controller.student;

import com.example.MyWebAppDemo.BaseStudentController;
import com.example.MyWebAppDemo.model.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/updateAllStudentController")
public class UpdateAllStudentController extends BaseStudentController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //解决客户端和服务端传递中文数据时乱码问题(setAttribute与getParameter)
        req.setCharacterEncoding("UTF-8");
        //获取学生更新的数据
        String stuAllInputId = req.getParameter("stuAllInputId");//id
        String stuAllInputNo = req.getParameter("stuAllInputNo");//学号
        String stuAllInputName = req.getParameter("stuAllInputName");//姓名
        String stuAllInputClass = req.getParameter("stuAllInputClass");//班级
        String stuAllInputAge = req.getParameter("stuAllInputAge");//年龄
        String stuAllInputSex = req.getParameter("stuAllInputSex");//性别
        String stuAllInputBirthday = req.getParameter("stuAllInputBirthday");//生日

        System.out.println("需要修改stuAllInputNo====" + stuAllInputId);//id
        System.out.println("需要修改stuAllInputNo====" + stuAllInputNo);//学号
        System.out.println("需要修改stuAllInputName====" + stuAllInputName);//姓名
        System.out.println("需要修改stuAllInputClass====" + stuAllInputClass);//班级
        System.out.println("需要修改stuAllInputAge====" + stuAllInputAge);//年龄
        System.out.println("需要修改stuAllInputSex====" + stuAllInputSex);//性别
        System.out.println("需要修改stuAllInputBirthday====" + stuAllInputBirthday);//生日

        StudentBean AllStudentBean = new StudentBean();
        AllStudentBean.setStu_id(Integer.parseInt(stuAllInputId));//id
        AllStudentBean.setStu_no(stuAllInputNo);//学号
        AllStudentBean.setStu_name(stuAllInputName);//姓名
        AllStudentBean.setStu_class(stuAllInputClass);//班级
        AllStudentBean.setStu_age(stuAllInputAge);//年龄
        AllStudentBean.setStu_sex(stuAllInputSex);//性别
        AllStudentBean.setStu_birthday(stuAllInputBirthday);//生日
        System.out.println("待更新AllStudentBean====" + AllStudentBean);
        int flag = studentService.updateStudentServiceByStudent(AllStudentBean);

        if (flag > 0) {
            //开始数据库操作
//            System.out.println("Integer.parseInt(stuAllInputId)==="+Integer.parseInt(stuAllInputId));
//            StudentBean student_db = studentService.queryStudentServiceBySnoInfo(Integer.parseInt(stuAllInputNo));
//            req.getSession().setAttribute("student_db", student_db);
//            System.out.println("准备在jsp解析的学生对象数据=====" + student_db);
//            HttpSession session = req.getSession();
//            session.setAttribute("student_db", student_db);
//            //跳转消息信息
//            req.setAttribute("stuAllUpdateSuccessMessage", "更新成功！");//value存到Servlet的key
//            req.getRequestDispatcher("/view/student/message/stuAllUpdateSuccessMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
//            System.out.println("更新成功！");
            List<StudentBean> studentBeanLists = studentService.queryAllStudentServiceInfo();
            System.out.println("studentBeanLists======" + studentBeanLists);
            //返回数据
            if (studentBeanLists != null) {
                HttpSession session = req.getSession();
                session.setAttribute("studentBeanLists", studentBeanLists);
                //req.setAttribute("studentBeanLists", studentBeanLists);
                req.setAttribute("stuAllUpdateSuccessMessage", "更新成功！");//value存到Servlet的key
                req.getRequestDispatcher("/view/student/message/stuAllUpdateSuccessMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            }
//            req.setAttribute("stuQueryAllErrorMessage", "查询失败！");//value存到Servlet的key
//            req.getRequestDispatcher("/view/student/message/stuQueryAllErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
        } else {
            req.setAttribute("stuAllUpdateErrorMessage", "更新失败，学号已存在或输入格式有误！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuAllUpdateErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            System.out.println("更新失败！");
//            req.setAttribute("stuQueryAllErrorMessage", "更新失败，学号已存在或输入格式有误！");//value存到Servlet的key
//            req.getRequestDispatcher("/view/student/message/stuQueryAllErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
//            req.setAttribute("stuAllUpdateErrorMessage", "更新失败，学号已存在或输入格式有误！");//value存到Servlet的key
//            req.getRequestDispatcher("/view/student/message/stuAllUpdateErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
//            System.out.println("更新失败！");
        }
    }
}