package xatu.entity;


/**
 * �γ���
 * �γ̺ţ��γ�������ʱ��������ʦ
 * @author ֣˼��
 */
public class Classes {
	private String classId;
	private String className;
	private int classTime;
	private String teacherName;
	private int grade;
	/**
	 * �õ��γ̺�
	 * @return
	 */
	public String getClassId() {
		return classId;
	}
	/**
	 * ���ÿγ̺�
	 * @param classId
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}
	/**
	 * �õ��γ���
	 * @return
	 */
	public String getClassName() {
		return className;
	}
	/**
	 * ���ÿγ���
	 * @param className
	 */
	public void setClassName(String className) {
		this.className = className;
	}
	/**
	 * �õ���ʱ
	 * @return
	 */
	public int getClassTime() {
		return classTime;
	}
	/**
	 * ���ÿ�ʱ
	 * @param classTime
	 */
	public void setClassTime(int classTime) {
		this.classTime = classTime;
	}
	/**
	 * �õ���ʦʵ��
	 * @return
	 */
	public String getTeacherName() {
		return teacherName;
	}
	/**
	 * ������ʦ����
	 * @param teacherName
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}
	/**
	 * �õ��ɼ�
	 * @return
	 */
	public int getGrade(){
		return grade;
	}
	/**
	 * ���óɼ�
	 * @param grade
	 */
	public void setGrade(int grade){
		this.grade = grade;
	}
	
}
