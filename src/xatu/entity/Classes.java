package xatu.entity;


/**
 * 课程类
 * 课程号，课程名，课时，代课老师
 * @author 郑思林
 */
public class Classes {
	private String classId;
	private String className;
	private int classTime;
	private String teacherName;
	private int grade;
	/**
	 * 得到课程号
	 * @return
	 */
	public String getClassId() {
		return classId;
	}
	/**
	 * 设置课程号
	 * @param classId
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}
	/**
	 * 得到课程名
	 * @return
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * 设置课程名
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * 得到课时
	 * @return
	 */
	public int getClassTime() {
		return classTime;
	}
	/**
	 * 设置课时
	 * @param classTime
	 */
	public void setClassTime(int classTime) {
		this.classTime = classTime;
	}
	/**
	 * 得到老师实例
	 * @return
	 */
	public String getTeacherName() {
		return teacherName;
	}
	/**
	 * 设置老师姓名
	 * @param teacherName
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * 得到成绩
	 * @return
	 */
	public int getGrade(){
		return grade;
	}
	/**
	 * 设置成绩
	 * @param grade
	 */
	public void setGrade(int grade){
		this.grade = grade;
	}
	
}
