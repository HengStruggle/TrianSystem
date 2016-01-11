package com.dbDesign.json;

import net.sf.json.JSONObject;

public class User {
	private String userName;
	private String password;
	private String role;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public static JSONObject fromJson(String userName, String password,
			String role) {
		JSONObject userJson = new JSONObject();
		userJson.put("userName", userName);
		userJson.put("password", password);
		userJson.put("role", role);
		return userJson;
	}
}
