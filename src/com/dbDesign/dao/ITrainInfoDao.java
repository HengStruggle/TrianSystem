package com.dbDesign.dao;

import net.sf.json.JSONArray;

import com.dbDesign.json.TrainInfo;

public interface ITrainInfoDao {

	/**
	 * 根据始发站、终点站和发车时间查找到的车次<br>
	 * <br>
	 * 
	 * 实现思路：通过Departure和terminal在train表查找到车次train_no,需要自身连接一次<br>
	 * <span style= "width:60px "> &nbsp; </span>
	 * 后根据startTime和train_no在seat表中找到其余信息<br>
	 * <span style= "width:60px "> &nbsp; </span>
	 * 将所有信息封装为trainSeatFormBean对象的JSON数组<br>
	 * 
	 * @param stationFirst
	 * @param stationEnd
	 * @param StartDate
	 * @return 查找到的车次
	 */
	JSONArray find(String departure, String terminal, String StartDate);

	/**
	 * 添加车次
	 * 
	 * @param newTrain
	 */
	boolean add(TrainInfo newTrain);

	/**
	 * 删除车次
	 * 
	 * @param delTrain
	 * @return
	 */
	boolean delete(TrainInfo delTrain);

}
