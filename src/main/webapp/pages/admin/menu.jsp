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
    <title>菜单管理</title>
    <meta charset="UTF-8"> <!-- for HTML5 -->
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
    <script src="<%=basePath%>/resources/easyui/jquery.min.js"></script>
    <script src="<%=basePath%>/resources/easyui/jquery.cookie.js"></script>
    <script src="<%=basePath%>/resources/easyui/jquery.easyui.min.js"></script>
    <script src="<%=basePath%>/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
    <link id ="easyuiTheme" href="<%=basePath%>/resources/easyui/themes/default/easyui.css" rel="stylesheet" type="text/css" />
    <link href="<%=basePath%>/resources/easyui/themes/icon.css" rel="stylesheet" type="text/css" />
    <script src="<%=basePath%>/resources/js/menu.js"></script>
	<link href="<%=basePath%>/resources/css/menu.css" rel="stylesheet" type="text/css">
<body class="easyui-layout">
    <div data-options="region:'west',title:'West',split:true,noheader:true" style="width:150px;">
    	<ul id="tt2" class="easyui-tree"></ul>
    	<div id="leaf" class="easyui-menu" style="width: 120px;">  
  			 <div onclick="removeNode()" iconcls="icon-remove">删除节点</div>  
        	<div onclick="updateNode()" iconcls="icon-edit">修改节点</div>  
		</div>  
		<div id="parentNode" class="easyui-menu" style="width: 120px;">  
    		<div id="addRootNode" onclick="addRootNode()" iconcls="icon-add">添加根节点</div>  
        	<div onclick="addChildNode()" iconcls="icon-edit">添加子节点</div>  
		</div>  
    </div>
    <div data-options="region:'center',title:'center title',noheader:true" style="padding:5px;background:#eee;">
    	<table id="nav-tab">
			<tr>
				<td>名称</td>
				<td><input type="text" class="input" name="mName"></td>
			</tr>
			<tr>
				<td>类型</td>
				<td class="radio">
					<input type="radio" name="type" id="hM" value="hm">&nbsp;画面&nbsp;
					<input type="radio" name="type" id="cD" value="cd">&nbsp;菜单&nbsp;
					<input type="radio" name="type" id="api" value="api">&nbsp;api&nbsp;
					<input type="radio" name="type" id="other" value="other">&nbsp;其他&nbsp;
				</td>
			</tr>
			<tr>
				<td>地址</td>
				<td><input type="text" class="input" name="url"></td>
			</tr>
			<tr>
				<td>图标</td>
				<td><input type="text" class="input" name="icon" id="icon"></td>
			</tr>
			<tr>
				<td>备注</td>
				<td><input type="text" class="input" name="demo"></td>
			</tr>
			<tr>
				<td></td>
				<td><a href="javascript:void(0);"  class="easyui-linkbutton"  iconCls="icon-save" id="icno_save">保存</a>
					<a href="javascript:void(0);" class="easyui-linkbutton"  iconCls="icon-save" id="icno_iconCls">图标</a>
				</td>
			</tr>
		</table>
		<div id="win" class="easyui-window" title="图标" style="width:400px;height:300px"
    		data-options="modal:true,closed:true,minimizable:false,maximizable:false,collapsible:false">
		    <div class="easyui-layout" data-options="fit:true">
				<div data-options="region:'south',split:true" style="height:50px"></div>
				<div data-options="region:'center',split:true" style="height:100px">
					<c:forEach items="${icons}" var="entry">
						<c:forEach items="${entry }" var ="map">
							<input type="image" src="${map.value}" value="${map.key }" onclick="icon('${map.key }')">
						</c:forEach>
					</c:forEach>
				</div>
    		</div>
		</div>
    </div>
</body>