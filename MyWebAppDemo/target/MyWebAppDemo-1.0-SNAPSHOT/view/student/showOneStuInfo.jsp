<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <title>学生信息</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            border: none;
        }

        body {
            background-image: url("../../images/trees.png");
        }

        div {
            margin: auto;
            text-align: center;
            padding: 6px;
            /*background-color: #8CD3EC;*/
        }

        table {
            margin: 10px auto;
            width: 80%;
            border-collapse: collapse;
            text-align: center;
        }

        th, td {

            border: 1px solid #ebeef5;
            padding: 7px;
        }

        th {

            font-size: 17px;
            background-color: #F2F2F2;
            color: #131;
        }

        td {
            font-size: 15px;
            background-color: white;
        }

        th:first-child {
            border-radius: 5px 0 0 0;
        }

        th:last-child {
            border-radius: 0 5px 0 0;
        }

        tr:last-child td:first-child {
            border-radius: 0 0 0 5px;
        }

        tr:last-child td:last-child {
            border-radius: 0 0 5px 0;
        }

        .manager a {
            text-decoration: none;
            padding: 4px;
            font-size: 15px;
            display: inline-block;
            background-color: #64D1F7;
            border-radius: 2px;
            color: white;
            width: 50px;
            height: auto;
        }

        .manager a:last-child {
            background-color: #64D1F7;
        }

        a:hover {
            box-shadow: 1px 1px 1px #64D1F7;
        }
    </style>
</head>
<body>
<div>
    <h1>学生信息</h1>
    <table>
        <tr>
            <th>学生ID</th>
            <th>学号</th>
            <th>姓名</th>
            <th>班级</th>
            <th>年龄</th>
            <th>性别</th>
            <th>生日</th>
            <th>操作</th>
        </tr>
        <tr>
            <td>${student_db.stu_id}</td>
            <td>${student_db.stu_no}</td>
            <td>${student_db.stu_name}</td>
            <td>${student_db.stu_class}</td>
            <td>${student_db.stu_age}</td>
            <td>${student_db.stu_sex}</td>
            <td>${student_db.stu_birthday}</td>
            <td class="manager">
                <a href="../../DeleteStudentController?stuDeleteId=${student_db.stu_id}">删除</a>
                <a href="updateStudentInfo.jsp?stuUpdateId=${student_db.stu_id}&stuUpdateNo=${student_db.stu_no}&stuUpdateName=${student_db.stu_name}&stuUpdateClass=${student_db.stu_class}&stuUpdateAge=${student_db.stu_age}&stuUpdateSex=${student_db.stu_sex}&stuUpdateBirthday=${student_db.stu_birthday}">修改</a>
            </td>
        </tr>
    </table>
    <input type="button" onclick="window.location.href = '../../index.jsp'"
           value="返回主页" style="background-color:#5A98DE;border: 1px solid #00A9EF;
               color: #FFFFFF;border-radius: 3px;padding-left: 2px;width:300px; height:40px;margin-bottom: 8px;
            font-size: 16px;">
</div>
</body>
</html>
