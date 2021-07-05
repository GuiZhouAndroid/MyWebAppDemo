<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        body {
            background-image: url("images/trees.png");
        }

        div {
            width: 360px;
            height: 100px;
            line-height: 100px;
            border-radius: 5px;
            background-color: #81cfea;
            margin: 25px auto 0;
            color: #d96161;
            text-align: center;
            font-size: 17px;
        }
    </style>
</head>
<body>
<div>${message}<br/>3秒后自动跳转查询页面...</div>
<%
    response.setHeader("refresh", "3;url=view/student/queryStudentInfo.jsp");
%>
</body>
</html>