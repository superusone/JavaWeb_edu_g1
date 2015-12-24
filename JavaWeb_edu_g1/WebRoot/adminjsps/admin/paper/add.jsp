<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'add.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>添加</h1>
  <%--
  1. 显示errors --> 字段错误
  2. 显示异常错误
  3. 回显
   --%>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/PaperServlet?pid=${paper.pid }'/>" method="post">
    <input type="hidden" name="method" value="add"/>
    类　型：<input type="text" name="type" value="${paper.type }"/>
    <span style="color: red; font-weight: 900">${errors.type }</span>
    <br/>
    题　目：<input type="text" name="q_subject" value="${paper.q_subject }"/>
    <span style="color: red; font-weight: 900">${errors.q_subject }</span>
    <br/>
    答　案：<input type="text" name="q_answer" value="${paper.q_answer }"/>
    <br/>
    　A 　：<input type="text" name="optionA" value="${paper.optionA }"/>
    <br/>
    　B 　：<input type="text" name="optionB" value="${paper.optionB }"/>
    <br/>
    　C 　：<input type="text" name="optionC" value="${paper.optionC }"/>
    <br/>
    　D 　：<input type="text" name="optionD" value="${paper.optionD }"/>
    <br/>
    备　注：<input type="text" name="note" value="${paper.note }"/>
    <br/>
    <input type="submit" value="确定"/>
</form>
  </body>
</html>
