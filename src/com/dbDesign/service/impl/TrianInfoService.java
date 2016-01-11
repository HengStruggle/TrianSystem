package com.dbDesign.service.impl;

import net.sf.json.JSONArray;

import com.dbDesign.dao.ITrainInfoDao;
import com.dbDesign.dao.impl.TrainInfoDaoImpl;
import com.dbDesign.json.TrainInfo;
import com.dbDesign.service.ITrainInfoService;

public class TrianInfoService implements ITrainInfoService {

	@Override
	public JSONArray checkTrain(String departure, String terminal,
			String StartTime) {

		ITrainInfoDao trainInfo = new TrainInfoDaoImpl();
		return trainInfo.find(departure, terminal, StartTime);
	}

	@Override
	public boolean addTrain(TrainInfo newTrain) {

		ITrainInfoDao trainInfo = new TrainInfoDaoImpl();
		return trainInfo.add(newTrain);
	}

	@Override
	public boolean deleteTrain(TrainInfo delTrain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateTrain(TrainInfo updateTrain) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public JSONArray checkAllTrain() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public JSONArray checkAllTrain(String startDate) {
		// TODO Auto-generated method stub
		return null;
	}

}
