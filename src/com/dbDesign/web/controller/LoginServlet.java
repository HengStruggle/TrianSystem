package com.dbDesign.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.dbDesign.json.User;
import com.dbDesign.service.IUserService;
import com.dbDesign.service.impl.UserService;

/**
 * <h2>用户登录请求类</h2><br>
 * 用户选择登录角色、输入用户名与密码，请求登录<br>
 * 回复登录结果<br>
 * <br>
 * 
 * @author Administrator
 * 
 */
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2882490386630510670L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);
		// out.println(result.toString());

		// if (user == null) {
		// String message = String
		// .format("您所输入的用户名或密码错误！！请重新输入！！2秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='2;url=%s'/'",
		// req.getContextPath() + "/servlet/LoginUIServlet");
		// req.setAttribute("message", message);
		// req.getRequestDispatcher("/message.jsp").forward(req, resp);
		// return;
		// }
		// // 登录成功后，将用户存储到session中
		// req.getSession().setAttribute("user", user);
		// String message = String
		// .format("恭喜：%s,登录成功！3秒后为您自动跳到预订车票页面！！<meta http-equiv='refresh' content='3;url=%s'/'",
		// user.getUserName(), req.getContextPath()
		// + "/servlet/OrderTicketUIServlet");
		// req.setAttribute("message", message);
		// req.getRequestDispatcher("/message.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取用户填写的登录用户名
		String username = req.getParameter("username");
		// 获取用户填写的登录密码
		String password = req.getParameter("password");
		// 获取用户的角色
		String userRole = req.getParameter("role");

		// String username = (String) req.getAttribute("username");
		// String password = (String) req.getAttribute("password");
		// String userRole = (String) req.getAttribute("role");

		User user = null;
		IUserService service = new UserService();
		// 用户登录
		user = service.loginUser(username, password, userRole);
		System.out.println(username + password + userRole);

		JSONObject result = new JSONObject();
		if (user != null) {
			result.put("status", "success");
		} else {
			result.put("status", "error");
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print(result.toString());

		out.flush();
		out.close();
	}
}
