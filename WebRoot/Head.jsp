<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body style="position: relative;">
	<!-- 最顶端的菜单栏用于在各个jsp文件中使用 -->
	<div style="background-color: #45bff2;height:100%;width: 100%; ">
		<h2 style="float: right;">
			<a href="ResetPassword.jsp">重置密码</a>
			<a href="Exit" >退出登录</a>
		</h2>
		<h2 style="float: right; color: 0022FF">${userId},您好！</h2>
		<img alt="logo" src="logo.png" width="80px" height="80px"
			style="float: left;">
		<h1 style="float: left;padding-top: 25px">学生管理系统</h1>



	</div>
</body>
</html>
