package com.dbDesign.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dbDesign.service.ITrainInfoService;
import com.dbDesign.service.impl.TrianInfoService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 查询余票请求类<br>
 * <br>
 * 用户输入始发站、终点站、乘车日期<br>
 * 请求对应的车次与座位信息<br>
 * 回复一个封装为trainSeatFormBean对象的JSON数组<br>
 * 
 * @author Administrator
 * 
 */
public class CheckTicketServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 200376526128752369L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

System.out.println("查询余票");
		
		// 获得始发站
		String departure = req.getParameter("departure");
		System.out.println(departure);
		// 获得终点站
		String terminal = req.getParameter("terminal");
		System.out.println(terminal);
		// 获得乘车日期
		String year = req.getParameter("year");
		System.out.println(year);
		String month = req.getParameter("month");
		System.out.println(month);
		String day = req.getParameter("day");
		System.out.println(day);

		// 转换为SQL日期格式
		Date startDate = Date.valueOf(year + "-" + month + "-" + day);
		ITrainInfoService service = new TrianInfoService();
		// 查看数据库返回数据数组
		JSONArray resultArray = service.checkTrain(departure, terminal,
				startDate.toString());
		JSONObject result = new JSONObject();
		
		if(resultArray!=null){
				result.put("status", "success");
				result.put("result", resultArray);
				System.out.println("查询成功！");
		}else{
			result.put("status","error");
			System.out.println("查询失败！");
		}
		resp.setContentType("text/html"); 
		PrintWriter out  = resp.getWriter();
		out.print(result.toString());
		
		out.flush();
		out.close();
	}
}
