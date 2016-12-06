<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生页面</title>
    <script type="text/javascript" language="javascript">
    	function switchIframe(num)
    	{ 
    		switch (num) {
			case 1:
				document.getElementById("iframe1").src="iframe/student/StudentInformation.jsp";
				//alert(document.getElementById("iframe1").src);
				break;
			case 2:
				document.getElementById("iframe1").src="iframe/student/ClassGrade.jsp";
				break;
			case 3:
				document.getElementById("iframe1").src="iframe/student/MatesInformation.jsp";
				break;
			default:
				alert("发生错误");
				break;
			}
    	}
    </script>
  </head>
  <style>
  	.studentButton{
  		background-color:888888;
  		width:100% ;
  		height: 15%;
  		font-size: 50px;
  		padding-top: 20px
  	}
  	#div1:focus,#div2:focus,#div3:focus{
  		background-color:777777;
  	}
  </style>  
  <body>
   	<div style="height:10%">
    	<jsp:include page="Head.jsp"></jsp:include>
    </div>
  
    <table name="table1" style="background-color: EEEEEE;height:90%;" width="100%">
    	<tr>
	    	<td width="15%">
	    		<div style="width: 100%;background-color: DDDDDD;height: 100%">
	    			<div id="div1" tabindex='1' class = "studentButton" onclick="switchIframe(1)">个人信息</div><br/>
	    			<div id="div2" tabindex='2' class = "studentButton" onclick="switchIframe(2)">各科成绩</div><br/>
	    			<div id="div3" tabindex='3' class = "studentButton" onclick="switchIframe(3)">同学信息</div><br/>
	    		</div>
	    	</td>
	 		<td width="80%">
	 			<div  style="width:100%;background-color: DDDDDD;height: 100%" align="center">
	 				<iframe id="iframe1" src="iframe/welcome.jsp" width="100%" height="100%" style="margin: 10px"></iframe> 
	 			</div>
	 		</td>
	 	</tr>
    </table>
     <div style="height: 10%">
    	<jsp:include page="Tail.jsp" ></jsp:include>
     </div>
  </body>
</html>
