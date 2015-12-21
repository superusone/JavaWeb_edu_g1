package cn.zjxu.exam.sp.domain;

public class SP {
	private String id;
	private String pid;
	private int grade;

	public SP(String id, String pid, int grade) {
		super();
		this.id = id;
		this.pid = pid;
		this.grade = grade;
	}

	public SP() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "SP [id=" + id + ", pid=" + pid + ", grade=" + grade + "]";
	}

}
