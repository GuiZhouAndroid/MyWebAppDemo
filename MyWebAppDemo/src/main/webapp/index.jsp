<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>主页</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            border: none;
        }

        body {
            background-image: url("images/trees.png");
        }

        .divcenter {
            width: 360px;
            overflow: hidden;
            line-height: 100px;
            border-radius: 5px;
            background-color: #8CD3EC;
            margin: 25px auto 0;
            color: white;
            text-align: center;
            padding: 15px;
        }

        a {
            height: 20px;
            display: inline-block;
            padding: 6px;
            background-color: #00B4F9;
            text-decoration: none;
            color: white;
            border-radius: 3px;
            line-height: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="divcenter">
    <h1>欢迎来到学费管理系统</h1>
    <a href="view/student/addStudentInfo.jsp">添加用户</a>
    <a href="view/student/queryStudentInfo.jsp">查询单个用户</a>
    <a href="${pageContext.request.contextPath }/QueryAllStudentController">查询全部用户</a>
</div>
</body>
</html>