<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'json.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   	<form action="/web01/fileUpload/doUpload.do" method="post" enctype="multipart/form-data">
   		<input name="file" type="file"/><br/>
   		<input type="submit" value="submit">
   	</form>
   	<a href="/web01/fileUpload/download.do?fileFileName=photo_icon.png">下载</a>
   	
   	<a href="/web01/fileUpload/download1.do?fileFileName=photo_icon.png">下载1</a>
   	
   	<br>
   	多文件上传(代码被注释)
   	<!-- <script type="text/javascript">
            
        $(function()
        {
            $("#button").click(function()
            {
                var html = $("<input type='file' name='file'>");
                var button = $("<input type='button' name='button' value='删除'><br>");
                
                $("#body div").append(html).append(button);
                
                button.click(function()
                {
                    html.remove();
                    button.remove();
                })
            })
        })
    
    </script>
  </head>
  
  <body id="body">

    <form action="fileUpload2.action" method="post" enctype="multipart/form-data">
    
        username: <input type="text" name="username"><br>
        file: <input type="file" name="file">
        <input type="button" value="添加" id="button"><br>
        <div></div>
        <input type="submit" value="submit"> 
        
    </form> -->
   	
  </body>
</html>
