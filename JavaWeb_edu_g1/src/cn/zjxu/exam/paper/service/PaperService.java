package cn.zjxu.exam.paper.service;

import java.util.List;

import cn.zjxu.exam.paper.dao.PaperDao;
import cn.zjxu.exam.paper.domain.Paper;
import cn.zjxu.exam.user.domain.User;

public class PaperService {
	private PaperDao paperDao = new PaperDao();
	
	/**
	 * 试题集
	 * @return
	 */
	public List<Paper> findAll(){
		List list = paperDao.findAll();
		return list;
		
	}
	
	/**
	 * pid查询试题
	 * @param pid
	 * @return
	 */
	public Paper findByPid(String pid){
		Paper paper = paperDao.findByPid(pid);
		return paper;
	}
	
	public void add(Paper paper) throws PaperException{
		if(paperDao.findByQ_subject(paper.getQ_subject()) != null){
			throw new PaperException("题目重复！");
		}
		
		paperDao.add(paper);
	}
	/**
	 * 编辑
	 * @param paper
	 * @return
	 */
	public String Edit(Paper paper){
		paperDao.edit(paper);
		return "OK";
	}
	
	/**
	 * 删除试题
	 * @param pid
	 * @return
	 */
	public String delete(String pid){
		paperDao.delete(pid);
		return "OK!";
	}
}
