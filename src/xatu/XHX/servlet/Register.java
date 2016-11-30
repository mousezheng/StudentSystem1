package xatu.XHX.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.faces.application.Application;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xatu.XH.DBUtil.DatabaseUtil;

public class Register extends HttpServlet implements Servlet {

	
	
 
	/**
	 * 完成get提交方式的后台处理
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * 完成post提交方式的后台处理
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext application = this.getServletContext();
		if(application.getAttribute("studentId") == null)
			application.setAttribute("studentId",0);
		// 将用户姓名和学号添加到学生表中，同时生成学号，学号为流水号，，
		
		int id = 0;
		
		if (application.getAttribute("studentId") != null) {
			String strId = application.getAttribute("studentId").toString();
			id = Integer.parseInt(strId);
			application.setAttribute("studentId",id);
//			return;
		}

		String studentId = 1401 + "" + id;
		id++;
		application.setAttribute("studentId",id);

		// 获得姓名密码，课程信息
		String studentName = new String(request.getParameter("studentName").getBytes(
				"ISO-8859-1"), "utf-8");
		String password = new String(request.getParameter("password").getBytes(
				"ISO-8859-1"), "utf-8");
		String[] classes = request.getParameterValues("classes");

		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
		// 注册学生信息，到学生表
		if (util.insertIntoStudent(studentId, studentName, password)) {
			response.sendRedirect("result/RegisterSuccess.jsp?ID=" + studentId);
		} else
			response.sendRedirect("result/RegisterFailure.jsp");

	}
}
