package com.dbDesign.service;

import com.dbDesign.json.SeatInfo;

public interface ISeatInfoService {

	/**
	 * 提供分配座位服务
	 * 
	 * @param trainNo
	 * @param startDate
	 * @param seatLevel
	 * @return
	 */
	SeatInfo allocSeat(String trainNo, String startDate, int seatLevel);

	/**
	 * 提供占用座位服务
	 * 
	 * @param trainNo
	 * @param startDate
	 * @param seatLevel
	 * @return
	 */
	boolean useSeat(String trainNo, String seatNo, String startDate);

	/**
	 * 提供回收座位服务
	 * 
	 * @param trainNo
	 * @param startDate
	 * @param seatLevel
	 * @return
	 */
	boolean freeSeat(String trainNo, String seatNo, String startDate);

}
