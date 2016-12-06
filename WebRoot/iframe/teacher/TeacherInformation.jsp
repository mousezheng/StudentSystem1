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
	  			<td width="15%">教师Id：${teacher.teacherNum}</td>
	  		</tr>
	  		<tr>
	  			<td>教师姓名姓名:${teacher.teacherName}</td>
	  		</tr>
	  		<tr>
	  			<td>所带课程:${teacher.className}</td>
	  		</tr>
	  		<tr>
	  			<td>所带课程:${teacher.classTime}</td>
	  		</tr>
	  	</table>
	  </div>
  </body>
</html>
