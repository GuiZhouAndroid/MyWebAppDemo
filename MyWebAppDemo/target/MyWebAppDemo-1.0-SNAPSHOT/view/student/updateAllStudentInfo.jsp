<%--
  Created by IntelliJ IDEA.
  User: ZSAndroid
  Date: 2021/6/30
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<head>
    <title>修改学生信息页面</title>
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
            height: 540px;
            font-family: "微软雅黑";
            width: 390px;
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
            margin-top: 5px;
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
            margin-top: 10px;
            text-align: center;
        }

        .student-input {
            border: 1px solid #00A9EF;
            border-radius: 3px;
            padding-left: 4px;
        }
    </style>
</head>
<body>

<div class="divcenter">
    <p>修改学生信息</p>
    <%--  使用<form>标签创建表单，在表单中使用<table>标签进行页面布局，使用<input>标签搜集用户输入的数据  --%>
    <form id="studentAction_save_do" name="Form1"
          action="${pageContext.request.contextPath}/updateAllStudentController" method="post"><br/>
        <label  style="text-align: left;font-size: 19px; margin-right:18px">ID：</label><input
                value="${pageContext.request.getParameter("stuAllUpdateId")}" class="student-input" id="stuUpdate_id" type="number"
                name="stuAllInputId" readonly/><br/>
        <label style="text-align: left;font-size: 19px;">学号：</label><input  type="number"
                value="${pageContext.request.getParameter("stuAllUpdateNo")}" class="student-input" id="stuUpdate_no"
                name="stuAllInputNo" oninput="if(value.length>4)value=value.slice(0,4)"
                onKeypress="return (/[\d]/.test(String.fromCharCode(event.keyCode)))"/><br/>
        <label type="text" onkeyup="value=value.replace(/[^\u4e00-\u9fa5]/g,'')" maxlength="4" style="text-align: left;font-size: 19px;">姓名：</label><input
                value="${pageContext.request.getParameter("stuAllUpdateName")}" class="student-input" id="stu_name"
                name="stuAllInputName"/><br/>
        <label style="text-align: left;font-size: 19px;">班级：</label><input
                value="${pageContext.request.getParameter("stuAllUpdateClass")}" class="student-input" id="stu_class"
                name="stuAllInputClass"/><br/>
        <label type="number" maxlength="3" style="text-align: left;font-size: 19px;">年龄：</label><input
                value="${pageContext.request.getParameter("stuAllUpdateAge")}" class="student-input" id="stu_age"
                name="stuAllInputAge"/><br/>
        <label type="text" onkeyup="value=value.replace(/[^\u4e00-\u9fa5]/g,'')" maxlength="1" style="text-align: left;font-size: 19px;">性别：</label><input
                value="${pageContext.request.getParameter("stuAllUpdateSex")}" class="student-input" id="stu_sex"
                name="stuAllInputSex"/><br/>
        <label style="text-align: left;font-size: 19px;">生日：</label><input
                value="${pageContext.request.getParameter("stuAllUpdateBirthday")}" class="student-input" id="stu_birthday"
                name="stuAllInputBirthday"/><br/>
        <input type="submit" value="修改"><br/>
        <input type="button" onclick="window.location.href = '../student/showAllStuInfo.jsp'"
               value="返回" style="background-color:#5A98DE;border: 1px solid #00A9EF;
               color: #FFFFFF;border-radius: 3px;padding-left: 2px;">
    </form>
</div>
</body>
</body>
</html>
