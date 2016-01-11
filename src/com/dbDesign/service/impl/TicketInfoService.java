package com.dbDesign.service.impl;

import net.sf.json.JSONArray;

import com.dbDesign.dao.ITicketInfoDao;
import com.dbDesign.dao.impl.TicketInfoDaoImpl;
import com.dbDesign.json.TicketInfo;
import com.dbDesign.service.ITicketInfoService;

public class TicketInfoService implements ITicketInfoService {

	@Override
	public JSONArray userCheckTicket(String userName) {
		// TODO Auto-generated method stub

		ITicketInfoDao ticketInfo = new TicketInfoDaoImpl();
		return ticketInfo.find(userName);
	}

	@Override
	public boolean userAddTicket(TicketInfo newTicket) {
		// TODO Auto-generated method stub

		ITicketInfoDao ticketInfo = new TicketInfoDaoImpl();
		return ticketInfo.add(newTicket);
	}

	@Override
	public boolean userDeleteTicket(TicketInfo delTicket) {
		// TODO Auto-generated method stub
		ITicketInfoDao ticketInfo = new TicketInfoDaoImpl();
		return ticketInfo.delete(delTicket.getUserName(),
				delTicket.getTrainNo(), delTicket.getStartDate());
	}

	@Override
	public boolean userUpdateTicket(TicketInfo changeTicket) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JSONArray checkAllTicket() {
		// TODO Auto-generated method stub
		ITicketInfoDao ticketInfo = new TicketInfoDaoImpl();
		return ticketInfo.findAll();
	}

}
