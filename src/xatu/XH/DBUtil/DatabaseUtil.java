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
 * 实现数据库相关操作（数据库类为单例模式）
 * 
 * @author 徐欢
 * @time 11/19
 */
public class DatabaseUtil {

	/**
	 * 初始化
	 */
	static DatabaseUtil myDButil = null;
	// 加载驱动设置驱动链接
	String url = "jdbc:sqlserver://localhost:1433;databaseName=test";
	String userID = "sa";
	String password = "123456";
	Connection dbConn = null;

	private DatabaseUtil() {
		try {
			dbConn = DriverManager.getConnection(url, userID, password);
		} catch (SQLException e) {
			System.out.println("数据库连接错误!");
		}
	}

	/**
	 * 单例模式返回唯一 数据库工具对象
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
	 * 在数据库中查找是否存在相应学生
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
			System.err.println("校验学生登录时，信息数据库访问错误！");
		}

		return false;
	}

	/**
	 * 在数据库中查找是否存在相应教师
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
			System.err.println("访问教师信息时，数据库访问错误！");
		}

		return false;
	}

	/**
	 * 注册学生信息，自动生成学号，
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
			System.out.println("注册学生信息时，数据库访问错误！");
		}
		return false;
	}

	/**
	 * 返回学生信息
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
			// 获取结果集，由于登录的只有一人所以只有一个
			rs = statement.executeQuery();
			if (rs.next()) {
				student.setStudentNum(rs.getString(1));
				student.setStudentName(rs.getString(2));
				student.setPassword(rs.getString(3));
				return student;
			}
		} catch (SQLException e) {
			System.out.println("学生信息检索失败！");
		}
		return null;
	}

	/**
	 * 返回教师信息
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
			// 获取结果集，由于登录的只有一人所以只有一个
			rs = statement.executeQuery();
			if (teacher != null) {
				teacher.setTeacherNum(rs.getString(1));
				teacher.setTeacherName(rs.getString(2));
				teacher.setPassword(rs.getString(3));
				return teacher;
			}
		} catch (SQLException e) {
			System.out.println("教师信息检索失败！");
		}
		return null;
	}
	/**
	 * 根据输入id修改该用户密码
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
	 * 根据学生Id索引学生课程
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
			
			//强结果集存储在 classGrade 中
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
			System.out.println("根据学生id，做引学生课程出错！");
		}
		return null;
	}
	/**
	 * 根据学生Id索引学生同学
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
			
			//强结果集存储在 classGrade 中
			while (rs.next()) {
				Student student = new Student();
				student.setStudentNum(rs.getString(1));
				student.setStudentName(rs.getString(2));
				classMates.add(student);
			}
			System.out.println("根据学生id，索引同学信息！完毕");
			return classMates;
		} catch (SQLException e) {
			System.out.println("根据学生id，索引同学信息！");
		}		
		
		return null;
	}
	/**
	 * 根据课程id 索引课程中学生成绩
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
			
			//强结果集存储在 classGrade 中
			while (rs.next()) {
				Class classes = new Class();
				classes.setClassId(rs.getString(1));
				classes.setClassName(rs.getString(2));
				classGrade.add(classes);
			}
			return classGrade;
		} catch (SQLException e) {
			System.out.println("根据学生id，索引学生成绩！");
		}		
		
		return null;
	}
}






