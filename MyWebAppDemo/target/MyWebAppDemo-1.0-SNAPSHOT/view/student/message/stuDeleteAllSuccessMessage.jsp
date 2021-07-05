<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <style>
        div {
            width: 420px;
            height: 110px;
            line-height: 50px;
            border-radius: 5px;
            background-color: #81cfea;
            margin: 30px auto 0;
            color: #d96161;
            text-align: center;
            font-size: 18px;
        }
    </style>
    <script type="text/javascript">
        function countDown(secs, surl) {
            var jumpTo = document.getElementById('jumpTo');
            jumpTo.innerHTML = secs;
            if (--secs > 0) {
                setTimeout("countDown(" + secs + ",'" + surl + "')", 1000);
            } else {
                location.href = surl;

            }
        }
    </script>
</head>
<body>
<div>
    <a href="view/student/showAllStuInfo.jsp" style="text-decoration:none;">
        <span style="color:#ff0000; font-size:22px">${stuDeleteAllSuccessMessage}</span><br/>
        <span id="jumpTo" style="color:#d96161; font-size:35px">5</span>
        <span style="font-size:18px">秒后系统会自动跳转...</span>
        <span style="color:#d96161;text-decoration:underline;font-size: 18px;font-weight: bold">手动点击</span>
        <span style="font-size:18px">本处直接返回！</span>
    </a>
    <script type="text/javascript">
        countDown(5, 'view/student/showAllStuInfo.jsp');
    </script>
</div>
</body>
</html>