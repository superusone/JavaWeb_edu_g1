package cn.zjxu.exam.paper.web.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.zjxu.exam.paper.domain.Paper;
import cn.zjxu.exam.paper.service.PaperService;

public class PaperServlet extends BaseServlet {
	private PaperService paperService = new PaperService();
	/*
	 * 查找所有试题，依赖paperservice
	 */
	public String findAll(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	     /*
	      * 1. 调用service方法，得到所有试题
	      * 2. 保存到request域，转发到/adminjsps/admin/paper/list.jsp
	      */
	        request.setAttribute("PaperList", paperService.findAll());
	        return "f:/adminjsps/admin/paper/list.jsp";
	}
	
	/*
     * 编辑之前的加载工作
     */
    public String preEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	/*
    	 * 编辑之前的加载工作
    	 * 获取pid
    	 * 使用pid来调用service的load方法。得到paper对象
    	 * 把paper保存到request域中
    	 * 转发到edit.jsp显示在表单中
    	 */
        String pid = request.getParameter("pid");
        Paper paper = paperService.findByPid(pid);
        request.setAttribute("paper", paper);
        return "f:/adminjsps/admin/paper/edit.jsp";
    }
    
    /*
	 * 编辑方法
	 * 封装表单数据到customer对象中
	 * 调用service方法完成修改
	 * 保存成功信息到requst域
	 * 
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Paper p=CommonUtils.toBean(request.getParameterMap(), Paper.class);
		paperService.edit(p);
		request.setAttribute("msg", "编辑试题成功！");
		return "f:/adminjsps/admin/msg.jsp";
	}
	
	public String findByNoteA(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	/*
    	 * 使用note来调用service的findByNot方法。得到paper对象
    	 * 把paper保存到request域中
    	 * 转发到edit.jsp显示在表单中
    	 */
        List<Paper> paper = paperService.findByNoteA();
        request.setAttribute("PaperList", paper);
        return "f:/jsps/paper/desc.jsp";
    }
	public String findByNoteB(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Paper> paper = paperService.findByNoteA();
        request.setAttribute("PaperList", paper);
        return "f:/jsps/paper/desc.jsp";
    }
	
	/*
	 * 添加试题方法
	 */
	public String add(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*封装表单数据到paper对象
		  * 2补全cid ，使用uuid
		  * 3使用service方法完成添加工作
		  * 4向request 中保存成功信息
		  * 5转发到msg.jsp中
		  */
		Paper paper=CommonUtils.toBean(request.getParameterMap(), Paper.class);
		paper.setPid(CommonUtils.uuid());
		paperService.add(paper);
		 request.setAttribute("msg", "编辑试题成功！");
			return "f:/adminjsps/admin/msg.jsp";
	}
	/*
	 * 删除试题方法
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pid = request.getParameter("pid");
		paperService.delete(pid);
		request.setAttribute("msg", "试题删除成功！");
		return "f:/adminjsps/admin/msg.jsp";
	}
}
