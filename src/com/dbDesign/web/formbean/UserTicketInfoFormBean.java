package com.dbDesign.web.formbean;

import net.sf.json.JSONObject;

public class UserTicketInfoFormBean {
	
	private String username;
	private String train_no;
	private String departure;
	private String terminal;
	private String startdate;
	private String starttime;
	private String arrivaltime;
	private String seat_no;
	private int seatlevel;
	private int ticketprice;
	
	public int getTicketprice() {
		return ticketprice;
	}

	public void setTicketprice(int ticketprice) {
		this.ticketprice = ticketprice;
	}

	public int getSeatlevel() {
		return seatlevel;
	}

	public void setSeatlevel(int seatlevel) {
		this.seatlevel = seatlevel;
	}

	public String getSeat_no() {
		return seat_no;
	}

	public void setSeat_no(String seat_no) {
		this.seat_no = seat_no;
	}

	public String getArrivaltime() {
		return arrivaltime;
	}

	public void setArrivaltime(String arrivaltime) {
		this.arrivaltime = arrivaltime;
	}

	public String getStarttime() {
		return starttime;
	}

	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getTerminal() {
		return terminal;
	}

	public void setTerminal(String terminal) {
		this.terminal = terminal;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getTrain_no() {
		return train_no;
	}

	public void setTrain_no(String train_no) {
		this.train_no = train_no;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public static JSONObject fromJson(String username,String train_no,
			String departure,String terminal,String startdate,
			String starttime,String arrivaltime,String seat_no,
			int seatlevel, int ticketprice){
		JSONObject userTicketInfoJson = new JSONObject();
		
		userTicketInfoJson.put("username", username);
		userTicketInfoJson.put("train_no", train_no);
		userTicketInfoJson.put("departure", departure);
		userTicketInfoJson.put("terminal", terminal);
		userTicketInfoJson.put("startdate", startdate);
		userTicketInfoJson.put("starttime", starttime);
		userTicketInfoJson.put("arrivaltime", arrivaltime);
		userTicketInfoJson.put("seat_no", seat_no);
		userTicketInfoJson.put("seatlevel", seatlevel);
		userTicketInfoJson.put("ticketprice", ticketprice);
		
		return userTicketInfoJson;
	}
	
}
