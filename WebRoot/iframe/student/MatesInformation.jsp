<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
  	<h1 align="center">同学信息</h1><hr/>
  	<table border="1px"  style="font-size: 40px">
  		<tr>
  			<th>学号</th>
  			<th>姓名</th>
  		</tr>
  		<c:forEach items="${classMates}" var="classMates">
  			<tr>
  				<td><c:out value="${classMates.studentNum}"></c:out> </td>
  				<td><c:out value="${classMates.studentName}"></c:out></td>
  			</tr>
  		 </c:forEach>
  	</table>
  </body>
</html>
