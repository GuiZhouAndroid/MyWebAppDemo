<%--
  Created by IntelliJ IDEA.
  User: ZSAndroid
  Date: 2021/6/29
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%--%>
<%--    String path = request.getContextPath();--%>
<%--    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()--%>
<%--            + path + "/";--%>
<%--%>--%>
<html>
<body>
<head>
    <title>增加学生信息页面</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            border: none;
        }

        a {
            width: 300px;
            height: 40px;
            background-color: #5A98DE;

            color: white;
            border-radius: 3px;
            line-height: 40px;
            margin-top: -15px;
            text-align: center;
        }

        body {
            background-image: url("../../images/trees.png");
        }

        .divcenter {
            height: 450px;
            font-family: "微软雅黑";
            width: 330px;
            text-align: center;
            border: 1px solid #00a9ef;
            background-color: white;
            margin: 55px auto 0;
            border-radius: 6px;
        }

        .divcenter > p {
            height: 50px;
            font-size: 19px;
            border-bottom: 1px solid #00a9ef;
            background-color: #e5f6fd;
            line-height: 50px;
            text-align: center;
            border-radius: 6px 6px 0 0;
        }

        form {
            margin-top: 15px;
        }

        form > span {
            text-align: left;
        }

        input {
            width: 300px;
            height: 40px;
            margin-bottom: 8px;
            font-size: 16px;
        }

        input[type="submit"] {
            background-color: #5A98DE;
            text-decoration: none;
            color: white;
            border-radius: 3px;
            line-height: 40px;
            margin-top: 15px;
            text-align: center;
        }

        .student-input {
            border: 1px solid #00A9EF;
            border-radius: 3px;
            padding-left: 2px;
        }
    </style>
</head>
<body>
<div class="divcenter">
    <p>增加学生信息</p>
    <%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
    <form id="studentAction_save_do" name="Form1" action="${pageContext.request.contextPath }/AddStudentController"
          method="post">
        <input type="number" oninput="if(value.length>4)value=value.slice(0,4)"
               onKeypress="return (/[\d]/.test(String.fromCharCode(event.keyCode)))" class="student-input" id="stu_no"
               name="stu_no" placeholder="请输入不超过4位数的学号"/><br/>
        <input type="text" onkeyup="value=value.replace(/[^\u4e00-\u9fa5]/g,'')" maxlength="4" class="student-input"
               id="stu_name" name="stu_name" placeholder="请输入不超过4个字的姓名"/><br/>
        <input class="student-input" id="stu_class" name="stu_class" placeholder="请输入班级"/><br/>
        <input type="number"  maxlength="3" class="student-input" id="stu_age" name="stu_age" placeholder="请输入年龄"/><br/>
        <input type="text" οnkeyup="value=value.replace(/[^\u4E00-\u9FA5]/g,'')" maxlength="1"
               class="student-input" id="stu_sex" name="stu_sex" placeholder="请输入性别"/><br/>
        <input class="student-input" id="stu_birthday" name="stu_birthday" placeholder="请输入生日"/><br/>
        <input type="submit" value="增加" style="margin-top: 0px;"><br/>
        <input type="button" onclick="window.location.href = '../../index.jsp'"
               value="返回" style="background-color:#5A98DE;border: 1px solid #00A9EF;
               color: #FFFFFF;border-radius: 3px;padding-left: 2px;">
        <br/>
        <p style="color: #358cff;font-size: 20px">温馨提示:<span style="color:#f80a4b;font-size: 20px">请填写所有添加信息</span>
    </form>
</div>
</body>
</body>
</html>
