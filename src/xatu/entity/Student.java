package xatu.entity;
/**
	 * 学生类
	 * @author 郑思林
	 * @time 11/20
	 */
public class Student{
	private String studentName;	//学生姓名	
	private String password;	//密码
	private String studentNum;	//学号	
	
	/**
	 * 获得学生的姓名
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * 设置学生姓名
	 * @return
	 */
	public void setStudentName(String stuName) {
		this.studentName = stuName;
	}
	/**
	 * 获得学生的密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置学生的密码
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获得学生的学号
	 * @return
	 */
	public String getStudentNum() {
		return studentNum;
	}
	/**
	 * 设置学生的学号
	 * @return
	 */
	public void setStudentNum(String stuNum) {
		this.studentNum = stuNum;
	}
		
}
