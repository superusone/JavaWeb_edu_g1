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
    
    <title>My JSP 'list.jsp' starting page</title>
    
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
  <!-- 未处理分页 -->>
   <h3 align="center">列表</h3>
<table border="1" width="70%" align="center">
    <tr>
        <th>类型</th>
        <th>题目</th>
        <th>答案</th>
        <th></th>
        <th></th>
        <th></th>
        <th></th>
        <th>备注</th>
        
    </tr>
<%--
要遍历提UserList这个集合
 --%>
<c:forEach items="${PaperList}" var="paper">
    <tr>
        <td>${paper.type }</td>
        <td>${paper.q_subject }</td>
        <td>${paper.q_answer}</td>
        <td>${paper.optionA }</td>
        <td>${paper.optionB }</td>
        <td>${paper.optionC }</td>
        <td>${paper.optionD }</td>
        <td>${paper.note }</td>
        <td>
            <a href="<c:url value='/PaperServlet?method=preEdit&pid=${paper.pid }'/>">编辑</a>
            <a href="<c:url value='/PaperServlet?method=delete&pid=${paper.pid }'/>">删除</a>
        </td>
    </tr>
</c:forEach>
</table>
<br/>
  </body>
</html>
