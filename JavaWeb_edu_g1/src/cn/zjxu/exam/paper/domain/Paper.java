package cn.zjxu.exam.paper.domain;

public class Paper {
	private String pid; // 试题id
	private int type;// 试题类型 0：单选 1：多选 2：判断
	private String q_subject; // 题目
	private String q_answer;// 答案
	// 选项
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String note; // 备注

	public Paper(String pid, int type, String q_subject, String q_answer,
			String optionA, String optionB, String optionC, String optionD,
			String note) {
		super();
		this.pid = pid;
		this.type = type;
		this.q_subject = q_subject;
		this.q_answer = q_answer;
		this.optionA = optionA;
		this.optionB = optionB;
		this.optionC = optionC;
		this.optionD = optionD;
		this.note = note;
	}

	public Paper() {
		super();
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getQ_subject() {
		return q_subject;
	}

	public void setQ_subject(String q_subject) {
		this.q_subject = q_subject;
	}

	public String getQ_answer() {
		return q_answer;
	}

	public void setQ_answer(String q_answer) {
		this.q_answer = q_answer;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Override
	public String toString() {
		return "Paper [pid=" + pid + ", type=" + type + ", q_subject="
				+ q_subject + ", q_answer=" + q_answer + ", optionA=" + optionA
				+ ", optionB=" + optionB + ", optionC=" + optionC
				+ ", optionD=" + optionD + ", note=" + note + "]";
	}

}
