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
	<script type="text/javascript" src="resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="resources/picYulan/uploadPreview.js"></script>
	
	<style type="text/css">
		div {display:inline-block;margin-right:10px;border:2px solid #2196F3}
		button {margin : 0 auto;width:100%;color:#4408F5;background:#94BCDC;font:menu;font-size:small;}
	</style>
    <script>
		var count = 0;
		var ts;
		var up_id;
		var div_id;
		var img_id;
		var flag = false;//添加按钮，如果当前src和photo_icon.png相等，则上传后新增一个按钮，否则不新增
		function add(t){
			//获取所需的id值
			ts = $(t);
			up_id = ts.next().attr("id");
			div_id = ts.parent("div").attr("id");
			img_id = ts.attr("id");
			if($("#"+img_id).attr("src") == "photo_icon.png"){
				flag = true;
			}else{
				flag = false;
			}
			//alert(up_id + " " + div_id + " " + img_id);
			//点击上传预览
			$("#"+up_id).click();
			new uploadPreview({ UpBtn: up_id, DivShow: div_id, ImgShow: img_id,callback: afterFun});
			
		}
		
		 var afterFun = function(){
			//alert(flag);
			if(flag){
				count++;
				var addDiv = "<div id='imgdiv"+count+"'><img id='imgShow"+count+"' src='photo_icon.png' width='100' height='100' onClick='add(this);'/><input type='file' id='up_img"+count+"' style='display: none;'/></div>";
				$("div:last").after(addDiv);
				var btn = "<button id='btn"+count+"' style='display: block;' onClick='del(this);'>删除</button>";
				$("#"+up_id).after(btn);
			}
			
			//var arr = $.find("img[src='photo_icon.png']");
			//for(var i = 0;i < arr.length;i++){
			//	var curImg = arr[i];
			//	var id = curImg.attr("id");
			//	alert(id);
			//}
			
		}
		
		function del(t){
			var ts = $(t);
			var btn_id = ts.parent("div").attr("id");
			$("#"+btn_id).remove();
		}
		
    </script>
  </head>
  
  <body>
  	<div id="imgdiv">
		<img id="imgShow" src="photo_icon.png" width="100" height="100"  onClick="add(this);"/>
		<input type="file" id="up_img" style="display: none;"/>
	</div>
    
  </body>
</html>
