package cn.zjxu.exam.paper.service;

import java.util.List;

import cn.zjxu.exam.paper.dao.PaperDao;
import cn.zjxu.exam.paper.domain.Paper;

public class ShowPaperService extends PaperService {
	private PaperDao paperDao = new PaperDao();

	/**
	 * note查询试题
	 */
	public List<Paper> findByNote(String note) {
		List<Paper> paperTyped = paperDao.findByNote(note);
		return paperTyped;
	}
}
