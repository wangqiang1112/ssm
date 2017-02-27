<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>Tags page</title>
  </head>
  
  <body>
  
    <s:action name="tag_action" executeResult="true" namespace="/tags"> 
    	<s:param name="action_param" value="'传递的值'"></s:param> 
    </s:action>
    ${request.param}
    <br>
    <s:set var="personName" name="personName" value="888888"/>
	Hello, <s:property value="#personName"/> 
	
	<br>
    <s:set var="nameList" name="nameList" value="{'zhangsan','lisi','wangwu'}"/>
	Hello, 
	<s:iterator id="name" value="#nameList" status="sta">
		<s:property value="name"/>
	</s:iterator>
    
  </body>
</html>
