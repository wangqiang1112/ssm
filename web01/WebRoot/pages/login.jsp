<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/23
  Time: 11:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登陆</title>
    <script type="text/javascript" src="resources/js/jquery-1.9.1.min.js" ></script>
    <script type="text/javascript">
        $(function(){

        });
    </script>
</head>
<body>
    <form id="loginform" action="/web01/login/login.do" method="post">
        <input type="text" name="user.name" id="name" placeholder="请输入用户名"/>
        <input type="submit" name="btn_login" id="login" value="登录" />
    </form>
</body>
</html>
