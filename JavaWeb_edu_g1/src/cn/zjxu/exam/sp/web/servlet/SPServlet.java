package cn.zjxu.exam.sp.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.servlet.BaseServlet;
import cn.zjxu.exam.sp.service.SPService;
/**
 * 显示成绩
 * @author Administrator
 *
 */
public class SPServlet extends BaseServlet {
	private SPService sps = new SPService();
/**
 * 若没有成绩，显示“该用户没有成绩记录”
 * @param request
 * @param response
 * @return
 * @throws ServletException
 * @throws IOException
 */
	public String ShowGrade(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println("-----" + id);
		if (id != null) {
			String s = sps.ShowGrade(id);
			if(! s.equals("该用户没有成绩记录")){
				System.out.println("ShowGrade::"+s);
				String[] grade = s.split("@");
				request.setAttribute("A", grade[0]);
				request.setAttribute("a", "A卷成绩：");
				System.out.println("A::"+ grade[0]);
				request.setAttribute("B", grade[1]);
				request.setAttribute("b", "B卷成绩：");
				System.out.println("B::"+ grade[1]);
			}else{
				request.setAttribute("msg", "该用户没有成绩记录");
			}
		}
		return findAll(request, response);
	}

	public String findAll(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		return "f:/jsps/body.jsp";
	}
}
