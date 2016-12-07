package xatu.XHX.servlet;

import java.io.IOException;
import java.sql.SQLException;

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
		if (application.getAttribute("studentId") == null)
			application.setAttribute("studentId", 0);
		// 将用户姓名和学号添加到学生表中，同时生成学号，学号为流水号，，

		int id = 0;

		if (application.getAttribute("studentId") != null) {
			String strId = application.getAttribute("studentId").toString();
			id = Integer.parseInt(strId);
			application.setAttribute("studentId", id);
			// return;
		}

		String studentId = 1401 + "" + id;
		id++;
		application.setAttribute("studentId", id);
//		saveFile(response, request, id);

		// 获得姓名密码，课程信息
		String studentName = new String(request.getParameter("studentName")
				.getBytes("ISO-8859-1"), "utf-8");
		String password = new String(request.getParameter("password").getBytes(
				"ISO-8859-1"), "utf-8");
		String[] classes = request.getParameterValues("classes");
		// 保存图片

		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
		try {
			util.updataStudentClass(classes,id);
		} catch (SQLException e) {
			System.out.println("更新课程出错！");
		}
		// 注册学生信息，到学生表
		if (util.insertIntoStudent(studentId, studentName, password)) {
			response.sendRedirect("result/RegisterSuccess.jsp?ID=" + studentId);
		} else
			response.sendRedirect("result/RegisterFailure.jsp");

	}

	/**
	 * 保存图片，到本地//保存文件到 G:\作业\组件\studentsSystem\WebRoot\image
	 * 
	 * @param response
	 * @param request
	 * @param id
	 * @throws IOException
	 */
//	private void saveFile(HttpServletResponse response,
//			HttpServletRequest request, int id) throws IOException {
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;charset=utf-8");
//		// step1,创建一个DiskFileItemFactory对象
//		// 为解析器提供解析时的缺省的配置。
//		DiskFileItemFactory dfif = new DiskFileItemFactory();
//		// step2,创建一个解析器
//		ServletFileUpload sfu = new ServletFileUpload(dfif);
//		// step3,使用解析器解析
//		try {
//			// FileItem对象封装了一个表单域当中的所有的
//			// 数据。
//
//			List<FileItem> items = sfu.parseRequest(request);
//			for (int i = 0; i < items.size(); i++) {
//				FileItem item = items.get(i);
//				// 要判断是一个普通的表单域还是
//				// 上传文件域
//				if (item.isFormField()) {
//
//					// 是一个普通的表单域
//					String name = item.getFieldName();
//					String value = item.getString();
//					System.out.println(name + ":" + value);
//				} else {
//					// 上传文件域,要将文件保存在服务器端
//
//					// 获得实际部署时物理路径
//					String path = "G:/作业/组件/studentsSystem/WebRoot/image";
//					System.out.println(path);
//					// 获得上传文件的名称
//					String typeStr = item.getName().split(".")[1];
//					String fileName = id + "." + typeStr;
//					File file = new File(path + "//" + fileName);
//					System.out.println(file);
//					item.write(file);
//				}
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

}




