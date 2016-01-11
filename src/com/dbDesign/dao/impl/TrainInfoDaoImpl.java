package com.dbDesign.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.HashMap;

import net.sf.json.JSONArray;

import com.dbDesign.dao.ITrainInfoDao;
import com.dbDesign.dataBase.DBHelper;
import com.dbDesign.json.TrainInfo;
import com.dbDesign.util.SqlUtils;
import com.dbDesign.web.formbean.TrianSeatFormBean;

public class TrainInfoDaoImpl implements ITrainInfoDao {

	private static Connection conn = null;
	private static PreparedStatement ps = null;
	private static ResultSet rs = null;

	@Override
	public JSONArray find(String departure, String terminal, String startDate) {

		JSONArray trainArray = new JSONArray();
		// HashMap<String, Integer> trainSeatInfo = new HashMap<String,
		// Integer>();
		HashMap<String, Integer> trainSeatInfo = null;
		SeatInfoDaoImpl seatInfo = new SeatInfoDaoImpl();
		boolean state = false;

		try {
			conn = DBHelper.getConnection();
			// //contion = departure = "departure" and terminal = "terminal"
			// String contion = MessageFormat.format(SqlUtils.SINGLE_CONDITION,
			// "departure", SqlUtils.addQuot(departure))
			// + MessageFormat.format(SqlUtils.AND_CONDITION, "terminal",
			// SqlUtils.addQuot(terminal));
			// //sql = select * from train where contion
			// String sql = MessageFormat.format(SqlUtils.SELECT_TABLE, "train",
			// contion);
			String train_no, startTime, arrivalTime;
			String temp = "select t1.train_no , t1.starttime , t2.arrivaltime from train t1 , train t2 where t1.train_no = t2.train_no and t1.departure = {0} and t2.terminal = {1}";
			String sql = MessageFormat.format(temp,
					SqlUtils.addQuot(departure), SqlUtils.addQuot(terminal));

			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				state = true;

				train_no = rs.getString(1);
				startTime = rs.getString(2);
				arrivalTime = rs.getString(3);

				trainSeatInfo = seatInfo.getSeatInfo(train_no, startDate);
				// int at = 0;
				// temp =
				// "select count(*) , ticketPrice from seat where train_no = {0} and startdate = {1} and seatlevel = {2} and isused = 0 ";
				// while(at<3){
				// sql = MessageFormat.format(temp,
				// SqlUtils.addQuot(train_no),SqlUtils.addQuot(startDate),at);
				//
				// //PreparedStatement pst = conn.prepareStatement(sql);
				// ResultSet rst = conn.createStatement().executeQuery(sql);
				// while(rst.next()){
				// if(at == 0){
				// trainSeatInfo.put("business_sum",rst.getInt(1));
				// trainSeatInfo.put("business_price",rst.getInt(2));
				// }else if(at == 1){
				// trainSeatInfo.put("first_sum", rst.getInt(1));
				// trainSeatInfo.put("first_price", rst.getInt(2));
				// }else{
				// trainSeatInfo.put("second_sum", rst.getInt(1));
				// trainSeatInfo.put("second_price", rst.getInt(2));
				// }
				// }
				// at++;
				// }

				trainArray.add(TrianSeatFormBean.fromJson(train_no, departure,
						terminal, startDate, startTime, arrivalTime,
						trainSeatInfo.get("business_sum"),
						trainSeatInfo.get("business_price"),
						trainSeatInfo.get("first_sum"),
						trainSeatInfo.get("first_price"),
						trainSeatInfo.get("second_sum"),
						trainSeatInfo.get("second_price")));
			}
		} catch (Exception e) {
			new RuntimeException(e);
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		if (state == false)
			return null;
		return trainArray;
	}

	@Override
	public boolean add(TrainInfo newTrain) {

		boolean state = false;
		try {

			String trainNo = newTrain.getTrainNo();
			String departure = newTrain.getdeparture();
			String terminal = newTrain.getterminal();
			String startTime = newTrain.getStartTime();
			String arrivalTime = newTrain.getArrivalTime();

			String values = SqlUtils.addQuot(trainNo) + ","
					+ SqlUtils.addQuot(departure) + ","
					+ SqlUtils.addQuot(terminal) + ","
					+ SqlUtils.addQuot(startTime) + ","
					+ SqlUtils.addQuot(arrivalTime);
			String sql = MessageFormat.format(SqlUtils.INSERT_TABLE, "train",
					values);
			System.out.println(sql);

			conn = DBHelper.getConnection();
			int i = conn.prepareStatement(sql).executeUpdate();
			if (i > 0) {
				state = true;
			}
			System.out.println("添加车次成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBHelper.release(conn, ps, rs);
		}
		return state;
	}

	@Override
	public boolean delete(TrainInfo delTrain) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static HashMap<String, String> findTrainInfo(String train_no , String starttime){
		
		HashMap<String, String> trainInfo = new HashMap<String, String>();
		
		try{
			conn = DBHelper.getConnection();
			String condition = MessageFormat.format(SqlUtils.WHERE_CONDITION, "train_no",SqlUtils.addQuot(train_no))
					+MessageFormat.format(SqlUtils.AND_CONDITION, "starttime",SqlUtils.addQuot(starttime));
			String sql = MessageFormat.format(SqlUtils.SELECT_TABLE , "train "+condition);
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if(rs.next()){
				trainInfo.put("departure", rs.getString("departure"));
				trainInfo.put("terminal",rs.getString("terminal"));
				trainInfo.put("arrivaltime",rs.getString("arrivaltime"));
			}else{
				trainInfo = null;
			}			
		}catch(Exception e){
			new RuntimeException(e);
		}finally{
			DBHelper.release(conn, ps, rs);			
		}
		return trainInfo;
	}
}
