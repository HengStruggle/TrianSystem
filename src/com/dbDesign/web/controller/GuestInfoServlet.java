package com.dbDesign.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dbDesign.service.ITicketInfoService;
import com.dbDesign.service.impl.TicketInfoService;

/**
 * <h2>用户查看订单请求类</h2><br>
 * 请求并回复该用户的所有订单<br>
 * 接收改签、退票请求功能，回复操作结果<br>
 * <br>
 * 
 * @author Administrator
 * 
 */
public class GuestInfoServlet extends HttpServlet {

	private static final long serialVersionUID = -186408065851122526L;

	private static final String ORDER_CHECK = "check_ticket";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// String order = req.getParameter("order");
		String userName = req.getParameter("username");
		System.out.println("username");

		ITicketInfoService ticketService = new TicketInfoService();
		JSONObject result = new JSONObject();

		// if (order.equals(ORDER_CHECK)) {
		JSONArray resultArray = ticketService.userCheckTicket(userName);
		if (resultArray != null) {
			result.put("status", "success");
			result.put("result", resultArray);
		} else {
			result.put("status", "error");
		}
		// }

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print(result.toString());

		out.flush();
		out.close();
	}
}
