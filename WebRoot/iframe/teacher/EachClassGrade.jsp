<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	 <link rel="stylesheet" href="../../bootstrap3.2.2/css/bootstrap.min.css">
  </head>
  
  <body style="background-color: #BBBBBB">
  	<h1 align="center">学生成绩</h1><hr/>
  		<table class="table table-hover table-striped" style=" width:70%;font-size: 40px;text-align: center;" align="center">
  			<thead>
	  			<tr >
	  				<th style="text-align: center">学生姓名</th>
	  				<th style="text-align: center">学号</th>
					<th style="text-align: center">课程号</th>
	  				<th style="text-align: center">成绩</th>
	  			</tr>
	  		</thead>
	  		<c:set var="num" value="1"></c:set>
  			<c:forEach items="${EachClassGrade}" var="classGrade">
  				<c:if test="${num==1}">
	  				<tr class="warning">
	  					<td><c:out value="${classGrade.studentName }"></c:out>  </td>
	  					<td><c:out value="${classGrade.studentNum }"></c:out>	</td>
	  					<td><c:out value="${classGrade.className }"></c:out>	</td>
	  					<td><c:out value="${classGrade.grade }"></c:out>	</td>
	  				</tr>
  				</c:if>
  				<c:if test="${num==0}">
	  				<tr class="success">
	  					<td><c:out value="${classGrade.studentName }"></c:out>  </td>
	  					<td><c:out value="${classGrade.studentNum }"></c:out>	</td>
	  					<td><c:out value="${classGrade.className }"></c:out>	</td>
	  					<td><c:out value="${classGrade.grade }"></c:out>	</td>
	  				</tr>
  				</c:if>
  				<c:set var="num" value="${num+1%2 }"></c:set>
  			</c:forEach>
  		</table>
  </body>
</html>
