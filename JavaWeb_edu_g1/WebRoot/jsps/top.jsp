<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {
<!--		background: #4682B4; -->
		
		
	}
	a {
		text-transform:none;
		text-decoration:none;
	} 
	a:hover {
		text-decoration:underline;
	}
</style>
  </head>
  
  <body background="../top_img/123.jpg">


<h1 style="text-align: center;font-family:'楷体';font-weight:bold;">数信学院考试系统</h1>
<div style="font-size: 10pt;">
	<c:choose>
		<c:when test="${empty sessionScope.session_user }">
			<a href="<c:url value='/jsps/user/login.jsp'/>" target="_parent">登 录</a> |&nbsp; 
			<a href="<c:url value='/jsps/user/regist.jsp'/>" target="_parent">注 册 </a>		
		</c:when>
		<c:when test="${2 eq sessionScope.session_user.mark }">
			您好：${sessionScope.session_user.name }&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="<c:url value='/jsps/paper/list.jsp'/>" target="body">考 试</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="<c:url value='/SPServlet?method=ShowGrade&id=${sessionScope.session_user.id }'/>" target="body">查看成绩</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">退 出</a>		
		</c:when>
		<c:when test="${1 eq sessionScope.session_user.mark }">
			您好：${sessionScope.session_user.name }&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="<c:url value='/jsps/cart/list.jsp'/>" target="body">批 阅</a>&nbsp;&nbsp;|&nbsp;&nbsp;
			<a href="<c:url value='/UserServlet?method=quit'/>" target="_parent">退 出</a>				
		</c:when>

	</c:choose>

</div>
  </body>
</html>
