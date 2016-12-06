<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>修改密码</title>
    <script type="text/javascript" language="javascrpit">
    	function judge()
		{
			if(document.form1.oldPassword.value == "")
			 {
			 	window.alert("密码不能为空");
			 	return;
			 }
			 if(document.form1.oldPassword.value.length < 6)
			 {
			 	window.alert("密码不能少于6位");
			 	return;
			 }
			 if(document.form1.newPassword.value == document.form1.oldPassword.value)
			 {
			 	window.alert("修改密码请输入不一样的密码");
			 	return ;
			 }
			 if(document.form1.newPassword.value != document.form1.confirmPassword.value)
			 {
			 	window.alert("确认密码与新密码不一致");
			 	return ;
			 }
			 document.getElementById("form1").submit();
		}
    </script>
  </head>
  
  <body>
	<div style="height:10%">
		<jsp:include page="Head.jsp"></jsp:include>
	</div>
    <div style="width: 100%;height: 80%;background-color: 55EEEE" align="center">
		<form name="form1" action="ResetPassword" align="center" style="padding-top: 100px">
			<table  align="center" style="font-size: 25px">
		   		<tr>
		   			<td>旧密码</td>
		   			<td>
		   				<input style="height: 30px" type="password" id = "oldPassword" name = "oldPassword"/> 
		   			</td>
		   		</tr>
		   		<tr>
		   			<td>新密码</td>
		   			<td>
		   				<input style="height: 30px" type="password" id = "newPassword" name = "newPassword"/> 
		   			</td>
		   		</tr>
		   		<tr>
		   			<td>确认密码</td>
		   			<td>
		   				<input style="height: 30px" type="confirmPassword" id = "confirmPassword" name = "confirmPassword" /> 
		   			</td>
		   		</tr>
		   		<ty>
		   			<td></td>
		   			<td> <input style="font-size: 25px" type="button" value="提交" onclick="judge()" /> &nbsp
		   			 <input style="font-size: 25px" style="" type="reset" value="重置" /> </td>
		   		</ty>
	   		</table>
	   	</form>
   	 </div>
   	 <div style="height: 10%;">
		<jsp:include page="Tail.jsp"></jsp:include>
	</div>
  </body>
</html>














