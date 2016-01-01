package cn.zjxu.exam.sp.service;

import java.util.List;

import cn.zjxu.exam.paper.dao.PaperDao;
import cn.zjxu.exam.sp.dao.SPDao;
import cn.zjxu.exam.sp.domain.SP;

/**
 * 返回成绩
 * @author lunatic
 *
 */
public class SPService {
	private SPDao spDao = new SPDao();
	private PaperDao paperDao = new PaperDao();
/**
 * 显示成绩
 * @param id 用户id
 * @return  “sum_A@sum_B”;
 */
	public String ShowGrade(String id) {
		List<SP> spList = spDao.findById(id);

		int sum_A = 0;
		int sum_B = 0;
		for (SP sp : spList) {
			if (paperDao.getNote(sp.getPid()).contains("A")) {
				sum_A += sp.getGrade();
			}else{
				sum_B += sp.getGrade();
			}
		} 
		return sum_A+ "@" + sum_B;
	}

}
