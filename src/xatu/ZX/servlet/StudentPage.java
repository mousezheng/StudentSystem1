package xatu.ZX.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import xatu.XH.DBUtil.DatabaseUtil;
import xatu.entity.Class;

public class StudentPage extends HttpServlet implements Servlet {

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
//		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
//		List<Class> classGrade = new ArrayList<Class>();
//		
//		//���� classGrade �� Session
//		classGrade = util.studentClassGrade(studentId);
		
	}

}
