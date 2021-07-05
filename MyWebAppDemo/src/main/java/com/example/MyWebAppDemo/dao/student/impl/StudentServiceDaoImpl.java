package com.example.MyWebAppDemo.dao.student.impl;

import com.example.MyWebAppDemo.dao.student.StudentServiceDao;
import com.example.MyWebAppDemo.model.StudentBean;
import com.example.MyWebAppDemo.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentServiceDaoImpl implements StudentServiceDao {
    //与特定数据库的连接(会话)，在连接的上下文中执行SQL语句并返回结果。
    private Connection connection = null;
    //表示预编译SQL语句的对象。SQL语句被预编译并存储在PreparedStatement对象中,然后可以使用该对象多次有效地执行此语句。
    private PreparedStatement preparedStatement = null;

    /**
     * 添加学生信息
     *
     * @param studentBean 封装的学生对象数据
     * @return 返回值结果 0为失败 1为成功
     */
    @Override
    public int AddDaoStudentInfo(StudentBean studentBean) {
//        StudentBean{stu_id=null, stu_no='1887', stu_name='张三', stu_class='张三', stu_age='张三', stu_sex='女', stu_birthday='ASD'}
        //涉及IO数据流，进行异常捕捉
        try {
            //从项目src/main/resources/路径下获取 DB.properties 配置文件已驱动数据库的连接地址、端口号、数据库名、用户名、密码
            connection = JdbcUtils.getConnection();
            String sql = "INSERT INTO student (stu_no,stu_name,stu_class,stu_age,stu_sex,stu_birthday) VALUES(?,?,?,?,?,?)";
            //把需要执行的SQL语句传到预编译SQL语句prepareStatement对象里，并赋值给preparedStatement，用于通过索引添加表数据。
            preparedStatement = connection.prepareStatement(sql);
            //简化 Connection connection = null;
            //PreparedStatement preparedStatement = JdbcUtils.getConnection().prepareStatement(sql);

            //studentBean是 AddStudentController(servlet)————传递————service(接口)————传递————dao(数据层)————传递到当前类的本方法AddDaoStudentInfo()中的java对象数据

            preparedStatement.setString(1, studentBean.getStu_no());//插入学号
            preparedStatement.setString(2, studentBean.getStu_name());//插入姓名
            preparedStatement.setString(3, studentBean.getStu_class());//插入班级
            preparedStatement.setString(4, studentBean.getStu_age());//插入年龄
            preparedStatement.setString(5, studentBean.getStu_sex());//插入性别
            preparedStatement.setString(6, studentBean.getStu_birthday());//插入生日
            //执行INSERT、UPDATE、DELETE 语句以及 SQL DDL（数据定义语言）等SQL语句且操作数据(添加)，executeUpdate的返回值总为零
            int n = preparedStatement.executeUpdate();
            //数据库操作结束后，跳出当前当然AddDaoStudentInfo(),并返回值到AddStudentServiceImpl的实现类的addStudentServiceInfo()中
            return n;

        } catch (Exception e) {//异常打印
            e.printStackTrace();//打印栈内存日志
        } finally {
            try {
                //关闭SQL执行对象流
                preparedStatement.close();
                //关闭数据库
                connection.close();
            } catch (SQLException sqlException) {
                //打印SQL执行过程中的异常信息
                sqlException.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * 学号查询学生全部信息
     *
     * @param intStuNo
     * @return 返回studentBean
     */
    @Override
    public StudentBean queryDaoStudentByStuNoInfo(int intStuNo) {
        //结果集
        ResultSet rs = null;
        // 查询数据库
        try {
            connection = JdbcUtils.getConnection();
            String sql = "SELECT * FROM student WHERE stu_no=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, intStuNo);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                StudentBean studentBean = new StudentBean();
                studentBean.setStu_id(rs.getInt("stu_id"));//查询学生id
                studentBean.setStu_no(rs.getString("stu_no"));//查询学号
                studentBean.setStu_name(rs.getString("stu_name"));//查询姓名
                studentBean.setStu_class(rs.getString("stu_class"));//查询班级
                studentBean.setStu_age(rs.getString("stu_age"));//查询年龄
                studentBean.setStu_sex(rs.getString("stu_sex"));//查询性别
                studentBean.setStu_birthday(rs.getString("stu_birthday"));//查询生日
                System.out.println("学号查询全部信息===" + studentBean);
                //查询成功，返回studentBean
                return studentBean;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //查询失败返回null
        return null;
    }

    /**
     * @param stuId 学生id
     * @return 返回值结果 0为失败 1为成功
     */
    @Override
    public int deleteDaoStudentBySidInfo(int stuId) {
        try {
            connection = JdbcUtils.getConnection();
            String sql = "DELETE FROM student WHERE stu_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, stuId);
            int m = preparedStatement.executeUpdate();
            System.out.println("数据库删除的结果m====" + m);
            //返回值结果
            return m;
        } catch (Exception e) {
            e.printStackTrace();
        }
        //查询失败返回0
        return 0;
    }

    /**
     * 通过学生Id更新学生的全部信息
     */
    /**
     * @param studentBean
     * @return
     */
    @Override
    public int updateStudentServiceByStudent(StudentBean studentBean) {
        System.out.println("Dao+++studentBean========" + studentBean);
        try {
            connection = JdbcUtils.getConnection();
//            String sql = "UPDATE student SET stu_name=?,stu_class=?,stu_age?,stu_sex=?,stu_birthday=? WHERE stu_no=?";
//            String sql = "UPDATE student SET stu_no=?,stu_name=?,stu_class=?,stu_age=?,stu_sex=?,stu_birthday=? WHERE stu_id=?";
            String sql = "UPDATE student SET stu_no=?,stu_name=?,stu_class=?,stu_age=?,stu_sex=?,stu_birthday=? WHERE stu_id=?";
            System.out.println("sql====" + sql);
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("preparedStatement====" + preparedStatement);
            preparedStatement.setString(1, studentBean.getStu_no());
            preparedStatement.setString(2, studentBean.getStu_name());
            preparedStatement.setString(3, studentBean.getStu_class());
            preparedStatement.setString(4, studentBean.getStu_age());
            preparedStatement.setString(5, studentBean.getStu_sex());
            preparedStatement.setString(6, studentBean.getStu_birthday());
            preparedStatement.setInt(7, studentBean.getStu_id());
            int value = preparedStatement.executeUpdate();
            System.out.println("更新后value===" + value);
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 查询所有学生的信息
     *
     * @return 返回List集合对象数据
     */
    @Override
    public List<StudentBean> queryAllStudentServiceInfo() {
        //结果集
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            String sql = "select * from student";
            preparedStatement = connection.prepareStatement(sql);
            rs = preparedStatement.executeQuery();
            List<StudentBean> studentBeanList = new ArrayList<>();
            while (rs.next()) {
                StudentBean studentBean = new StudentBean();
                studentBean.setStu_id(rs.getInt("stu_id"));
                studentBean.setStu_no(rs.getString("stu_no"));
                studentBean.setStu_name(rs.getString("stu_name"));
                studentBean.setStu_class(rs.getString("stu_class"));
                studentBean.setStu_age(rs.getString("stu_age"));
                studentBean.setStu_sex(rs.getString("stu_sex"));
                studentBean.setStu_birthday(rs.getString("stu_birthday"));
                studentBeanList.add(studentBean);
                System.out.println("分开的studentBeanList===" + studentBeanList);
            }
            System.out.println("合并studentBeanList===" + studentBeanList);
            return studentBeanList;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

