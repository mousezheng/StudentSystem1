<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" href="../../bootstrap3.2.2/css/bootstrap.min.css">
  </head>
  
  <body style="background-color: #BBBBBB">
  	<h1 align="center">个人信息</h1><hr/>
	<div style="padding-top: 10%;">
	  	<table class="table table-hover table-striped" style="width:70%;font-size: 40px;text-align: left;;" align="center" >
	  		<tr>
	  			<td width="20%">学生Id：</td>
	  			<td width="20%">${student.studentNum}</td>
	  		</tr>
	  		<tr>
	  			<td>学生姓名:</td>
	  			<td >${student.studentName}</td>
	  		</tr>
	  		<tr>
	  			<td>登录密码:</td>
	  			<td >${student.password}</td>
	  		</tr>
	  	</table>
	  </div>
  </body>
</html>
