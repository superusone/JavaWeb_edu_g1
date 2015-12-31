<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>答卷</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  <body>
  <form id="form" action="<c:url value='/SearchPaperServlet?method=JudgeAnswer'/>" method="post">
  <ul>
     <h3 align="center">列表</h3>
<table border="1" width="70%" align="center">
    <tr>
        <th>题目</th>
        <th>A</th>
        <th>B</th>
        <th>C</th>
        <th>D</th>    
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
        <td>
            <a href="<c:url value='/AdminUserServlet?method=preEdit&note=A'/>"></a>
            
        </td>
    </tr>
</c:forEach>
</table>
<br/>
    

  <a href="javascript:document.getElementById('form').submit();">提交</a>
  </body>
</html>
