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
//		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
//		List<Class> classGrade = new ArrayList<Class>();
//		
//		//设置 classGrade 的 Session
//		classGrade = util.studentClassGrade(studentId);
		
	}

}
