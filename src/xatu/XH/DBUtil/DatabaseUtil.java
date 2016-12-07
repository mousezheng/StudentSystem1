package xatu.XH.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import xatu.entity.*;

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
	//��������
	String driver = "com.mysql.jdbc.Driver";
	//Ҫ���ʵ����ݿ������
	String url = "jdbc:mysql://127.0.0.1:3306/test";
	//mysql �����û��� ����
	String password = "1486145487";
	String user = "root";
	
	//sqlSever ���ݿ�����
//	String url = "jdbc:sqlserver://localhost:1433;databaseName=test";
//	String userID = "sa";
//	String password = "123456";
	Connection dbConn = null;

	private DatabaseUtil() {
		try {
			//��������
			Class.forName(driver);
			//�������ݿ�
			dbConn = DriverManager.getConnection(url, user, password);
		}catch (ClassNotFoundException e) {
			System.out.println("��������ʧ�ܣ�");
		}catch (SQLException e) {
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

		String sql = "SELECT * FROM teachers where (teacherName = ? or teacherId = ?)and password = ?";
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
	 * 
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
	 * 
	 * @return
	 * @throws SQLException
	 */
	public Teacher teacherInformation(String teacherId) {
		Teacher teacher = new Teacher();
		String sql = "SELECT t.teacherId,t.teacherName,c.className,c.classTime " +
				" FROM teachers t,class c " +
				" where t.classid=c.classId and t.teacherId = ?";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql);
			statement.setString(1, teacherId);
			// ��ȡ����������ڵ�¼��ֻ��һ������ֻ��һ��
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				teacher.setTeacherNum(rs.getString(1));
				teacher.setTeacherName(rs.getString(2));
				teacher.setClassName(rs.getString(3));
				teacher.setClassTime(rs.getString(4));
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
	 * 
	 * @return
	 */
	public List<Classes> studentClassGrade(String studentId) {
		List<Classes> classGrade = new ArrayList<Classes>();
		String sql_1 = "SELECT b.classId,c.className,c.classTime,b.grade "
				+ "FROM student_class b,class c "
				+ "WHERE b.studentId=? and b.classId=c.classId";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql_1);
			statement.setString(1, studentId);
			ResultSet rs = statement.executeQuery();

			// ǿ������洢�� classGrade ��
			while (rs.next()) {
				Classes classes = new Classes();
				classes.setClassId(rs.getString(1));
				classes.setClassName(rs.getString(2));
				classes.setClassTime(Integer.parseInt(rs.getString(3).replace(
						" ", "")));
				classes.setGrade(Integer.parseInt(rs.getString(4).replace(" ",
						"")));
				classGrade.add(classes);
			}
			return classGrade;
		} catch (SQLException e) {
			System.out.println("����ѧ��id������ѧ���γ̳���");
		}
		return null;
	}

	/**
	 * ����ѧ��Id����ѧ��ͬѧ
	 * 
	 * @return
	 */
	public List<Student> studentClassmaters(String studentId) {
		List<Student> classMates = new ArrayList<Student>();
		String sql_1 = "SELECT s.studentId,s.studentName "
				+ "FROM student_class b,students s WHERE b.studentId = s.studentId and s.studentId != ? and b.classId in "
				+ "(SELECT classId FROM student_class b where b.classId = ? )";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql_1);
			statement.setString(1, studentId);
			statement.setString(2, studentId);
			ResultSet rs = statement.executeQuery();

			// ǿ������洢�� classGrade ��
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
	 * 
	 * @param classId
	 * @return
	 */
	public List<Student> EachClassGrade(String teacherId) {
		List<Student> classGrade = new ArrayList<Student>();
		String sql_1 = "SELECT studentName,s.studentId,c.className,b.grade "
				+ " FROM student_class b,class c,teachers t,students s "
				+ " WHERE t.teacherId=? and b.classId=c.classId and c.classId = t.classId and s.studentId=b.studentId ";
		try {
			PreparedStatement statement = dbConn.prepareStatement(sql_1);
			statement.setString(1, teacherId);
			ResultSet rs = statement.executeQuery();

			// ǿ������洢�� classGrade ��
			while (rs.next()) {
				Student student = new Student();
				student.setStudentName(rs.getString(1));
				student.setStudentNum(rs.getString(2));
				student.setClassName(rs.getString(3));
				student.setGrade(rs.getString(4));
				classGrade.add(student);
			}
			return classGrade;
		} catch (SQLException e) {
			System.out.println("���ݽ�ʦid������ѧ���ɼ���");
		}

		return null;
	}

	/**
	 * ѧ��ѡ����Ҫ����ѧ���γ̱�
	 * @param classes
	 * @param id 
	 * @throws SQLException 
	 */
	public void updataStudentClass(String[] classes, int id) throws SQLException {
		String sql = "INSERT INTO student_class values(?,?,?)";
		for (int i = 0; i < classes.length; i++) {
			String num = null;
			System.out.println(classes[i]);
			if(classes[i].equals("C")) num = "20001";
			if(classes[i].equals("Java")) num = "20002";
			if(classes[i].equals("math")) num = "20003";
			if(classes[i].equals("chinese")) num = "20004";
			PreparedStatement statement = dbConn.prepareStatement(sql);
			statement.setString(1, num);
			statement.setString(2, id+"");
			statement.setString(3, "");
			statement.executeUpdate();
		}
		System.out.println("����ѧ���γ����");
	}
}






