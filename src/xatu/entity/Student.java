package xatu.entity;
/**
	 * ѧ����
	 * @author ֣˼��
	 * @time 11/20
	 */
public class Student{
	private String studentName;	//ѧ������	
	private String password;	//����
	private String studentNum;	//ѧ��	
	private String grade;		//�ɼ�
	private String className;	//�γ���
	
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * ���ѧ��������
	 * @return
	 */
	public String getStudentName() {
		return studentName;
	}
	/**
	 * ����ѧ������
	 * @return
	 */
	public void setStudentName(String stuName) {
		this.studentName = stuName;
	}
	/**
	 * ���ѧ��������
	 * @return
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * ����ѧ��������
	 * @return
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * ���ѧ����ѧ��
	 * @return
	 */
	public String getStudentNum() {
		return studentNum;
	}
	/**
	 * ����ѧ����ѧ��
	 * @return
	 */
	public void setStudentNum(String stuNum) {
		this.studentNum = stuNum;
	}
		
}
