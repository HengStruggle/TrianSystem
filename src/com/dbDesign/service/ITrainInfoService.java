package com.dbDesign.service;

import com.dbDesign.json.TrainInfo;

import net.sf.json.JSONArray;

public interface ITrainInfoService {

	/**
	 * 提供查询车次服务（用户必须输入始发站、终点站、出发日期）<br>
	 * <br>
	 * 
	 * @param departure
	 * @param terminal
	 * @param startTime
	 * @return
	 */
	JSONArray checkTrain(String departure, String terminal, String startTime);

	/**
	 * 管理员功能：增加车次
	 * 
	 * @param newTrain
	 *            车次信息
	 * @return
	 */
	boolean addTrain(TrainInfo newTrain);

	/**
	 * 管理员功能：删除车次
	 * 
	 * @param delTrain
	 *            车次信息
	 * @return
	 */
	boolean deleteTrain(TrainInfo delTrain);

	/**
	 * 管理员功能：修改车次信息
	 * 
	 * @param updateTrain
	 * @return
	 */
	boolean updateTrain(TrainInfo updateTrain);

	/**
	 * 管理员功能：查看所有车次
	 * 
	 * @return
	 */
	JSONArray checkAllTrain();

	/**
	 * 管理员功能：查看某天所有车次
	 * 
	 * @param startDate
	 * @return
	 */
	JSONArray checkAllTrain(String startDate);

}
