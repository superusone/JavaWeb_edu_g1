package cn.zjxu.exam.paper.web.servlet;

import java.io.IOException;

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
    	 * 吧paper保存到request域中
    	 * 转发到edit.jsp显示在表单中
    	 */
        String pid = request.getParameter("pid");
        System.out.println(pid);
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
		request.setAttribute("msg", "恭喜，编辑试题成功！");
		return "f:/msg.jsp";
	}
	
	
	
	
	
	
	
	
	
	
}
