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
		if (application.getAttribute("studentId") == null)
			application.setAttribute("studentId", 0);
		// ���û�������ѧ����ӵ�ѧ�����У�ͬʱ����ѧ�ţ�ѧ��Ϊ��ˮ�ţ���

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

		// ����������룬�γ���Ϣ
		String studentName = new String(request.getParameter("studentName")
				.getBytes("ISO-8859-1"), "utf-8");
		String password = new String(request.getParameter("password").getBytes(
				"ISO-8859-1"), "utf-8");
		String[] classes = request.getParameterValues("classes");
		// ����ͼƬ

		DatabaseUtil util = DatabaseUtil.getDatabaseUtil();
		try {
			util.updataStudentClass(classes,id);
		} catch (SQLException e) {
			System.out.println("���¿γ̳���");
		}
		// ע��ѧ����Ϣ����ѧ����
		if (util.insertIntoStudent(studentId, studentName, password)) {
			response.sendRedirect("result/RegisterSuccess.jsp?ID=" + studentId);
		} else
			response.sendRedirect("result/RegisterFailure.jsp");

	}

	/**
	 * ����ͼƬ��������//�����ļ��� G:\��ҵ\���\studentsSystem\WebRoot\image
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
//		// step1,����һ��DiskFileItemFactory����
//		// Ϊ�������ṩ����ʱ��ȱʡ�����á�
//		DiskFileItemFactory dfif = new DiskFileItemFactory();
//		// step2,����һ��������
//		ServletFileUpload sfu = new ServletFileUpload(dfif);
//		// step3,ʹ�ý���������
//		try {
//			// FileItem�����װ��һ�������е����е�
//			// ���ݡ�
//
//			List<FileItem> items = sfu.parseRequest(request);
//			for (int i = 0; i < items.size(); i++) {
//				FileItem item = items.get(i);
//				// Ҫ�ж���һ����ͨ�ı�����
//				// �ϴ��ļ���
//				if (item.isFormField()) {
//
//					// ��һ����ͨ�ı���
//					String name = item.getFieldName();
//					String value = item.getString();
//					System.out.println(name + ":" + value);
//				} else {
//					// �ϴ��ļ���,Ҫ���ļ������ڷ�������
//
//					// ���ʵ�ʲ���ʱ����·��
//					String path = "G:/��ҵ/���/studentsSystem/WebRoot/image";
//					System.out.println(path);
//					// ����ϴ��ļ�������
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




