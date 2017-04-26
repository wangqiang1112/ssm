<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String path1 = request.getContextPath()+"/pages/leftMenue/";
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'menue.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="resources/js/jquery-1.9.1.min.js"></script>
	<script type="text/javascript">
		function aclick(t){//此处可以结合ztree中的点击事件来实现
			var th = $(t);
			th.attr("href","/web01/pages/leftMenue/chap2.jsp");
		}
	</script>

  </head>

  <body>
    <h3>Table of Contents</h3>
<ul>
  <li><a href="" target="view_frame" onClick="aclick(this);">Preface</a></li>
  <li><a href="<%=path1 %>chap1.jsp" target="view_frame">Chapter 1</a></li>
  <li><a href="<%=path1 %>chap2.jsp" target="view_frame">Chapter 2</a></li>
  <li><a href="<%=path1 %>chap3.jsp" target="view_frame">Chapter 3</a></li>
</ul>

  </body>
</html>
