package com.example.MyWebAppDemo.service.student.impl;


import com.example.MyWebAppDemo.dao.student.StudentServiceDao;
import com.example.MyWebAppDemo.dao.student.impl.StudentServiceDaoImpl;
import com.example.MyWebAppDemo.model.StudentBean;

import com.example.MyWebAppDemo.service.student.StudentService;

import java.util.List;

/**
 * 学生的实现类
 * 增加信息、查询信息、删除信息、修改信息
 */
public class StudentServiceImpl implements StudentService {
    //注入学生dao层接口————业务层关联数据库
    StudentServiceDao StudentServiceDao = new StudentServiceDaoImpl();

    /**
     * 添加学生信息
     * 功能描述：传递此方法调用者的数据提供到学生数据层(Dao层AddDaoStudentInfo()方法中使用)后执行数据库操作
     *
     * @param studentBean 调用者传递过来的StudentBean对象数据
     * @return 数据库的查询数据(查询结果)返回给调用者
     */
    @Override
    public int addStudentServiceInfo(StudentBean studentBean) {//用于学生对象值传递到dao里进行数据操作
        return StudentServiceDao.AddDaoStudentInfo(studentBean);//返回查询数据;
    }

    /**
     * 通过学号查询学生相关的全部信息
     * 功能描述：传递此方法调用者的数据提供到学生数据层(Dao层的queryStudentByStuNo()方法中使用)后执行数据库操作
     *
     * @param intStuNo 调用者传递过来的学号
     * @return 数据库的查询数据(查询结果)返回给调用者
     */
    @Override
    public StudentBean queryStudentServiceBySnoInfo(int intStuNo) {
        return StudentServiceDao.queryDaoStudentByStuNoInfo(intStuNo);
    }

    /**
     * 通过学生id删除对应学生的全部信息
     * 功能描述：传递此方法调用者的数据提供到学生数据层(Dao层的deleteDaoStudentBySidInfo()方法中使用)后执行数据库操作
     *
     * @param stuId
     */
    @Override
    public int deleteStudentServiceBySidInfo(int stuId) {
        return StudentServiceDao.deleteDaoStudentBySidInfo(stuId);
    }

    /**
     * 通过学生id修改对应学生的全部信息
     * 功能描述：传递此方法调用者的数据提供到学生数据层(Dao层的updateStudentServiceBySidInfo方法中使用)后执行数据库操作
     *
     * @param studentBean 调用者传递过来的StudentBean对象数据
     * @return
     */
    @Override
    public int updateStudentServiceByStudent(StudentBean studentBean) {
        return StudentServiceDao.updateStudentServiceByStudent(studentBean);
    }

    /**
     * 查询所有学生
     *
     * @return
     */
    @Override
    public List<StudentBean> queryAllStudentServiceInfo() {
        return StudentServiceDao.queryAllStudentServiceInfo();
    }
}
