package cn.zjxu.exam.paper.service;

import cn.zjxu.exam.paper.dao.PaperDao;
import cn.zjxu.exam.paper.web.servlet.PaperServlet;
import cn.zjxu.exam.sp.dao.SPDao;
import cn.zjxu.exam.sp.domain.SP;

/**
 * 判断答案是否正确
 * 
 * @author lunatic
 *
 */
public class JudgeAnswerService extends PaperServlet {
	private SPDao spDao = new SPDao();
	private PaperDao paperDao = new PaperDao();

	/**
	 * 判断答案是否正确
	 * 
	 * @param id
	 *            用户id
	 * @param pid
	 *            题目编号
	 * @param userAnswer
	 *            用户答案
	 */
	public void Judge(String id, String pid, String userAnswer) {

		String answer = paperDao.getAnswer(pid);
		int grade;
		SP sp = new SP();
		if (userAnswer.equals(answer)) {
			grade = 10;
			sp.setGrade(grade);
			sp.setId(id);
			sp.setPid(pid);
			spDao.add(sp);

		} else {
			grade = 0;
			sp.setGrade(grade);
			sp.setId(id);
			sp.setPid(pid);
			spDao.add(sp);
		}
	}

}
