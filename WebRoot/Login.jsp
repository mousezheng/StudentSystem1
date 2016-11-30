<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>登录页面</title>
    <script type="text/javascript" language="javascript">
		function judge()
		{
			if(document.form1.name.value == "" ||
			 document.form1.password.value == "")
			 {
			 	window.alert("用户名或者密码不能为空");
			 	return;
			 }
			 if(document.form1.password.value.length < 6)
			 {
			 	window.alert("密码不能少于6位");
			 	return;
			 }
			 document.getElementById("form1").submit();
		}
	</script>
  </head>
  
  <body>
    <div style="height:10%">
    	<jsp:include page="Head.jsp"></jsp:include>
    </div>
    <h2 align="center">登录页面</h2>
    <hr>

	<!--登录模块 -->
	<div align="center" style="padding-top: 3%; height: 80%">
	    <div style="width: 30%;background-color: EEEEEE; padding: 10%" align="center" >
	    	<img src="logo.png" width="100" height="100" alt="logo" />
	      	<form name="form1" id="form1" action="LoginCheck" method="post">
		   		<table align="center">
		   			<tr>
		   				<td>用户ID</td>
		   				<td>
		   					<input id="name" type="text" name="name">
		   				</td>
		   				<td><a href="Register.jsp">学生注册</a></td>
		   			</tr>
		   			<tr>
		   				<td>密 &nbsp 码</td>
		   				<td>
		   					<input id="password" type="password" name="password">
		   				</td>
		   				<td>
		   					
		   				</td>
		   			</tr> 
		   			<tr>
		   				<td>
		   				</td>
		   				<td>
		   				  	<input type="radio" value="student" name="position" checked="true">学生
		   				  	&nbsp 
		   					<input type="radio" value="teacher" name="position" >教师
		   				</td>
		   			</tr>
		   			<tr>
		   				<td>
		   				</td>
		   				
		   				<td>
		   				  	<input type="button" value="提交" onclick="judge()" />
		   				  	&nbsp 
		   					<input type="reset" value="重置" />
		   				</td>
		   			</tr>
		   		</table>
	   		</form>
	    </div>
    </div>
    <div style="height: 10%">
    <jsp:include page="Tail.jsp" ></jsp:include>
    </div>
  </body>
</html>

