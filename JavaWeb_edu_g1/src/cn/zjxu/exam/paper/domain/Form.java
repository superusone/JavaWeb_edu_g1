package cn.zjxu.exam.paper.domain;

public class Form {
	private String id;// 用户编号
	private String pid1;// 题目编号
	private String pid2;// 题目编号
	private String pid3;// 题目编号
	private String pid4;// 题目编号
	private String pid5;// 题目编号
	private String pid6;// 题目编号
	private String pid1_useranswer;// 用户答案
	private String pid2_useranswer;// 用户答案
	private String pid3_useranswer;// 用户答案
	private String pid4_useranswer;// 用户答案
	private String pid5_useranswer;// 用户答案
	private String pid6_useranswer;// 用户答案

	public Form(String id, String pid1, String pid2, String pid3, String pid4,
			String pid5, String pid6, String pid1_useranswer,
			String pid2_useranswer, String pid3_useranswer,
			String pid4_useranswer, String pid5_useranswer,
			String pid6_useranswer) {
		super();
		this.id = id;
		this.pid1 = pid1;
		this.pid2 = pid2;
		this.pid3 = pid3;
		this.pid4 = pid4;
		this.pid5 = pid5;
		this.pid6 = pid6;
		this.pid1_useranswer = pid1_useranswer;
		this.pid2_useranswer = pid2_useranswer;
		this.pid3_useranswer = pid3_useranswer;
		this.pid4_useranswer = pid4_useranswer;
		this.pid5_useranswer = pid5_useranswer;
		this.pid6_useranswer = pid6_useranswer;
	}

	public Form() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPid1() {
		return pid1;
	}

	public void setPid1(String pid1) {
		this.pid1 = pid1;
	}

	public String getPid2() {
		return pid2;
	}

	public void setPid2(String pid2) {
		this.pid2 = pid2;
	}

	public String getPid3() {
		return pid3;
	}

	public void setPid3(String pid3) {
		this.pid3 = pid3;
	}

	public String getPid4() {
		return pid4;
	}

	public void setPid4(String pid4) {
		this.pid4 = pid4;
	}

	public String getPid5() {
		return pid5;
	}

	public void setPid5(String pid5) {
		this.pid5 = pid5;
	}

	public String getPid6() {
		return pid6;
	}

	public void setPid6(String pid6) {
		this.pid6 = pid6;
	}

	public String getPid1_useranswer() {
		return pid1_useranswer;
	}

	public void setPid1_useranswer(String pid1_useranswer) {
		this.pid1_useranswer = pid1_useranswer;
	}

	public String getPid2_useranswer() {
		return pid2_useranswer;
	}

	public void setPid2_useranswer(String pid2_useranswer) {
		this.pid2_useranswer = pid2_useranswer;
	}

	public String getPid3_useranswer() {
		return pid3_useranswer;
	}

	public void setPid3_useranswer(String pid3_useranswer) {
		this.pid3_useranswer = pid3_useranswer;
	}

	public String getPid4_useranswer() {
		return pid4_useranswer;
	}

	public void setPid4_useranswer(String pid4_useranswer) {
		this.pid4_useranswer = pid4_useranswer;
	}

	public String getPid5_useranswer() {
		return pid5_useranswer;
	}

	public void setPid5_useranswer(String pid5_useranswer) {
		this.pid5_useranswer = pid5_useranswer;
	}

	public String getPid6_useranswer() {
		return pid6_useranswer;
	}

	public void setPid6_useranswer(String pid6_useranswer) {
		this.pid6_useranswer = pid6_useranswer;
	}

	@Override
	public String toString() {
		return "Form [id=" + id + ", pid1=" + pid1 + ", pid2=" + pid2
				+ ", pid3=" + pid3 + ", pid4=" + pid4 + ", pid5=" + pid5
				+ ", pid6=" + pid6 + ", pid1_useranswer=" + pid1_useranswer
				+ ", pid2_useranswer=" + pid2_useranswer + ", pid3_useranswer="
				+ pid3_useranswer + ", pid4_useranswer=" + pid4_useranswer
				+ ", pid5_useranswer=" + pid5_useranswer + ", pid6_useranswer="
				+ pid6_useranswer + "]";
	}

}
