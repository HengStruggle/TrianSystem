package com.dbDesign.service.impl;

import com.dbDesign.dao.ISeatInfoDao;
import com.dbDesign.dao.impl.SeatInfoDaoImpl;
import com.dbDesign.json.SeatInfo;
import com.dbDesign.service.ISeatInfoService;

public class SeatInfoService implements ISeatInfoService {

	@Override
	public SeatInfo allocSeat(String trainNo, String startDate, int seatLevel) {

		ISeatInfoDao seatInfo = new SeatInfoDaoImpl();
		return seatInfo.find(trainNo, startDate, seatLevel);
	}

	@Override
	public boolean useSeat(String trainNo, String seatNo, String startDate) {

		ISeatInfoDao seatInfo = new SeatInfoDaoImpl();
		return seatInfo.update(trainNo, seatNo, startDate, true);
	}

	@Override
	public boolean freeSeat(String trainNo, String seatNo, String startDate) {

		ISeatInfoDao seatInfo = new SeatInfoDaoImpl();
		return seatInfo.update(trainNo, seatNo, startDate, false);
	}

}
