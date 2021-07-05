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

@WebServlet("/QueryAllStudentController")
public class QueryAllStudentController extends BaseStudentController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决客户端和服务端传递中文数据时乱码问题(setAttribute与getParameter)
        req.setCharacterEncoding("UTF-8");
        List<StudentBean> studentBeanLists = studentService.queryAllStudentServiceInfo();
        System.out.println("studentBeanLists======" + studentBeanLists);
        //返回数据
        if (studentBeanLists != null) {
            HttpSession session = req.getSession();
            session.setAttribute("studentBeanLists", studentBeanLists);
            //req.setAttribute("studentBeanLists", studentBeanLists);
            req.setAttribute("stuQueryAllSuccessMessage", "正在查询中，请稍候...");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuQueryAllSuccessMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
        }
        req.setAttribute("stuQueryAllErrorMessage", "查询失败！");//value存到Servlet的key
        req.getRequestDispatcher("/view/student/message/stuQueryAllErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
    }
}
