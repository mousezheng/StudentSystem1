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
 * ��¼��֤
 * 
 * @author ����ϼ
 * @time 11/23
 * 
 */
public class LoginCheck extends HttpServlet implements Servlet {

	/**
	 * ���get�ύ��ʽ�ĺ�̨����
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * ���post�ύ��ʽ�ĺ�̨����
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
		// ��ȡ������Ϣ
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
				//����classGrade��session
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

		// ͨ��DatabaseUtil�Ķ��󣬶��û������������ѧ�ţ����������У��
		// ͨ�����ؽ�����������Ӧ����ת

	}

}
