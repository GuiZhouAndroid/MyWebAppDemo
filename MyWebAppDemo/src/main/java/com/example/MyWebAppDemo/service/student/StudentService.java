package com.example.MyWebAppDemo.service.student;

import com.example.MyWebAppDemo.model.StudentBean;

import java.util.List;

/**
 * 学生接口
 */
public interface StudentService {
    //添加学生信息
    int addStudentServiceInfo(StudentBean studentBean);

    //通过学号查询学生信息
    StudentBean queryStudentServiceBySnoInfo(int intStuNo);

    //通过学生id删除学生信息
    int deleteStudentServiceBySidInfo(int stuId);

    int updateStudentServiceByStudent(StudentBean studentBean);

    //查询所有学生
    List<StudentBean> queryAllStudentServiceInfo();
}
