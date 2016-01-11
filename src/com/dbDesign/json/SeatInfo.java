package com.dbDesign.json;

import java.sql.Date;

import net.sf.json.JSONObject;

public class SeatInfo {

	private String trainNo;
	private String seatNo;
	private String startDate;
	private int ticketPrice;
	private int seatLevel;
	private boolean isUsed;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

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

	public int getSeatLevel() {
		return seatLevel;
	}

	public void setSeatLevel(int seatLevel) {
		this.seatLevel = seatLevel;
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public static JSONObject fromJson(String trainNo, String seatNo,
			Date startDate, int seatLevel, int ticketPrice, boolean isUsed) {
		JSONObject seatJson = new JSONObject();
		seatJson.put("trainNo", trainNo);
		seatJson.put("seatNo", seatNo);
		seatJson.put("startDate", startDate);
		seatJson.put("seatLevel", seatLevel);
		seatJson.put("isUsed", isUsed);
		return seatJson;
	}

	public int getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(int ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
}
