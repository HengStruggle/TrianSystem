package com.dbDesign.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.HashMap;

import com.dbDesign.dao.ISeatInfoDao;
import com.dbDesign.dataBase.DBHelper;
import com.dbDesign.json.SeatInfo;
import com.dbDesign.util.SqlUtils;

public class SeatInfoDaoImpl implements ISeatInfoDao {

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	@Override
	public SeatInfo find(String trainNo, String startDate, int seatLevel) {
		// TODO Auto-generated method stub

		SeatInfo seatInfo = null;
		String cc;

		try {

			conn = DBHelper.getConnection();

			if (seatLevel == 0) {
				cc = "A";
			} else if (seatLevel == 1) {
				cc = "B";
			} else {
				cc = "C";
			}

			String condition = MessageFormat.format(SqlUtils.LIKE_CONDITON,
					"seat_no", SqlUtils.addQuot(cc + "%"))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "train_no",
							SqlUtils.addQuot(trainNo))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "startdate",
							SqlUtils.addQuot(startDate))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "seatlevel",
							seatLevel)
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "isused", 0);
			String sql = MessageFormat.format(SqlUtils.SELECT_TABLE,
					"seat where " + condition);

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			if (rs.next()) {
				seatInfo = new SeatInfo();
				seatInfo.setTrainNo(trainNo);
				seatInfo.setSeatNo(rs.getString("seat_no"));
				seatInfo.setStartDate(startDate);
				seatInfo.setSeatLevel(seatLevel);
				seatInfo.setUsed(false);
				seatInfo.setTicketPrice(rs.getShort("ticketprice"));

				System.out.println("座位分配成功");
			}

		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}

		return seatInfo;
	}

	/**
	 * 根据车次与出发日期得到各席位的余票与价格
	 * 
	 * @param train_no
	 * @param startDate
	 * @return
	 */
	public HashMap<String, Integer> getSeatInfo(String train_no,
			String startDate) {
		boolean state = false;
		HashMap<String, Integer> result = new HashMap<String, Integer>();
		try {
			conn = DBHelper.getConnection();
			String sql;
			int at = 0;
			String temp = "select count(*) , ticketPrice from seat where train_no = {0} and startdate = {1} and seatlevel = {2} and isused = 0 ;";

			while (at < 3) {
				sql = MessageFormat.format(temp, SqlUtils.addQuot(train_no),
						SqlUtils.addQuot(startDate), at);

				ps = conn.prepareStatement(sql);
				rs = ps.executeQuery();
				while (rs.next()) {
					if (rs.getInt(1) > 0) {
						state = true;
						if (at == 0) {
							result.put("business_sum", rs.getInt(1));
							result.put("business_price", rs.getInt(2));
						} else if (at == 1) {
							result.put("first_sum", rs.getInt(1));
							result.put("first_price", rs.getInt(2));
						} else {
							result.put("second_sum", rs.getInt(1));
							result.put("second_price", rs.getInt(2));
						}
					}
				}
				at++;
			}
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		if (state == false)
			result = null;
		return result;
	}

	@Override
	public boolean update(String trainNo, String seatNo, String startDate,
			boolean isOrder) {

		boolean state = false;
		int isUsed;

		if (isOrder == true) {
			isUsed = 1;
		} else {
			isUsed = 0;
		}
		try {

			conn = DBHelper.getConnection();

			String newValue = MessageFormat.format(SqlUtils.SINGLE_CONDITION,
					"isused", isUsed);
			String condition = MessageFormat.format(SqlUtils.SINGLE_CONDITION,
					"train_no", SqlUtils.addQuot(trainNo))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "startdate",
							SqlUtils.addQuot(startDate))
					+ MessageFormat.format(SqlUtils.AND_CONDITION, "seat_no",
							SqlUtils.addQuot(seatNo));
			String sql = MessageFormat.format(SqlUtils.UPDATE_TABLE, "seat",
					newValue, condition);

			int i = conn.prepareCall(sql).executeUpdate();
			if (i > 0) {
				state = true;
				System.out.println("更改座位状态成功！");
			}

		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}

		return state;
	}

}
