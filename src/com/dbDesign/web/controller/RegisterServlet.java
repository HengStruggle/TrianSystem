package com.dbDesign.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.dbDesign.Exception.UserExistException;
import com.dbDesign.json.User;
import com.dbDesign.service.IUserService;
import com.dbDesign.service.impl.UserService;
import com.dbDesign.util.WebUtils;

/**
 * <h2>用户注册请求类</h2><br>
 * 用户输入用户名与密码，请求注册<br>
 * 回复注册结果<br>
 * <br>
 * 
 * @author Administrator
 * 
 */
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4886511387732261683L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 将客户端提交的表单数据封装到user对象中
//		User user = WebUtils.requestToBean(req, User.class);
//		try {
//			IUserService service = new UserService();
//			// 调用service层提供的注册用户服务实现用户注册
//			service.registerUser(user);
//			String message = String
//					.format("注册成功！！3秒后为您自动跳转到登录界面！！<meta http-equiv='refresh' content='3;url=%s'/'",
//							req.getContextPath() + "/servlet/LoginUIServlet");
//			req.setAttribute("message", message);
//			req.getRequestDispatcher("/message.jsp").forward(req, resp);
//		} catch (UserExistException e) {
//			req.getRequestDispatcher("/index.jsp").forward(req, resp);
//		} catch (Exception e) {
//			e.printStackTrace();
//			req.setAttribute("message", "对不起，注册失败！！");
//			req.getRequestDispatcher("/message.jsp").forward(req, resp);
//		}
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
				
		// 将客户端提交的表单数据封装到user对象中
		// 获取用户填写的登录用户名
				String username = req.getParameter("username");
				// 获取用户填写的登录密码
				String password = req.getParameter("password");
				// 获取用户的角色
				String userRole = req.getParameter("role");
				
				User user = new User();
				user.setUserName(username);
				user.setPassword(password);
				user.setRole(userRole);
				System.out.println(user.getUserName()+ "注册");
		
		JSONObject result = new JSONObject();
		try {
			IUserService service = new UserService();
			// 调用service层提供的注册用户服务实现用户注册
			service.registerUser(user);
			result.put("status", "success");
			System.out.println("注册成功");
		} catch (UserExistException e) {
			result.put("status", "error");
			System.out.println("注册失败，用户名存在");
		} catch (Exception e) {
			e.printStackTrace();
			//result.put("status", "error");
		}finally{
			resp.setContentType("text/html"); 
			PrintWriter out  = resp.getWriter();
			out.print(result.toString());
			
			out.flush();
			out.close();
		}
	}
}
