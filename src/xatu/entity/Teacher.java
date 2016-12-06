package xatu.entity;
/**
 * 教师类
 * @author 郑思林
 * @time 11/20
 */
public class Teacher{
	private String teacherName;
	private String password;
	private String teacherNum;
	private String className;
	private String classTime;
	
	
	public String getClassTime() {
		return classTime;
	}
	public void setClassTime(String classTime) {
		this.classTime = classTime;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * 获得教师的姓名
	 * @return
	 */
	public String getTeacherName() {
		return teacherName;
	}
	/**
	 * 设置教师姓名
	 * @return
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * 获得教师的密码
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * 设置教师的密码
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获得教师的教工号
	 * @return
	 */
	public String getTeacherNum() {
		return teacherNum;
	}
	/**
	 * 设置教师的教工号
	 * @return
	 */
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	
}
