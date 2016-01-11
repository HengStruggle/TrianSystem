package com.dbDesign.service;

import com.dbDesign.json.TicketInfo;

import net.sf.json.JSONArray;

public interface ITicketInfoService {

	/**
	 * 提供用户查询订单服务
	 * 
	 * @param userName
	 * @return
	 */
	JSONArray userCheckTicket(String userName);

	/**
	 * 提供用户下订单服务
	 * 
	 * @param newTicket
	 * @return
	 */
	boolean userAddTicket(TicketInfo newTicket);

	/**
	 * 提供用户退票服务
	 * 
	 * @param delTicket
	 * @return
	 */
	boolean userDeleteTicket(TicketInfo delTicket);

	/**
	 * 提供用户改签车票功能。（只能改日期 车次 席别 ， 不可改站点、姓名）;
	 * 
	 * @param changeTicket
	 * @return
	 */
	boolean userUpdateTicket(TicketInfo changeTicket);

	/**
	 * 管理员功能：查看所有用户订单。
	 * 
	 * @return
	 */
	JSONArray checkAllTicket();
}
