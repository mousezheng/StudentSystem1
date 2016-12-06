<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

</head>

<body >
	<!-- 最顶端的菜单栏用于在各个jsp文件中使用 -->
	<div style="background-color: #282828;height:100%;width: 100%; ">
		<table width="100%" height="100%" style="color: #FFFFFF">
			<tr>
				<td width="200px">
						<h1 >XATU学生管理系统</h1>
				</td>
				<td width="60%"></td>	
				<td width="50px"><p>${userId},您好！</p></td>
				<td width="50px"><a href="ResetPassword.jsp">重置密码</a></td>
				<td width="50px"><a href="Exit" >退出登录</a></td>
			</tr>
		</table>
	</div>
</body>
</html>
