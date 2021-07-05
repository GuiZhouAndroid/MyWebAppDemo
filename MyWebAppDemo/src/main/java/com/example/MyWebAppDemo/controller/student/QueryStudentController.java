package com.example.MyWebAppDemo.controller.student;

import com.example.MyWebAppDemo.BaseStudentController;
import com.example.MyWebAppDemo.model.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/QueryStudentControllerDo")
public class QueryStudentController extends BaseStudentController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //web页面客户端通过req.getParameter()传递数据到Tomcat服务器中
        String strStuNo = req.getParameter("stu_no");
        if (strStuNo.equals("")) {
            req.setAttribute("stuQueryNullMessage", "查询失败，输入学号格式不合法！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuQueryNullMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
        } else {//查询内容不为空值时
            //获取学号
            int intStuNo = Integer.parseInt(strStuNo);
            System.out.println("获取标签中的学号======" + intStuNo);
            //开始数据库操作
            StudentBean student_db = studentService.queryStudentServiceBySnoInfo(intStuNo);
            System.out.println("数据库返回查询数据====" + student_db);
            if (student_db == null) {//数据库没数据返回时
                req.setAttribute("stuQueryErrorMessage", "查询失败，学号" + strStuNo + "不存在！");//value存到Servlet的key
                req.getRequestDispatcher("/view/student/message/stuQueryErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            } else {//数据库有数据返回时
                //创建服务器会话对象，把student_dbs存放在Tomcat中，关闭服务器端中会话session.invalidate();
                // web.xml配置时效20000秒
                // Tomcat安装目录——conf目录——server.xml也可以配置
                HttpSession session = req.getSession();
                session.setAttribute("student_db", student_db);
                System.out.println("准备在jsp解析的学生对象数据=====" + student_db);
                //跳转消息信息
                req.setAttribute("stuQuerySuccessMessage", "查询成功！");//value存到Servlet的key
                req.getRequestDispatcher("/view/student/message/stuQuerySuccessMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            }
        }
    }
}
