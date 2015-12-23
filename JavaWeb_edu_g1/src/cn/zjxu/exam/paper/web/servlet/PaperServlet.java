package cn.zjxu.exam.paper.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
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
	
	
	
	
	
	
	
	
	
	
	
	
}
