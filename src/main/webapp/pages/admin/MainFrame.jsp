<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<base href="<%=basePath%>">
    <title>xx主界面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
	<script src="<%=basePath%>/resources/easyui/jquery.min.js"></script>
    <script src="<%=basePath%>/resources/easyui/jquery.cookie.js"></script>
    <script src="<%=basePath%>/resources/easyui/jquery.easyui.min.js"></script>
    <script src="<%=basePath%>/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link id ="easyuiTheme" href="<%=basePath%>/resources/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>/resources/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
	<script src="<%=basePath%>/resources/js/main.js"></script>
   	<link href="<%=basePath%>/resources/css/main.css" rel="stylesheet" type="text/css">
   
   	
<body class="easyui-layout" id="easyui-layout">
    <!--页面使用easyui布局-->
        <div data-options="region:'north',split:true,noheader:true" style="overflow: hidden;height:100px;">
        	<table id="head-nav">
        		<tr>
        			<td rowspan="3"><h2>xxx博客传媒有限公司</h2></td>
        			<td colspan="2">1</td>
        		</tr>
        		<tr>
        			
        			<td id="current-time"></td>
        			<td><c:if test="${user == null}">请先<a herf="">登录</a></c:if>
        				<c:if test="${user != null}">欢迎『${user }』<a id="loginOut" href="<%=basePath%>/admin/loginOut.do">注销</a></c:if>
        			</td>
        		</tr>
        		<tr>
        			<td id="current-time"><div id="currentTime"></td>
        			<td  id="menu-skip"><a id="nav-btn" href="#" class="easyui-menubutton" menu="#mm1" iconCls="icon-edit" >系统管理</a></td>
        		</tr>
        	</table>
        
        
    	</div>
		    <div id="mm1" style="width:90px;">
		    	<div>个人信息</div>
		    	<div>
		    	<span>更换皮肤</span>
			    	<div style="width:84px;">
			    		<div onclick="javascript:changeTheme('default')">默认</div>  
			            <div onclick="javascript:changeTheme('black')">经典黑</div>  
			            <div onclick="javascript:changeTheme('bootstrap')">bootstrap</div>  
			            <div onclick="javascript:changeTheme('gray')">经典灰</div>  
			            <div onclick="javascript:changeTheme('metro')">都市</div>
			            <div onclick="javascript:changeTheme('metro-blue')">都市-蓝</div>  
			            <div onclick="javascript:changeTheme('metro-gray')">都市-灰</div>  
			            <div onclick="javascript:changeTheme('metro-green')">都市-绿</div>  
			            <div onclick="javascript:changeTheme('metro-orange')">都市-橙</div>  
			            <div onclick="javascript:changeTheme('metro-red')">都市-红</div>
			            <div onclick="javascript:changeTheme('ui-cupertino')">苹果</div>  
			            <div onclick="javascript:changeTheme('ui-dark-hive')">系统-深暗</div>  
			            <div onclick="javascript:changeTheme('ui-pepper-grinder')">系统-纸浅</div>  
			            <div onclick="javascript:changeTheme('ui-sunny')">明亮</div>
			    	</div>
		        </div>
		    </div>
        </div>
        <div data-options="region:'south',split:true,noheader:true" style="overflow: hidden;height:40px;">2</div>
        <div data-options="region:'west',iconCls:'icon-man',title:'导航菜单栏',split:true" style="overflow: hidden;width:120px;">
        	<ul id="tt" class="easyui-tree"></ul>
        </div>
         <div data-options="region:'center',noheader:true,title:'控制台'" style="background:#eee;">
         	<div id="tabs">
				
			</div>
         </div>
    
</body>