package xatu.entity;
/**
 * ��ʦ��
 * @author ֣˼��
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
	 * ��ý�ʦ������
	 * @return
	 */
	public String getTeacherName() {
		return teacherName;
	}
	/**
	 * ���ý�ʦ����
	 * @return
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * ��ý�ʦ������
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * ���ý�ʦ������
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * ��ý�ʦ�Ľ̹���
	 * @return
	 */
	public String getTeacherNum() {
		return teacherNum;
	}
	/**
	 * ���ý�ʦ�Ľ̹���
	 * @return
	 */
	public void setTeacherNum(String teacherNum) {
		this.teacherNum = teacherNum;
	}
	
}
