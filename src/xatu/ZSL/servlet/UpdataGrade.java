package xatu.ZSL.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xatu.XH.DBUtil.DatabaseUtil;

public class UpdataGrade extends HttpServlet implements Servlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String studentId = request.getParameter("studentId");
		String grade = request.getParameter("grade");
		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
		util.updataGrade(studentId,grade);
		session.setAttribute("EachClassGrade",util.EachClassGrade(session.getAttribute("userId").toString()));
		response.sendRedirect("iframe/teacher/EachClassGrade.jsp");
		System.out.println("¸üÐÂÍê±Ï");
	} 

}
