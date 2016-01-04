package cn.zjxu.exam.paper.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import cn.zjxu.exam.paper.domain.Paper;
import cn.zjxu.exam.paper.service.PaperException;
import cn.zjxu.exam.paper.service.PaperService;

public class PaperServlet extends BaseServlet {
	private PaperService paperService = new PaperService();
	
    public String findAll(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 调用service方法，得到所有试题
         * 2. 保存到request域，转发到/adminjsps/admin/paper/list.jsp
         */
        request.setAttribute("PaperList", paperService.findAll());
        return "f:/adminjsps/admin/paper/list.jsp";
    }
    
    /**
     * 编辑之前的加载工作
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String preEdit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 获取pid
         * 2. 使用pid来调用service方法，得到paper对象
         * 3. 把paper保存到request域中
         * 4. 转发到edit.jsp显示在表单中
         */
        String pid = request.getParameter("pid");
        System.out.println(pid);
        Paper paper = paperService.findByPid(pid);
        request.setAttribute("paper", paper);
        return "f:/adminjsps/admin/paper/edit.jsp";
    }
	
	/**
	 * 编辑信息
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String edit(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		System.out.println("editing");
        /*
         * 1. 封装表单数据
         * 2. 调用service方法完成修改工作
         * 3. 调用findAll
         */
        Paper paper = CommonUtils.toBean(request.getParameterMap(), Paper.class);
        System.out.println(paper.getPid());
        paperService.Edit(paper);
        return findAll(request, response);
    }
	
	/**
	 * 添加试题
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
    public String add(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 封装表单数据
         * 2. 补全：pid
         * 3. 调用service方法完成添加工作
         * 4. 调用findAll()
         */
        Paper paper = CommonUtils.toBean(request.getParameterMap(), Paper.class);
        paper.setPid(CommonUtils.uuid());
        
        try {
			paperService.add(paper);
		} catch (PaperException e) {
			request.setAttribute("msg", e.getMessage());
            return "f:/adminjsps/msg.jsp";
		}
        
        return findAll(request, response);
    }
	
	/**
	 * 删除试题
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String delete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /*
         * 1. 获取参数:pid
         * 2. 调用service方法，传递pid参数
         *   > 如果抛出异常，保存异常信息，转发到msg.jsp显示
         * 3. 调用findAll()
         */
        String pid = request.getParameter("pid");
                
        paperService.delete(pid);
        return findAll(request, response);
    }
}
