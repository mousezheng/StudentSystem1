<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	<link rel="stylesheet" href="../../bootstrap3.2.2/css/bootstrap.min.css">
  </head>
  
  <body style="background-color: #BBBBBB">
  	<h1 align="center">学生各科成绩</h1><hr/>
  	<div class="container" style="padding-top: 10%;">
	  	<table class="table table-hover table-striped" style="font-size: 40px;text-align: center;background-color: #FFFFFF" align="center">
	  		<thead>
		  		<tr>
		  			<th style="text-align: center"  width="10%">课程号</th>
		  			<th style="text-align: center" width="10%">课程名</th>
		  			<th style="text-align: center" width="10%">课时</th>
		  			<th style="text-align: center" width="10%">成绩</th>
		  		</tr>
		  	</thead>
		  	<c:set var="num" value="1"></c:set>
	  		<c:forEach items="${classGrade}" var="classGrade" >
	  			<c:if test="${num==1}">
		  			<tr class="warning">
		  				<td><c:out value="${classGrade.classId}"></c:out> </td>
		  				<td><c:out value="${classGrade.className}"></c:out> </td>
		  				<td><c:out value="${classGrade.classTime}"></c:out> </td>
		  				<td><c:out value="${classGrade.grade}"></c:out> </td>
		  			</tr>
		  		</c:if>
	  			<c:if test="${num==0}">
	  				<tr class="success">
		  				<td><c:out value="${classGrade.classId}"></c:out> </td>
		  				<td><c:out value="${classGrade.className}"></c:out> </td>
		  				<td><c:out value="${classGrade.classTime}"></c:out> </td>
		  				<td><c:out value="${classGrade.grade}"></c:out> </td>
		  			</tr>
	  			</c:if>
	  			<c:set var="num" value="${(num+1)%2 }"></c:set>
	  		</c:forEach>
	  		<tr>
	  			<td colspan="4" align="center">
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
