package com.dbDesign.web.formbean;

import net.sf.json.JSONObject;

/**
 * 封装train对象以及seat对象，组成用户查询余票时的各车次信息<br>
 * <br>
 * 车次、始发站、终点站、发车时间、到达时间 、 商务座余票、<br>
 * 商务座票价、一等座余票、一等座票价、二等座余票、二等座票价）<br>
 * <br>
 * 
 * 也作为管理员修改车次信息时提交的表单
 */
public class TrianSeatFormBean {

	private String train_no;
	private String departure;
	private String terminal;
	private String startDate;
	private String startTime;
	private String arrivalTime;

	private int business_sum;
	private int business_price;
	private int first_sum;
	private int first_price;
	private int second_sum;
	private int second_price;

	public static JSONObject fromJson(String train_no, String departure,
			String terminal, String startDate, String startTime,
			String arrivalTime, int business_sum, int business_price,
			int first_sum, int first_price, int second_sum, int second_price) {
		JSONObject result = new JSONObject();
		result.put("train_no", train_no);
		result.put("departure", departure);
		result.put("terminal", terminal);
		result.put("startDate", startDate);
		result.put("startTime", startTime);
		result.put("arrivalTime", arrivalTime);
		result.put("business_sum", business_sum);
		result.put("business_price", business_price);
		result.put("first_sum", first_sum);
		result.put("first_price", first_price);
		result.put("second_sum", second_sum);
		result.put("second_price", second_price);
		return result;

	}

	public String getTrain_no() {
		return train_no;
	}

	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public int getBusiness_sum() {
		return business_sum;
	}

	public void setBusiness_sum(int business_sum) {
		this.business_sum = business_sum;
	}

	public int getBusiness_price() {
		return business_price;
	}

	public void setBusiness_price(int business_price) {
		this.business_price = business_price;
	}

	public int getFirst_sum() {
		return first_sum;
	}

	public void setFirst_sum(int first_sum) {
		this.first_sum = first_sum;
	}

	public int getFirst_price() {
		return first_price;
	}

	public void setFirst_price(int first_price) {
		this.first_price = first_price;
	}

	public int getSecond_sum() {
		return second_sum;
	}

	public void setSecond_sum(int second_sum) {
		this.second_sum = second_sum;
	}

	public int getSecond_price() {
		return second_price;
	}

	public void setSecond_price(int second_price) {
		this.second_price = second_price;
	}

}
