<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <link rel="stylesheet" href="bootstrap3.2.2/css/bootstrap.min.css">
    <title>学生注册页面</title>
	<script type="text/javascript" language="javascript"> 
		function judge()
		{
			if(document.form1.studentName.value == "" ||
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
			  if(document.form1.password.value != document.form1.confirmPassword.value)
			 {
			 	window.alert("确认密码与新密码不一致");
			 	return ;
			 }
			 document.form1.submit();
		} 
	</script> 
  
  </head>
  
  <body>
    <div style="height:8%">
		<jsp:include page="Head.jsp"></jsp:include>
	</div>
    
	<!-- 注册学生信息 -->
	<div  align="center" style="padding-top:100px;">
	    <form name="form1" action="Register" method="post">
	    	<table style="border-collapse: separate;border-spacing: 40px;font-size: 30px;">
	    		<tr>
	    			<td>姓名:</td>
	    			<td>
	    				<input type="text" name = "studentName" id= "studentName" /> 
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>密码:</td>
	    			<td>
	    				<input type="password" name = "password" id="password"/> 
	    			</td>
	    		</tr>
	    		<tr>
	    			<td>确认密码:&nbsp</td>
	    			<td>
	    				<input type="password" name = "confirmPassword" id="confirmPAssword" /> 
	    			</td>
	    		</tr>
	    		<tr>
		   			<td>选择课程:&nbsp</td>
		   			<td>
		   				<input style="width:25px;height: 25px" type="checkbox" name="classes" value="C"/>C语言  &nbsp
		   				<input style="width:25px;height: 25px" type="checkbox" name="classes" value="Java"/>Java &nbsp
		   			</td>
		   		</tr>
		   		<tr>
		   			<td> </td> 
		   			<td>
		   				<input style="width:25px;height: 25px"  type="checkbox" name="classes" value="math"/>数学  &nbsp
		   				<input style="width:25px;height: 25px" type="checkbox" name="classes" value="chinese"/>语文  &nbsp
		   			</td>
		   		</tr>
<!-- 				<tr> -->
<!-- 		   			<td>上传照片：</td> -->
<!-- 		   			<td><input id="photo" name="photo" type="file" > </td> -->
<!-- 		   		</tr> -->
<!-- 	    		<tr> -->
<!-- 	    			<td>上传照片</td> -->
<!-- 	    			<td colspan="2"><input type="file" logo.png" width="120px" height="240px" /> </td> -->
<!-- 	    		</tr> -->
<!-- 	    		<tr> -->
<!-- 	    			<input type="file" name="doc" id="doc" onchange="javascript:setImagePreview();">    -->
<!-- 					<p><div id="localImag"><img id="preview" width=-1 height=-1 style="diplay:none" /></div></p>   -->
<!-- 	    		</tr> -->
	    		<ty>
	    			<td></td>
	    			<td>
		    			<input class="btn btn-lg btn-primary" type="button" value="提交" onclick="judge()"/>
		    			 &nbsp
		    			<input class="btn-lg btn-warning" type="reset" value="重置" /> 
	    			</td>
	    		</ty>	    		
	    	</table>
	   </form>
   </div>
  </body>
</html>
