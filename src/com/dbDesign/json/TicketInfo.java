package com.dbDesign.json;

import net.sf.json.JSONObject;

public class TicketInfo {

	private String UserName;
	private String trainNo;
	private String seatNo;
	private String startDate;
	private String startTime;
	private int seatLevel;
	private int ticketPrice;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(String seatNo) {
		this.seatNo = seatNo;
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

	public int getSeatLevel() {
		return seatLevel;
	}

	public void setSeatLevel(int seatLevel) {
		this.seatLevel = seatLevel;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public static JSONObject fromJson(String userName, String trainNo,
			String seatNo, String startDate, String startTime, int seatLevel,
			int ticketPrice) {
		JSONObject ticketJson = new JSONObject();
		ticketJson.put("username", userName);
		ticketJson.put("train_no", trainNo);
		ticketJson.put("seat_no", seatNo);
		ticketJson.put("startdate", startDate);
		ticketJson.put("starttime", startTime);
		ticketJson.put("seatlevel", seatLevel);
		ticketJson.put("ticketprice", ticketPrice);
		return ticketJson;
	}
}
