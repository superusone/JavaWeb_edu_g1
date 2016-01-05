package cn.zjxu.exam.paper.service;

import java.util.List;

import cn.zjxu.exam.paper.dao.PaperDao;
import cn.zjxu.exam.paper.domain.Paper;

public class PaperService {
	private PaperDao paperDao = new PaperDao();
	/*
	 * 查找所有试题,依赖paperdao
	 */
	public List<Paper> findAll(){
		List list = paperDao.findAll();
		return list;
	}
	/*
	 * 通过pid查询试题
	 */
	public Paper findByPid(String pid) {
		return paperDao.findByPid(pid);
	}
	/*
	 * 编辑试题
	 */
	public void edit(Paper p) {
		paperDao.edit(p);
	}
	/*
	 * 查询试卷A
	 */
	public List<Paper> findByNoteA() {
		List list = paperDao.findByNoteA();
		return list;
	}
	/*
	 * 查询试卷B
	 */
	public List<Paper> findByNoteB() {
		List list = paperDao.findByNoteB();
		return list;
	}
	/*
	 * 添加试题
	 */
	public void add(Paper paper){
		paperDao.add(paper);
	}
	/*
	 * 删除试题
	 */
	public void delete(String pid){
		paperDao.delete(pid);
	}
	
	
	
}
