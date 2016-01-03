package cn.zjxu.exam.paper.web.servlet;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import cn.zjxu.exam.paper.domain.Paper;
import cn.zjxu.exam.paper.service.ShowPaperService;

public class ShowPaperServlet extends PaperServlet {

	private ShowPaperService sps = new ShowPaperService();

	/**
	 * 显示试卷
	 * @param request
	 * @param response
	 * @return
	 */
	public String ShowPaper(HttpServletRequest request,
			HttpServletResponse response) {
		String papertype = request.getParameter("papertype");
		List<Paper> paperTypedList = sps.findByNote(papertype);
		List<Paper> singleList = new ArrayList<Paper>();
		List<Paper> multiselectList = new ArrayList<Paper>();
		List<Paper> judgeList = new ArrayList<Paper>();
		for (Paper p : paperTypedList) {//根据题目类型将题目添加到不同的List当中
			if (p.getType() == 1) {
				// 单选
				singleList.add(p);
			} else if (p.getType() == 2) {
				// 多选
				multiselectList.add(p);
			} else {
				// 判断
				judgeList.add(p);
			}
		}
		request.setAttribute("singleList", singleList);
		request.setAttribute("multiselectList", multiselectList);
		request.setAttribute("judgeList", judgeList);

		return "f:/jsps/paper/desc.jsp";
 		}
}
