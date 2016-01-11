package com.dbDesign.json;

import net.sf.json.JSONObject;

public class TrainInfo {
	private String trainNo;
	private String departure;
	private String terminal;
	private String startTime;
	private String arrivalTime;

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getdeparture() {
		return departure;
	}

	public void setdeparture(String departure) {
		this.departure = departure;
	}

	public String getterminal() {
		return terminal;
	}

	public void setterminal(String terminal) {
		this.terminal = terminal;
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

	public static JSONObject fromJson(String trainNo, String departure,
			String terminal, String startTime, String arrivalTime) {
		JSONObject trainJson = new JSONObject();
		trainJson.put("trainNo", trainNo);
		trainJson.put("departure", departure);
		trainJson.put("terminal", terminal);
		trainJson.put("startTime", startTime);
		trainJson.put("arrivalTime", arrivalTime);
		return trainJson;
	}
}
