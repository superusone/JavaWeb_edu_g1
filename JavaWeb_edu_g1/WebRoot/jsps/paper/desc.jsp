<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


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
	<script type="text/javascript" src="<c:url value='/menu/mymenu.js'/>"></script>
	<link rel="stylesheet" href="<c:url value='/menu/mymenu.css'/>" type="text/css" media="all">
	
	-->
<link rel="stylesheet" href="<c:url value='/menu/800.css'/>"
	type="text/css" media="all">
<link rel="stylesheet" href="<c:url value='/menu/question.css'/>"
	type="text/css" media="all">

<script type="text/javascript">
	/**
	 *在此可以校验必选项是否选择即表单数据校验
	 **/
	function check() {
		//校验

		//提交
		var url = '';
		for (var i = 1; i <= 6; i++) {
			var pid = 'pid' + i;
			url += '&' + pid + '=' + submit(pid);
		}

		var u = "<c:url value='/SearchPaperServlet?method=JudgeAnswer&id=${sessionScope.session_user.id }'/>" + url ;
		document.getElementById('form').action=u;
		document.getElementById('form').submit();
	}

	/**
	 *封装数据提交
	 **/
	function submit(n) {
		var str = '';

		if (n == 'pid4') {
			var muls = document.getElementsByName(n);
			for(var i = 0; i < muls.length; i++){
				if(muls[i].checked){
					str += muls[i].value + '@@';
				}
			}
		} else {

			var singles = document.getElementsByName(n);
			for (var i = 0; i < singles.length; i++) {
				if (singles[i].checked) {
					str += singles[i].value;

				}
			}
		}
		return str;
	}
</script>

</head>

<body id="wrapper" class="sticky">

	<div class="con-border">
	<form id="form" action="" method="post">
 
		<div class="content">
			<p>
			<h1>单选</h1>
			</p>
			<c:forEach items="${singleList}" var="paper" varStatus="vs">
				<div class="question" id="singleList">
					<div class="question-tit">
						<div class="question-titleft">
							<div class="text-q-num">Q ${vs.index + 1 }.</div>
							<div class="text-q-con">
								<p>${paper.q_subject }</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="question-choice oneColumns">
						<ul>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="radio" id="" name="pid${vs.index + 1 }"
											value="A@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">A.${paper.optionA }</em>&nbsp;
										</p>
									</div>
								</div></li>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="radio" id="" name="pid${vs.index + 1 }"
											value="B@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">B.${paper.optionB }</em>&nbsp;
										</p>
									</div>
								</div></li>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="radio" id="" name="pid${vs.index + 1 }"
											value="C@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">C.${paper.optionC }</em>&nbsp;
										</p>
									</div>
								</div></li>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="radio" id="" name="pid${vs.index + 1 }"
											value="D@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">D.${paper.optionD }</em>&nbsp;
										</p>
									</div>
								</div></li>

						</ul>
					</div>
				</div>
			</c:forEach>
			<p>
			<h1>多选</h1>
			</p>
			<c:forEach items="${multiselectList}" var="paper">
				<div class="question" id="">
					<div class="question-tit">
						<div class="question-titleft">
							<div class="text-q-num">Q1.</div>
							<div class="text-q-con">
								<p>${paper.q_subject }</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="question-choice oneColumns">
						<ul>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="checkbox" id="mul" name="pid4"
											value="A@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">A.${paper.optionA }</em>&nbsp;
										</p>
									</div>
								</div></li>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="checkbox" id="mul" name="pid4"
											value="B@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">B.${paper.optionB }</em>&nbsp;
										</p>
									</div>
								</div></li>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="checkbox" id="mul" name="pid4"
											value="C@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">C.${paper.optionC }</em>&nbsp;
										</p>
									</div>
								</div></li>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="checkbox" id="mul" name="pid4"
											value="D@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">D.${paper.optionD }</em>&nbsp;
										</p>
									</div>
								</div></li>

						</ul>
					</div>
				</div>
			</c:forEach>
			<p>
			<h1>判断</h1>
			</p>
			<c:forEach items="${judgeList}" var="paper" varStatus="vs">
				<div class="question" id="">
					<div class="question-tit">
						<div class="question-titleft">
							<div class="text-q-num">Q ${vs.index + 1 }.</div>
							<div class="text-q-con">
								<p>${paper.q_subject }</p>
							</div>
							<div class="clear"></div>
						</div>
					</div>
					<div class="question-choice oneColumns">
						<ul>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="radio" id="" name="pid${vs.index + 5 }"
											value="true@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">对</em>&nbsp;
										</p>
									</div>
								</div></li>
							<li class=""><div class="q-choice-piccheck">
									<div class="q_choice_in fl">
										<input type="radio" id="" name="pid${vs.index + 5 }"
											value="false@${paper.pid }">
									</div>
									<div class="q-choice-picchecktext fl">
										<p class="lineheight16">
											<em class="mr5">错</em>&nbsp;
										</p>
									</div>
								</div></li>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="next">
			<span class="submitbnt"><a href="javascript:check()"
				title="提交">提交</a></span>
		</div>
 </form>
 
	</div>
</body>
</html>
