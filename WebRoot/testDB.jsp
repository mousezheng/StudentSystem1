<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>    
    <title>My JSP 'TestDB.jsp' starting page</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
<%
	 //驱动名称
		String Driver = "com.mysql.jdbc.Driver";
		//要访问的数据库的链接
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		//mysql 配置用户名 密码
		String pwd = "1486145487";
		String user = "root";
// 	 String Driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
// 	 String url="jdbc:sqlserver://localhost:1433;databaseName=test";
// 	 String user="sa";
// 	 String pwd="123456";
	 Connection conn=null;
	 try {
	  Class.forName(Driver);
	 try {
	  conn= DriverManager.getConnection(url, user, pwd);
	  out.println("数据库连接成功！");
	 } catch (SQLException e) {
	  // TODO Auto-generated catch block
	  out.println("数据库连接失败！");
	  }
	 } catch (ClassNotFoundException e) {
	  // TODO Auto-generated catch block
	 out.println("数据库连接失败，请检查JDBC数据库驱动配置是否正确！");
	}
 %>
 <P><a href="Login.jsp">跳转到登录页面</a>
  </body>
</html>
