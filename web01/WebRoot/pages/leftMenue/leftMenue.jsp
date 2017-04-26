<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String path1 = request.getContextPath()+"/pages/leftMenue/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<frameset cols="200,*">
  <frame src="<%=path1 %>menue.jsp">
  <frame src="<%=path1 %>pref.jsp" name="view_frame">
  
</frameset> 
</html>
