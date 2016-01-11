package com.dbDesign.dao;

import net.sf.json.JSONArray;

import com.dbDesign.json.TicketInfo;

public interface ITicketInfoDao {

	/**
	 * 根据用户名来查找订票信息
	 * 
	 * @param userName
	 * @return 查找到的订票信息
	 */
	JSONArray find(String userName);

	/**
	 * 查找所有用户订票消息
	 * 
	 * @return
	 */
	JSONArray findAll();

	/**
	 * 添加订票事件
	 * 
	 * @param newTicketInfo
	 * @return 添加成功或失败
	 */
	boolean add(TicketInfo newTicketInfo);

	/**
	 * 根据用户名和车次和出发日期删除订票信息
	 * 
	 * @param userName
	 * @param trainNo
	 * @return 删除成功或失败
	 */
	boolean delete(String userName, String trainNo, String startDate);
}
