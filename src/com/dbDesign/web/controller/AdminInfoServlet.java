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

public class AdminInfoServlet extends HttpServlet {

	private static final long serialVersionUID = 8781895964541196915L;

	private final String ORDER_CHECK = "checkAllOrder";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String order = req.getParameter("order");

		ITicketInfoService ticketService = new TicketInfoService();
		JSONObject result = new JSONObject();

		if (order.equals(ORDER_CHECK)) {
			JSONArray resultArray = ticketService.checkAllTicket();
			if (resultArray != null) {
				result.put("status", "success");
				result.put("result", resultArray);
			} else {
				result.put("status", "error");
			}
		}

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print(result.toString());

		out.flush();
		out.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}

}
