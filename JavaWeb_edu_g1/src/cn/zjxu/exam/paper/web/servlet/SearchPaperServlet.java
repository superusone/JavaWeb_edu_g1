package cn.zjxu.exam.paper.web.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.zjxu.exam.paper.domain.Form;
import cn.zjxu.exam.paper.service.JudgeAnswerService;
/**
 *判断答案是否正确
 * @author Administrator
 *
 */
public class SearchPaperServlet extends PaperServlet {
	private JudgeAnswerService jas = new JudgeAnswerService();
/**
 * 调用Judge方法判断答案是否正确
 * @param request
 * @param response
 */
	public String JudgeAnswer(HttpServletRequest request,
			HttpServletResponse response) {
		
		
		Form form = getForm(request, response);
		
		System.out.println(form.toString());
		System.out.println(form.getId()+"="+ form.getPid1()+"="+ form.getPid1_useranswer());
		jas.Judge(form.getId(), form.getPid1(), form.getPid1_useranswer());
		jas.Judge(form.getId(), form.getPid2(), form.getPid2_useranswer());
		jas.Judge(form.getId(), form.getPid3(), form.getPid3_useranswer());
		jas.Judge(form.getId(), form.getPid4(), form.getPid4_useranswer());
		jas.Judge(form.getId(), form.getPid5(), form.getPid5_useranswer());
		jas.Judge(form.getId(), form.getPid6(), form.getPid6_useranswer());

		return "f:/SPServlet?method=ShowGrade&id" + request.getParameter("id");
	}
	
	private Form getForm(HttpServletRequest request,
			HttpServletResponse response){
		Form form = new Form();
		form.setId(request.getParameter("id"));
		
		String pid1 =request.getParameter("pid1");
		String[] pid1s = pid1.split("@");
		form.setPid1(pid1s[1]);
		form.setPid1_useranswer(pid1s[0]);
		
		String pid2 =request.getParameter("pid2");
		String[] pid2s = pid2.split("@");
		form.setPid2(pid2s[1]);
		form.setPid2_useranswer(pid2s[0]);
		
		String pid3 =request.getParameter("pid3");
		String[] pid3s = pid3.split("@");
		form.setPid3(pid3s[1]);
		form.setPid3_useranswer(pid3s[0]);
		
		String pid4 =request.getParameter("pid4");
		String pid4_useranswer = "";
		String[] pid4s = pid4.split("@@");
		for(int i = 0; i < pid4s.length; i++){
			String[] str = pid4s[i].split("@");
			pid4_useranswer +=str[0];
			pid4 = str[1];
		}
		form.setPid4(pid4);
		form.setPid4_useranswer(pid4_useranswer);
		
		String pid5 =request.getParameter("pid5");
		String[] pid5s = pid5.split("@");
		form.setPid5(pid5s[1]);
		if(pid5s[0].equals("true")){
			form.setPid5_useranswer("对");
		}else{
			form.setPid5_useranswer("错");
			
		}
		
		String pid6 =request.getParameter("pid6");
		String[] pid6s = pid6.split("@");
		form.setPid6(pid6s[1]);
		if(pid5s[0].equals("true")){
			form.setPid6_useranswer("对");
		}else{
			form.setPid6_useranswer("错");
			
		}
		
		
		
		return form;
	}
	
}