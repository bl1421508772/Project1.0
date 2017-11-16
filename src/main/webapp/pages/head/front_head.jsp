<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div id="bot">
        <c:forEach items="${nav1 }" var="nav">
    		<a href="<%=basePath%>${nav.url }"><div>${nav.nav_name }</div></a>
        </c:forEach> 
</div> 
