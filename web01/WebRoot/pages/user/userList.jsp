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
                    <td><a href="#">操作</a></td>
                    <%-- <td>
                        <s:if test="#inc.processState==0">
                          <a class="tbl-td-a" href="early-warning/dispose-incident/toHandle.do?toHandleState=2&incidentId=${incidentId}&processType=2" title="安全事件详情" target="dialog" drawable="false" maxable="false"
                             minable="false" width="650" height="500" mask="true">详情</a>
                            <a class="tbl-td-a" href="javascript:void(0);" onclick="editeLevel(this,'${unitId}','${incidentId}');">调整级别</a>
                            <a class="tbl-td-a" href="early-warning/dispose-incident/handle.do?incidentId=${incidentId}&unitId=${unitId}&classification=${classification}&processState=1&processType=5" target="ajaxTodo" mask="true" title="确定下发该事件吗？">下发</a>
                            <a class="tbl-td-a" href="early-warning/dispose-incident/handle.do?incidentId=${incidentId}&unitId=${unitId}&classification=${classification}&processState=10&processType=5" target="ajaxTodo" mask="true" title="确定忽略该事件吗？">忽略</a>
                        </s:if>
                        
                    </td> --%>
                </tr>
            </s:iterator>
            </tbody>
    </table>
</body>
</html>
