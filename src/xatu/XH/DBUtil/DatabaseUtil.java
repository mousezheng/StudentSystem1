package xatu.XH.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xatu.entity.*;
import xatu.entity.Class;

/**
 * 
 * ʵ�����ݿ���ز��������ݿ���Ϊ����ģʽ��
 * 
 * @author �컶
 * @time 11/19
 */
public class DatabaseUtil {

	/**
	 * ��ʼ��
	 */
	static DatabaseUtil myDButil = null;
	// ��������������������
	String url = "jdbc:sqlserver://localhost:1433;databaseName=test";
	String userID = "sa";
	String password = "123456";
	Connection dbConn = null;

	private DatabaseUtil() {
		try {
			dbConn = DriverManager.getConnection(url, userID, password);
		} catch (SQLException e) {
			System.out.println("���ݿ����Ӵ���!");
		}
	}

	/**
	 * ����ģʽ����Ψһ ���ݿ⹤�߶���
	 * 
	 * @return DatabaseUtil
	 */
	public static DatabaseUtil getDatabaseUtil() {
		if (myDButil == null) {
			myDButil = new DatabaseUtil();
		}
		return myDButil;
	}

	/**
	 * �����ݿ��в����Ƿ������Ӧѧ��
	 * 
	 * @param userNameOrId
	 * @param passworld
	 * @return boolean
	 */
	public boolean student(String stuNameOrId, String password) {
		String sql = "SELECT * FROM students where (studentName = ? or studentId = ?) and password = ?";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			statement.setString(1, stuNameOrId);
			statement.setString(2, stuNameOrId);
			statement.setString(3, password);

			ResultSet rs = statement.executeQuery();

			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("У��ѧ����¼ʱ����Ϣ���ݿ���ʴ���");
		}

		return false;
	}

	/**
	 * �����ݿ��в����Ƿ������Ӧ��ʦ
	 * 
	 * @param userNameOrId
	 * @param passworld
	 * @return boolean
	 */
	public boolean teacher(String teacNameOrId, String password) {

		String sql = "SELECT * FROM teschers where (teacherName = ? or teacherId = ?)and password = ?";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			statement.setString(1, teacNameOrId);
			statement.setString(2, teacNameOrId);
			statement.setString(3, password);

			ResultSet rs = statement.executeQuery();

			if (rs.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.err.println("���ʽ�ʦ��Ϣʱ�����ݿ���ʴ���");
		}

		return false;
	}

	/**
	 * ע��ѧ����Ϣ���Զ�����ѧ�ţ�
	 * 
	 * @param stuNameOrId
	 * @param passworld
	 * @return
	 */
	public boolean insertIntoStudent(String stuNum, String stuName,
			String password) {

		String sql = "INSERT INTO students values(?,?,?)";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			statement.setString(1, stuNum);
			statement.setString(2, stuName);
			statement.setString(3, password);

			statement.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("ע��ѧ����Ϣʱ�����ݿ���ʴ���");
		}
		return false;
	}

	/**
	 * ����ѧ����Ϣ
	 * @return
	 * @throws SQLException
	 */
	public Student studentInformation(String studentId) {
		Student student = null;
		String sql = null;
		student = new Student();
		ResultSet rs;
		sql = "SELECT * FROM students where studentId= ? ";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			statement.setString(1, studentId);
			// ��ȡ����������ڵ�¼��ֻ��һ������ֻ��һ��
			rs = statement.executeQuery();
			if (rs.next()) {
				student.setStudentNum(rs.getString(1));
				student.setStudentName(rs.getString(2));
				student.setPassword(rs.getString(3));
				return student;
			}
		} catch (SQLException e) {
			System.out.println("ѧ����Ϣ����ʧ�ܣ�");
		}
		return null;
	}

	/**
	 * ���ؽ�ʦ��Ϣ
	 * @return
	 * @throws SQLException
	 */
	public Teacher teacherInformation(String teacherId) {
		Teacher teacher = null;
		String sql = null;
		teacher = new Teacher();
		ResultSet rs;
		sql = "SELECT * FROM teachers where teacherId= ? ";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			statement.setString(1, teacherId);
			// ��ȡ����������ڵ�¼��ֻ��һ������ֻ��һ��
			rs = statement.executeQuery();
			if (teacher != null) {
				teacher.setTeacherNum(rs.getString(1));
				teacher.setTeacherName(rs.getString(2));
				teacher.setPassword(rs.getString(3));
				return teacher;
			}
		} catch (SQLException e) {
			System.out.println("��ʦ��Ϣ����ʧ�ܣ�");
		}
		return null;
	}
	/**
	 * ��������id�޸ĸ��û�����
	 * 
	 * @return
	 */
	public boolean resetPassword(String userId, String newPassword) {
		String sql_1 = "UPDATE students set password= ? where studentId = ?";
		String sql_2 = "UPDATE teachers set password= ? where teacherId = ?";

		try {
			PreparedStatement sesStatement = dbConn.prepareStatement(sql_1);
			sesStatement.setString(1, newPassword);
			sesStatement.setString(2, userId);

			sesStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
		}

		try {
			PreparedStatement sesStatement = dbConn.prepareStatement(sql_2);
			sesStatement.setString(1, newPassword);
			sesStatement.setString(2, userId);

			sesStatement.executeUpdate();
			return true;
		} catch (SQLException e) {
		}

		return false;
		
	}
	
	/**
	 * ����ѧ��Id����ѧ���γ�
	 * @return
	 */
	public List<Class> studentClassGrade(String studentId){
		List<Class> classGrade = new ArrayList<Class>();
		String sql_1 = "SELECT b.classId,c.className,c.classTime,b.grade " +
				"FROM student_class b,class c " +
				"WHERE b.studentId=? and b.classId=c.classId";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql_1);
			statement.setString(1, studentId);
			ResultSet rs = statement.executeQuery();
			
			//ǿ������洢�� classGrade ��
			while (rs.next()) {
				Class classes = new Class();
				classes.setClassId(rs.getString(1));
				classes.setClassName(rs.getString(2));
				classes.setClassTime(Integer.parseInt(rs.getString(3).replace(" ", "")));
				classes.setGrade(Integer.parseInt(rs.getString(4).replace(" ", "")));
				classGrade.add(classes);
			}
			return classGrade;
		} catch (SQLException e) {
			System.out.println("����ѧ��id������ѧ���γ̳�����");
		}
		return null;
	}
	/**
	 * ����ѧ��Id����ѧ��ͬѧ
	 * @return
	 */
	public List<Student> studentClassmaters(String studentId){
		List<Student> classMates = new ArrayList<Student>();
		String sql_1 = "SELECT s.studentId,s.studentName "+
				"FROM student_class b,students s WHERE b.studentId = s.studentId and s.studentId != ? and b.classId in "+
				"(SELECT classId FROM student_class b where b.classId = ? )";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql_1);
			statement.setString(1, studentId);
			statement.setString(2, studentId);
			ResultSet rs = statement.executeQuery();
			
			//ǿ������洢�� classGrade ��
			while (rs.next()) {
				Student student = new Student();
				student.setStudentNum(rs.getString(1));
				student.setStudentName(rs.getString(2));
				classMates.add(student);
			}
			System.out.println("����ѧ��id������ͬѧ��Ϣ�����");
			return classMates;
		} catch (SQLException e) {
			System.out.println("����ѧ��id������ͬѧ��Ϣ��");
		}		
		
		return null;
	}
	/**
	 * ���ݿγ�id �����γ���ѧ���ɼ�
	 * @param classId
	 * @return
	 */
	public List<Class> classGrade(String studentId){
		List<Class> classGrade = new ArrayList<Class>();
		String sql_1 = "SELECT c.className,b.grade FROM student_class b,class c " +
				" WHERE b.studentId = ? and b.classId = c.classId";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql_1);
			statement.setString(1, studentId);
			ResultSet rs = statement.executeQuery();
			
			//ǿ������洢�� classGrade ��
			while (rs.next()) {
				Class classes = new Class();
				classes.setClassId(rs.getString(1));
				classes.setClassName(rs.getString(2));
				classGrade.add(classes);
			}
			return classGrade;
		} catch (SQLException e) {
			System.out.println("����ѧ��id������ѧ���ɼ���");
		}		
		
		return null;
	}
}





