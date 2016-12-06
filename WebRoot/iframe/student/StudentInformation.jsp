<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h1 align="center">个人信息</h1><hr/>
	<div style="padding-top: 10%;">
	  	<table  style="font-size: 40px;text-align: left;;" align="center">
	  		<tr>
	  			<td width="15%">学生Id：${student.studentNum}</td>
	  		</tr>
	  		<tr>
	  			<td>学生姓名:${student.studentName}</td>
	  		</tr>
	  		<tr>
	  			<td>登录密码:${student.password}</td>
	  		</tr>
	  	</table>
	  </div>
  </body>
</html>
