<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>试卷列表</title>
    
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
		font-size: 10pt;
	}
	.icon {
		margin:10px;
		border: solid 2px gray;
		width: 160px;
		height: 180px;
		text-align: center;
		float: left;
	}
</style>
  </head>
  
  <body>

  <div class="icon">
    <a href="<c:url value='/ShowPaperServlet?method=ShowPaper&papertype=A'/>"><img src="<c:url value='/book_img/A1.jpg'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/ShowPaperServlet?method=ShowPaper&papertype=A'/>">A</a>
  </div>
  <div class="icon">
    <a href="<c:url value='/ShowPaperServlet?method=ShowPaper&papertype=B'/>"><img src="<c:url value='/book_img/B1.jpg'/>" border="0"/></a>
      <br/>
   	<a href="<c:url value='/ShowPaperServlet?method=ShowPaper&papertype=B'/>">B</a>
  </div>



  
  </body>
 
</html>

