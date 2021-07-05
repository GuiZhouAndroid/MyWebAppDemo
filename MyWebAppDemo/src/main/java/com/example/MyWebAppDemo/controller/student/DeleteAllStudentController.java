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

/**
 * 删除学生
 */
@WebServlet("/DeleteAllStudentController")
public class DeleteAllStudentController extends BaseStudentController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuAllDeleteId = req.getParameter("stuAllDeleteId");
        System.out.println("需要删除stuAllDeleteId====" + stuAllDeleteId);
        //开始访问数据库删除数据
        int flag = studentService.deleteStudentServiceBySidInfo(Integer.parseInt(stuAllDeleteId));
        System.out.println("flag======" + flag);
        String stuAllDeleteName = req.getParameter("stuAllDeleteName");
        //StudentBean studentBeanLists = (StudentBean) req.getSession().getAttribute("studentBeanLists");
        System.out.println("studentBeanLists" + stuAllDeleteName);
        if (flag > 0) {
            List<StudentBean> studentBeanLists = studentService.queryAllStudentServiceInfo();
            System.out.println("studentBeanLists======" + studentBeanLists);
            //返回数据
            if (studentBeanLists != null) {
                HttpSession session = req.getSession();
                session.setAttribute("studentBeanLists", studentBeanLists);
                //req.setAttribute("studentBeanLists", studentBeanLists);
                //跳转消息信息
                System.out.println("HHH");
                req.setAttribute("stuDeleteAllSuccessMessage", stuAllDeleteName + "同学的信息，已删除成功！");//value存到Servlet的key
                req.getRequestDispatcher("/view/student/message/stuDeleteAllSuccessMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            }
            System.out.println("studentBeanLists" + stuAllDeleteName);
            req.setAttribute("stuDeleteAllErrorMessage", "删除失败！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuDeleteAllErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
        } else {
            System.out.println("studentBeanLists" + stuAllDeleteName);
            req.setAttribute("stuDeleteAllErrorMessage", "删除失败！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuDeleteAllErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            // JOptionPane.showMessageDialog(null, "删除失败！", "温馨提示", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
