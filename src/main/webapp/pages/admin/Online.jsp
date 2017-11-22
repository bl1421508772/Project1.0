<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
<head>
	<base href="<%=basePath%>">
    <title>在线用户管理</title>
    <meta charset="UTF-8"> <!-- for HTML5 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
    <script src="<%=basePath%>/resources/easyui/jquery.min.js"></script>
    <script src="<%=basePath%>/resources/easyui/jquery.cookie.js"></script>
    <script src="<%=basePath%>/resources/easyui/jquery.easyui.min.js"></script>
    <script src="<%=basePath%>/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link id ="easyuiTheme" href="<%=basePath%>/resources/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>/resources/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>/resources/js/online.js"></script>
    <link href="<%=basePath%>/resources/css/online.css" rel="stylesheet" type="text/css">

<body>
   <table class="easyui-datagrid" style="width:800px;height:250px"
    data-options="url:'<%=basePath%>admin/datagrid.do',fitColumns:true,singleSelect:true">
    <thead>
		<tr>
			<th data-options="field:'code',width:100">在线用户</th>
			<th data-options="field:'name',width:100">状态</th>
			<th data-options="field:'price'">操作管理</th>
		</tr>
    </thead>
</table>
</body>