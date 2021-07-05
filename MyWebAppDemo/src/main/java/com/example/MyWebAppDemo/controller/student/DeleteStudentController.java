package com.example.MyWebAppDemo.controller.student;

import com.example.MyWebAppDemo.BaseStudentController;
import com.example.MyWebAppDemo.model.StudentBean;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 删除学生
 */
@WebServlet("/DeleteStudentController")
public class DeleteStudentController extends BaseStudentController {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String stuDelete_id = req.getParameter("stuDeleteId");
        System.out.println("需要删除stu_id====" + stuDelete_id);
        //开始访问数据库删除数据
        int flag = studentService.deleteStudentServiceBySidInfo(Integer.parseInt(stuDelete_id));
        System.out.println("flag======" + flag);
        StudentBean studentBean = (StudentBean) req.getSession().getAttribute("student_db");
        if (flag > 0) {
            //跳转消息信息
            System.out.println("eeeeeeeeeeee");
            req.setAttribute("stuDeleteSuccessMessage", studentBean.getStu_name() + "同学的信息，已删除成功！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuDeleteSuccessMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            //JOptionPane.showMessageDialog(null, "删除成功！", "温馨提示", JOptionPane.ERROR_MESSAGE, null);
        } else {
            System.out.println("hhhhhhhhhhhhh");
            req.setAttribute("stuDeleteErrorMessage", "删除失败！");//value存到Servlet的key
            req.getRequestDispatcher("/view/student/message/stuDeleteErrorMessage.jsp").forward(req, resp);//请求转发后，跳转到指定的jsp页面
            // JOptionPane.showMessageDialog(null, "删除失败！", "温馨提示", JOptionPane.ERROR_MESSAGE, null);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
