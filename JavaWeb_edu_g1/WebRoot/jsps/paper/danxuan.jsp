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
    
    <title>My JSP 'danxuan.jsp' starting page</title>
    
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
    <table border="1" width="70%" align="center">
    <tr>
        <th>题目</th>
        <th>A</th>
        <th>B</th>
        <th>C</th>
        <th>D</th>
        <th>备注</th>
        
    </tr>
<%--
要遍历提UserList这个集合
 --%>
<c:forEach items="${PaperList}" var="paper">
    <tr>
        <td>${paper.q_subject }</td>
        <td>${paper.optionA }</td>
        <td>${paper.optionB }</td>
        <td>${paper.optionC }</td>
        <td>${paper.optionD }</td>
        <td>${paper.note }</td>
          </td>
    </tr>
</c:forEach>
</table>
  </body>
</html>