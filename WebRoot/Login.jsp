<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html >
<head>

<link rel="stylesheet" href="bootstrap3.2.2/css/bootstrap.min.css">
<script src="bootstrap3.2.2/js/jquery-2.1.1.min.js"></script>
<script src="bootstrap3.2.2/js/bootstrap.min.js"></script>
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
	<div style="height:8%">
		<jsp:include page="Head.jsp"></jsp:include>
	</div>
<!-- 	<div style="background-color: 45bff2;padding: 0px;margin: 0px"> -->
<!-- 		<h2 align="center">登录页面</h2> -->
<!-- 		<hr> -->
<!-- 	</div> -->
	<!--登录模块 -->
	
	<div 
		style="padding-top: 4%; padding-right:10%; height: 94%; background-color: 00dddd;" align="right">	
		
		<div id="carousl-ad" class="carousel slide" data-ride="carousel" style="position:absolute; z-index: 1;width: 100%;height: 94%;top:8%">
			<!-- 轮播（Carousel）指标 -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>   
			<!-- 轮播（Carousel）项目 -->
			<div class="carousel-inner">
				<div class="item active">
					<img style="width: 100%;height: 100%" src="image/1.png" alt="First slide">
				</div>
				<div class="item">
					<img style="width: 100%;height: 100%" src="image/2.png" alt="Second slide">
				</div>
				<div class="item">
					<img style="width: 100%;height: 100%" src="image/3.png" alt="Third slide">
				</div>
			</div>
			<!-- 轮播（Carousel）导航 -->
			<a class="carousel-control left" href="#myCarousel" 
			   data-slide="prev">&lsaquo;</a>
			<a class="carousel-control right" href="#myCarousel" 
			   data-slide="next">&rsaquo;</a>
		</div> 
			
		<div style="position:absolute; z-index:2; width: 500px; height:600px ;background-color: 282828; padding: 30px;left: 70%;border-radius:30px"
			align="center">
			<img src="image/logo.png" width="200px" height="200px" alt="logo"
				style="padding-top:10%;" />
			<form name="form1" id="form1" action="LoginCheck" method="post"
				style="padding-top: 40px;">
				<table align="center" style="font-size: 25px;color:EEEEEE; border-collapse: separate;border-spacing: 13px" >
					<tr>
						<td class="glyphicon glyphicon-user">用户ID</td>
						<td>
					</tr>
					<tr>
						<td><input style="height: 30px;color: 000000;" id="name" type="text" name="name">
						</td>
						<td><a href="Register.jsp">学生注册</a>
						</td>
					</tr>
					<tr>
						<td class="glyphicon glyphicon-asterisk">密码</td>
						<td></td>
					</tr>
					<tr>
						<td><input style="height: 30px;color: 000000;" id="password" type="password" name="password">
						</td>
						<td></td>
					</tr>
					<tr>
						<td style="font-size: 30px">
							<input  type="radio" value="student" name="position"
							checked="true">学生 &nbsp <input type="radio"
							value="teacher" name="position">教师</td>
						<td></td>
					</tr>
					<tr>
						<td ><input class="btn btn-lg btn-primary" style="font-size: 25px" type="button" value="提交" onclick="judge()" />
							&nbsp <input class="btn-lg btn-warning" style="font-size: 25px" type="reset" value="重置" /></td>
						<td></td>
					</tr>
				</table>
			</form>
		</div>
		
	</div>
	<div style="height: 8%;">
		<jsp:include page="Tail.jsp"></jsp:include>
	</div>
</body>
</html>












