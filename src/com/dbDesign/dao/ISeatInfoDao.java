package com.dbDesign.dao;

import com.dbDesign.json.SeatInfo;

public interface ISeatInfoDao {

	/**
	 * 根据车次 发车日期 座位等级 查找一个空座位
	 * 
	 * @param trainNo
	 * @param startDate
	 * @param seatLevel
	 * @return
	 */
	SeatInfo find(String trainNo, String startDate, int seatLevel);

	/**
	 * 更新座位占用标志
	 * 
	 * @param trainNo
	 * @param seatNo
	 * @param startDate
	 * @param flag
	 *            标识下单还是退票
	 * @return
	 */
	boolean update(String trainNo, String seatNo, String startDate,
			boolean isOrder);

}
