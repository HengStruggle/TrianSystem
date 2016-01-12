package com.dbDesign.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.HashMap;

import net.sf.json.JSONArray;

import com.dbDesign.dao.ITicketInfoDao;
import com.dbDesign.dataBase.DBHelper;
import com.dbDesign.json.TicketInfo;
import com.dbDesign.util.SqlUtils;
import com.dbDesign.web.formbean.UserTicketInfoFormBean;

public class TicketInfoDaoImpl implements ITicketInfoDao {

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	@Override
	public JSONArray find(String username) {

		JSONArray orderArray = new JSONArray();

		try {
			conn = DBHelper.getConnection();
			String condition = MessageFormat.format(SqlUtils.WHERE_CONDITION,
					"username", SqlUtils.addQuot(username));
			String sql = MessageFormat.format(SqlUtils.SELECT_TABLE,
					"order_ticket" + condition);

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				String train_no = rs.getString("train_no");
				String seat_no = rs.getString("seat_no");
				String startdate = rs.getString("startdate");
				String starttime = rs.getString("starttime");
				int seatlevel = rs.getShort("seatlevel");
				int ticketprice = rs.getShort("ticketprice");

				HashMap<String, String> trainInfo = TrainInfoDaoImpl
						.findTrainInfo(train_no, starttime);
				if (trainInfo != null) {
					String departure = trainInfo.get("departure");
					String terminal = trainInfo.get("terminal");
					String arrivaltime = trainInfo.get("arrivaltime");
					System.out.println(departure + terminal + arrivaltime);

					orderArray.add(UserTicketInfoFormBean.fromJson(username,
							train_no, departure, terminal, startdate,
							starttime, arrivaltime, seat_no, seatlevel,
							ticketprice));
				}
			}
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return orderArray;
	}

	@Override
	public JSONArray findAll() {

		JSONArray orderArray = new JSONArray();

		try {
			conn = DBHelper.getConnection();

			String sql = MessageFormat.format(SqlUtils.SELECT_TABLE,
					"order_ticket");

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {

				String username = rs.getString("username");
				String train_no = rs.getString("train_no");
				String seat_no = rs.getString("seat_no");
				String startdate = rs.getString("startdate");
				String starttime = rs.getString("starttime");
				int seatlevel = rs.getShort("seatlevel");
				int ticketprice = rs.getShort("ticketprice");

				HashMap<String, String> trainInfo = TrainInfoDaoImpl
						.findTrainInfo(train_no, starttime);
				if (trainInfo != null) {
					String departure = trainInfo.get("departure");
					String terminal = trainInfo.get("terminal");
					String arrivaltime = trainInfo.get("arrivaltime");

					orderArray.add(UserTicketInfoFormBean.fromJson(username,
							train_no, departure, terminal, startdate,
							starttime, arrivaltime, seat_no, seatlevel,
							ticketprice));
				}
			}
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return orderArray;
	}

	@Override
	public boolean add(TicketInfo newTicketInfo) {

		boolean state = false;
		try {

			conn = DBHelper.getConnection();
			String values = SqlUtils.addQuot(newTicketInfo.getUserName())
					+ MessageFormat.format(SqlUtils.COMMA_VALUE,
							SqlUtils.addQuot(newTicketInfo.getTrainNo()))
					+ MessageFormat.format(SqlUtils.COMMA_VALUE,
							SqlUtils.addQuot(newTicketInfo.getSeatNo()))
					+ MessageFormat.format(SqlUtils.COMMA_VALUE,
							SqlUtils.addQuot(newTicketInfo.getStartDate()))
					+ MessageFormat.format(SqlUtils.COMMA_VALUE,
							SqlUtils.addQuot(newTicketInfo.getStartTime()))
					+ MessageFormat.format(SqlUtils.COMMA_VALUE,
							newTicketInfo.getSeatLevel())
					+ MessageFormat.format(SqlUtils.COMMA_VALUE,
							newTicketInfo.getTicketPrice());
			String sql = MessageFormat.format(SqlUtils.INSERT_TABLE,
					"order_ticket", values);

			int i = conn.prepareStatement(sql).executeUpdate();
			if (i > 0) {
				state = true;
			}
			System.out.println("添加订单成功");
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return state;
	}

	@Override
	public boolean delete(String userName, String trainNo, String startDate) {

		boolean state = false;
		try {
			conn = DBHelper.getConnection();

			String condition = MessageFormat.format(SqlUtils.SINGLE_CONDITION,
					"username", SqlUtils.addQuot(userName))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "train_no",
							SqlUtils.addQuot(trainNo))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "startdate",
							SqlUtils.addQuot(startDate));
			String sql = MessageFormat.format(SqlUtils.DELETE_TABLE,
					"order_ticket", condition);

			int i = conn.prepareStatement(sql).executeUpdate();
			if (i > 0) {
				state = true;
			}
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return state;
	}

}
