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
		ServletContext application = this.getServletContext();
		if(application.getAttribute("studentId") == null)
			application.setAttribute("studentId",0);
		// ���û�������ѧ����ӵ�ѧ�����У�ͬʱ����ѧ�ţ�ѧ��Ϊ��ˮ�ţ���
		
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

		// ����������룬�γ���Ϣ
		String studentName = new String(request.getParameter("studentName").getBytes(
				"ISO-8859-1"), "utf-8");
		String password = new String(request.getParameter("password").getBytes(
				"ISO-8859-1"), "utf-8");
		String[] classes = request.getParameterValues("classes");

		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
		// ע��ѧ����Ϣ����ѧ����
		if (util.insertIntoStudent(studentId, studentName, password)) {
			response.sendRedirect("result/RegisterSuccess.jsp?ID=" + studentId);
		} else
			response.sendRedirect("result/RegisterFailure.jsp");

	}
}
