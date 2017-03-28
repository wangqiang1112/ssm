<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/24
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
    <title>用户列表</title>
</head>
<body>
    ${name} 登陆成功！！！<br>
 <a href="/web01/user/userList.do">用户列表</a><br>
 <a href="/web01/file/toFilePage.do">文件处理</a><br>
 <a href="/web01/tags/toTags.do">TAGS页</a><br>
 <a href="/web01/json/toJsonPage.do">JSON页</a><br>
 <a href="/web01/interceptor/toInterceptor.do">自定义拦截器</a><br>
 <a href="/web01/tab/toTab.do">TAB页</a><br>
 <a href="/web01/erweima/toErweima.do">二维码</a><br>
</body>
</html>
