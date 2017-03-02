<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<link rel="stylesheet" href="../../bootstrap3.2.2/css/bootstrap.min.css">
  </head>
  
  <body style="background-color: #BBBBBB">
  	<h1 align="center">同学信息</h1><hr/>
  	<div style="padding-top: 10%;">
	  	<table class="table  table-hover table-striped" style="width:50%;font-size: 40px;text-align: center;background-color: #FFFFFF" align="center">
		  	<thead>
		  		<tr>
		  			<th style="text-align: center" width="20%">学号</th>
		  			<th style="text-align: center" width="20%">姓名</th>
		  		</tr>
		  	</thead>	
		  	<c:set var="num" value="1"></c:set>
	  		<c:forEach items="${classMates}" var="classMates">
		  		<c:if test="${num==1}">
		  			<tr class="warning">
		  				<td><c:out value="${classMates.studentNum}"></c:out> </td>
		  				<td><c:out value="${classMates.studentName}"></c:out></td>
		  			</tr>
		  		</c:if>
		  		<c:if test="${num==0}">
		  			<tr class="success">
		  				<td><c:out value="${classMates.studentNum}"></c:out> </td>
		  				<td><c:out value="${classMates.studentName}"></c:out></td>
		  			</tr>
		  		</c:if>
		  		<c:set var="num" value="${(num+1)%2 }"></c:set>
	  		 </c:forEach>
	  		 <tr>
	  			<td colspan="2">
	  				<input class="btn btn-lg btn-primary" type="button" value="<-">
	  				<input class="btn btn-lg btn-primary" type="button" value="1">
	  				<input class="btn btn-lg btn-primary" type="button" value="2">
	  				<input class="btn btn-lg btn-primary" type="button" value="3">
	  				<input class="btn btn-lg btn-primary" type="button" value="->">
	  				<input type="text"  width="100px">
	  				<span class="glyphicon glyphicon-search"  oncluck="select()"></span>
	  			</td>
	  		</tr>
	  	</table>
  	</div>
  </body>
</html>
