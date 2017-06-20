<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'tankuang.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<script type="text/javascript" src="resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">
    	$(document).ready(function(){
    		$(".send-msg").show();
    		$("#cover").hide();
    		/* $("#cover").click(function(){
    			$(".send-msg").hide();
    			$(this).hide();
    		}); */
    	});
    	
    	function send(){
    		$("#send-msg").show();
    		$("#cover").show();
    		$("#infoMsg").show();
    		setTimeout(hiddenInfo,3000);
    	}
    	
    	function hiddenInfo(){
    		$("#cover").hide();
    		$("#infoMsg").hide();
    	}
    	
    </script>
    
    
	<style type="text/css">
		.send-msg{
			background-color: pink;
			display:block;
			width:50%;
			height:40%;
			/*定位屏幕中间*/
			position:fixed;
			top:25%;
			left:30%;
			border:solid 1px #0EA9BF;
		}
		.send-msg caption{
			padding-top:10px;
			padding-bottom:10px;
			background:#0EA9BF;
			font-size:16px;
			color:#fff;
		}
		#cover{
			position:fixed;
			z-index:1;
			top:0px;
			left:0px;
			display:none;
			width:100%;
			height:100%;
			opacity:0.5;
			background: #000 none repeat scroll 0% 0%;
		}
		#infoMsg{
			padding-top:1%;
			position:fixed;
			z-index:2;
			top:30%;
			left:40%;
			width:20%;
			height:10%;
			opacity:0.5;
			text-align:center;
			background: #CCFF66  none repeat scroll 0% 0%;
		}
		#textId{
			margin-top:30%;
		}
	</style>

  </head>
  
  <body>
    <div id="send-msg" class="send-msg">
    	<table width="100%" border="0">
    		<caption>发送消息</caption>
    		<tr>
    			<td align="right" width="100" height="30">收件人</td>
    			<td><input type="text" name="msg_person" size="30"/></td>
    		</tr>
    		<tr>
    			<td align="right" heigh="30">消息主题</td>
    			<td><input type="text" name="msg_title" size="30"/></td>
    		</tr>
    		<tr>
    			<td align="right">消息内容</td>
    			<td><textarea name="msg_content" cols="30" rows="3"></textarea></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center">
    				<button onclick="send();" class="msgbtn">发送</button>&nbsp;&nbsp;
    				<button onclick="reset();" class="msgbtn">发送</button>
    			</td>
    		</tr>
    	</table>
    </div>
    
    <div style="display:block;" id="cover"></div>
    <div style="display:none;" id="infoMsg"><span id="textId">消息发送中，请稍后.....</span></div>
  </body>
</html>
