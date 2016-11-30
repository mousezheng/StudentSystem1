package xatu.XHX.servlet;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import xatu.XH.DBUtil.DatabaseUtil;


public class ResetPassword extends HttpServlet implements Servlet { 
 
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获得
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		String newPassword = new String(request.getParameter("newPassword").getBytes(
				"iso8859-1"), "utf-8");
		response.setContentType("text/html charset=utf-8");
		response.setCharacterEncoding("utf-8");
//		System.out.println(userId);
		//更新数据库信息
		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
		if(util.resetPassword(userId,newPassword)){
			response.sendRedirect("result/ResetSuccess.jsp");
		}else {
			response.sendRedirect("result/ResetFailure.jsp");
		}

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
