<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en"/>
<head>
	<base href="<%=basePath%>">
    <title>xx登录页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
    <link href="<%=basePath%>/resources/css/login.css" rel="stylesheet" type="text/css">
     <script type="text/javascript" src="<%=basePath%>/resources/js/jquery-1.9.1.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/resources/js/login.js"></script>
<body>
    <div id="login-frame">
    	<div>
        <table id="login-info">
        	<tr>
        		<td class="cname" colspan="2"><center>武汉武钢众鹏erp管理平台</center></td>
        	</tr>
        	<tr><td colspan="2"><div id="tip"></div></td>
        	</tr>
            <tr>
                <td>用户名</td>
                <td class="info"><input type="text" name="username"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td class="info"><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>
                    <a href="javascript:void(0)"><input type="button" class="btn" value="登录" id="sign"></a>
                </td>
                <td>
                    <a href="javascript:void(0)"><input type="button" class="btn" value="重置" id="reset"></a>
                </td>
            </tr>
            <tr>
            	<td colspan="2">
            	  <div id="login-bottom"><a href="#">登录</a>|<a href="#">注册</a></div>
            	</td>
            </tr>
        </table>
              </div>
    </div>
</body>
</html>