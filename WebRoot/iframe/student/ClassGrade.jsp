<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h1 align="center">学生课程成绩及其代课</h1><hr/>
  	<table border="1px"  style="font-size: 40px">
  		<tr>
  			<th>课程号</th>
  			<th>课程名</th>
  			<th>课时</th>
  			<th>成绩</th>
  		</tr>
  		<c:forEach items="${classGrade}" var="classGrade">
  			<tr>
  				<td><c:out value="${classGrade.classId}"></c:out> </td>
  				<td><c:out value="${classGrade.className}"></c:out> </td>
  				<td><c:out value="${classGrade.classTime}"></c:out> </td>
  				<td><c:out value="${classGrade.grade}"></c:out> </td>
  			</tr>
  		</c:forEach>
  	</table>
  </body>
</html>
