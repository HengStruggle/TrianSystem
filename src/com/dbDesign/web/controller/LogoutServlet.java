package com.dbDesign.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <h2>用户注销请求类</h2><br>
 * 点击注销按钮&nbsp;请求注销<br>
 * 回复注销结果<br>
 * <br>
 * 
 * @author Administrator
 * 
 */
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3397609761127405327L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// 移除存储在session中的user对象，实现注销功能
		req.getSession().removeAttribute("user");

//		JSONObject result = new JSONObject();
		
//		resp.setContentType("text/html"); 
//		PrintWriter out  = resp.getWriter();
//		out.print(result.toString());
//		
//		out.flush();
//		out.close();
		
//		String message = String
//				.format("注销成功!!3秒后为您自动跳到登录界面！！<meta http-equiv='refresh' content='3;url=%s'/>",
//						req.getContextPath() + "/servlet/LoginUIServlet");
//		req.setAttribute("message", message);
//		req.getRequestDispatcher("/message.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
}
