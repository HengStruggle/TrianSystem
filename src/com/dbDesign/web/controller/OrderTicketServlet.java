package com.dbDesign.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.dbDesign.json.SeatInfo;
import com.dbDesign.json.TicketInfo;
import com.dbDesign.service.ISeatInfoService;
import com.dbDesign.service.ITicketInfoService;
import com.dbDesign.service.impl.SeatInfoService;
import com.dbDesign.service.impl.TicketInfoService;

/**
 * <h2>用户订票请求类</h2><br>
 * 点击订单按钮&nbsp;请求并回复对应订单的一个为空的座位号<br>
 * 点击确认按钮&nbsp;请求添加订单，回复添加结果<br>
 * <br>
 * 
 * @author Administrator
 * 
 */
public class OrderTicketServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 503194196685110273L;

//	private static final String ORDER_FORWORD = "预订";
//	private static final String ORDER_CONFIRM = "确定";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("下单");
		
//		String order = req.getParameter("order");
		String trainNo = req.getParameter("train_no");
		System.out.println(trainNo);
//		String startDate = req.getParameter("startdate");
		String userName = req.getParameter("username");
		System.out.println(userName);
//		String seatNo = req.getParameter("seat_no");
//		System.out.println(seatNo);
		String startTime = req.getParameter("starttime");
		System.out.println(startTime);
		int seatLevel = Integer.valueOf(req.getParameter("seatlevel"));
		System.out.println(seatLevel);
		int ticketPrice = Integer.valueOf(req.getParameter("ticket_price"));
		System.out.println(ticketPrice);

		// 获得乘车日期
				String year = req.getParameter("year");
				System.out.println(year);
				String month = req.getParameter("month");
				System.out.println(month);
				String day = req.getParameter("day");
				System.out.println(day);

				// 转换为SQL日期格式
		String startDate = Date.valueOf(year + "-" + month + "-" + day).toString();
		System.out.println(startDate);
		ISeatInfoService seatService = new SeatInfoService();
		ITicketInfoService ticketService = new TicketInfoService();

		JSONObject result = new JSONObject();
		
		String seatNo = seatService.allocSeat(trainNo, startDate,
				seatLevel).getSeatNo();
		
//
//		// 预订
//		if (order.equals(ORDER_FORWORD)) {
//			SeatInfo seatInfo = seatService.allocSeat(trainNo, startDate,
//					seatLevel);
//			if (seatInfo != null) {
//				result.put("status", "success");
//				result.put("seat_no",seatInfo.getSeatNo());
//				System.out.println("分配座位成功");
//			} else {
//				result.put("status", "error");
//				System.out.println("分配座位失败");
//			}
//			// 确定订单
//		} else if (order.equals(ORDER_CONFIRM)) {
			TicketInfo ticketInfo = new TicketInfo();
			ticketInfo.setUserName(userName);
			ticketInfo.setTrainNo(trainNo);
			ticketInfo.setStartDate(startDate);
			ticketInfo.setStartTime(startTime);
			ticketInfo.setSeatNo(seatNo);
			ticketInfo.setSeatLevel(seatLevel);
			ticketInfo.setTicketPrice(ticketPrice);
			if (ticketService.userAddTicket(ticketInfo) == true) {
				if (seatService.useSeat(trainNo, seatNo, startDate) == true) {
					result.put("status", "success");
					System.out.println("订单成功");
				}
			} else {
				result.put("status", "error");
				System.out.println("订单失败");
			}
//		}
		resp.setContentType("text/html"); 
		PrintWriter out  = resp.getWriter();
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
