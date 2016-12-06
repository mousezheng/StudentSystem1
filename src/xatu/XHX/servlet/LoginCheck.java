package xatu.XHX.servlet;

import java.io.IOException;

import javax.jms.Session;
import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xatu.XH.DBUtil.DatabaseUtil;

/**
 * 登录验证
 * 
 * @author 萧海霞
 * @time 11/23
 * 
 */
public class LoginCheck extends HttpServlet implements Servlet {

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
		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
		// 获取输入信息
		String Name = new String(request.getParameter("name").getBytes(
				"ISO-8859-1"), "utf-8");
		String password = new String(request.getParameter("password").getBytes(
				"ISO-8859-1"), "utf-8");
		String position = new String(request.getParameter("position").getBytes(
				"ISO-8859-1"), "utf-8");
		HttpSession session = request.getSession();
		if (position.equals("student")) {
			if (util.student(Name, password)) {
				session.setAttribute("userId", Name);
				response.sendRedirect("Student.jsp");
				//设置classGrade的session
				session.setAttribute("classGrade", util.studentClassGrade(Name));
				session.setAttribute("classMates", util.studentClassmaters(Name));
				session.setAttribute("student", util.studentInformation(Name));
				
			} else {
				response.sendRedirect("Failure.jsp");
			}
		}
		if (position.equals("teacher")) {
			if (util.teacher(Name, password)) {
				session.setAttribute("userId", Name);
				response.sendRedirect("Teacher.jsp");
				session.setAttribute("teacher", util.teacherInformation(Name));
				session.setAttribute("EachClassGrade",util.EachClassGrade(Name));
			} else {
				response.sendRedirect("Failure.jsp");
			}
		}

		// 通过DatabaseUtil的对象，对用户输入的姓名（学号）和密码进行校验
		// 通过返回结果情况进行相应的跳转

	}

}
