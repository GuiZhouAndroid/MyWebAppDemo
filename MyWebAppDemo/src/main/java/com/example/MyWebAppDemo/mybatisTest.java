package com.example.MyWebAppDemo;

import com.example.MyWebAppDemo.model.StudentBean;
import com.example.MyWebAppDemo.service.student.StudentService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class mybatisTest {
    public static void main(String[] agrs) {
        try {
            //加载mybatis的核心配置文件
            InputStream inputStream = inputStream = Resources.getResourceAsStream("mybatis-cfg.xml");
            /**
             * 使用资源文件流来获取数据库会话工厂对象（有开始，有结束）
             * 会话工厂：首先是一个工厂，是指所有生产线都在一起，每个人访问就是一条生产线
             * 获取数据库会话：Java代码与数据库的一次会话，相当于Java代码和数据库就有了联系
             */
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            //打开会话工厂
            SqlSession sqlSession = sqlSessionFactory.openSession();
            //打印会话内存地址
            System.out.println("session=========" + sqlSession);
            /**
             * 获取映射接口的对象
             * sqlSession.getMapper(IStudentMapper.class):是指通过工厂会话对象，会话现在就把通向数据库的路径连接通了。
             */
            StudentService studentServiceMapper = sqlSession.getMapper(StudentService.class);
            /**
             * 向数据库中添加数据————封装学生数据
             */
            StudentBean addStudentData = new StudentBean(null, "2", "qq", "qq", "qq", "男", "qqq");
            //调用数据库操作
            int flag = studentServiceMapper.addStudentServiceInfo(addStudentData);
            if (flag > 0) {
                sqlSession.commit();
                System.out.println("添加成功！");
            } else {
                System.out.println("添加失败！");
            }
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
