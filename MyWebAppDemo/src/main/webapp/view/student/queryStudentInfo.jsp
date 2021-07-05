<%--
  Created by IntelliJ IDEA.
  User: ZSAndroid
  Date: 2021/6/29
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
<body>
<head>
    <title>查询学生信息</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            border: none;
        }

        body {
            background-image: url("../../images/trees.png");
        }

        .divcenter {
            height: 230px;
            font-family: "微软雅黑";
            width: 350px;
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
            margin-top: 13px;
        }

        input {
            width: 300px;
            height: 40px;
            margin-bottom: 6px;
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
    <p>查询学生信息</p>
    <%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
    <form action="${pageContext.request.contextPath }/QueryStudentControllerDo" method="post">
        <input type="number" oninput="if(value.length>4)value=value.slice(0,4)"
               onKeypress="return (/[\d]/.test(String.fromCharCode(event.keyCode)))" class="student-input" id="stu_no"
               name="stu_no" placeholder="请输入4位数的学号"/><br/>
        <input type="submit" value="查询">
        <input type="button" onclick="window.location.href = '../../index.jsp'"
               value="返回" style="background-color:#5A98DE;border: 1px solid #00A9EF;
               color: #FFFFFF;border-radius: 3px;padding-left: 2px;width:300px; height:40px;margin-bottom: 8px; margin-top: 5px;
            font-size: 16px;">
    </form>
</div>
</body>
</body>
</html>