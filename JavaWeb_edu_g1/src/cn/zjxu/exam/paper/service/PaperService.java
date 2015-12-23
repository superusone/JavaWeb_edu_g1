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
	 * 加载
	 */
	public Paper findByPid(String pid) {
		return paperDao.findByPid(pid);
	}
	/*
	 * 编辑
	 */
	public void edit(Paper p) {
		paperDao.edit(p);
	}
	
	
	
	
	
	
	
	
}
