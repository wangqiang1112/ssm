<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/1/24
  Time: 12:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<%@ taglib prefix="frm" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>用户列表</title>
    <link rel="stylesheet" href="../resources/ztree/demo.css" type="text/css">
    <link rel="stylesheet" href="../resources/ztree/zTreeStyle/zTreeStyle.css" type="text/css">
    <script type="text/javascript" src="../resources/ztree/jquery-1.4.4.min.js"></script>
    <script type="text/javascript" src="../resources/ztree/jquery.ztree.core.js"></script>
    <script type="text/javascript" src="../resources/js/user/user.js"></script>
    
    <style type="text/css">
    	table
		  {
		  border-collapse:collapse;
		  width:50%;
		  }
		
		table, td, th
		  {
		  border:1px solid black;
		  }
		td {text-align: center;}
		
		table head{backgroud:blue;}
    </style>
</head>
<body>
    <table>
    	<thead>
	    	<tr>
	    		<th>用户ID</th>
	    		<th>用户名</th>
	    		<th>年龄</th>
	    		<th>操作</th>
	    	</tr>
    	</thead>
    	<tbody>
            <s:iterator value="#request.userList" id="inc" status="sta">
                <tr>
                    <td>${id}</td>
                    <td>${name}</td>
                    <td>${age}</td>
                    <td>
                        <div class="">
                            <input id="citySel${id}" type="text" readonly value="" style="width:120px;" onclick="showMenu('${id}');"/>
                            <%--&nbsp;<a id="menuBtn" href="#" onclick="showMenu(); return false;">选择</a>--%>
                        </div>
                    </td>

                </tr>
            </s:iterator>
            </tbody>
    </table>
    <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
        <ul id="treeDemo" class="ztree" style="margin-top:0; width:160px;"></ul>
    </div>
</body>
</html>
