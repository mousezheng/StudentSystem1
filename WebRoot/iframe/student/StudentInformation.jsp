<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h1 align="center">个人信息</h1><hr/>
  	<table style="font-size: 40px" border="1px">
  		<tr>
  			<td>学生Id：</td>
  			<td>${student.studentNum}</td>
  		</tr>
  		<tr>
  			<td>学生姓名</td>
  			<td>${student.studentName}</td>
  		</tr>
  		<tr>
  			<td>登录密码</td>
  			<td>${student.password}</td>
  		</tr>
  	</table>
  </body>
</html>
