package cn.zjxu.exam.sp.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.zjxu.exam.sp.service.SPService;

public class SPServlet extends BaseServlet {
	private SPService sps = new SPService();

	public String ShowGrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("-----" + id);
		if (id != null) {
			String[] grade = sps.ShowGrade(id).split("@");
			request.setAttribute("A", grade[0]);
			request.setAttribute("B", grade[1]);
		}
		return findAll(request, response);
	}

	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return "f:/jsps/body.jsp";
	}
}
