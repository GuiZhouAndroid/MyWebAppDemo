package com.example.MyWebAppDemo.dao.student;

import com.example.MyWebAppDemo.model.StudentBean;

import java.util.List;

public interface StudentServiceDao {
    //添加学生信息
    int AddDaoStudentInfo(StudentBean studentBean);

    //通过学号查询学生相关的全部信息
    StudentBean queryDaoStudentByStuNoInfo(int intStuNo);

    //通过学生id删除对应学生的全部信息
    int deleteDaoStudentBySidInfo(int stuId);

    //学生id查询该学生全部信息
    int updateStudentServiceByStudent(StudentBean studentBean);

    //查询所有学生的信息
    List<StudentBean> queryAllStudentServiceInfo();
}
