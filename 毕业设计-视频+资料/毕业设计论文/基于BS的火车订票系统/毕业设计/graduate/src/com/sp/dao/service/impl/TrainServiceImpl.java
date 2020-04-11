package com.sp.dao.service.impl;

import java.util.List;

import com.sp.common.PageBean;
import com.sp.dao.TrainDao;
import com.sp.dao.impl.TrainDaoImpl;
import com.sp.dao.service.TrainService;
import com.sp.entity.Order;
import com.sp.entity.Train;

public class TrainServiceImpl implements TrainService {
	
	TrainDao trainDao = new TrainDaoImpl();
	/**
	 * 分页显示车次信息
	 */
	public List<Train> getTrainByPage(PageBean pb,Train condition){
		return trainDao.getTrainByPage(pb, condition);
	}
	
	/**
	 * 分页显示预购车次信息
	 */
	public List<Train> getTrainsByPage(PageBean pb,Order condition){
		return trainDao.getTrainsByPage(pb, condition);
	}
	
	/**
	 * 根据sql查询数据总条数
	 */
	public int getCountBySql(String sql){
		return trainDao.getCountBySql(sql);
	}
	
	/**
	 * 根据车次得到车次对象
	 */
	public Train getTrain(String train_num){
		return trainDao.getTrain(train_num);
	}
	
	/**
	 * 删除车次信息
	 */
	public int deleteTrain(String train_num){
		return trainDao.deleteTrain(train_num);
	}
	
	/**
	 * 修改车次信息
	 */
 	public int updateTrain(Train train,String trainNum){
 		return trainDao.updateTrain(train,trainNum);
 	}
 	
 	/**
	 * 增加车次
	 */
	public int addTrain(Train train){
		return trainDao.addTrain(train);
	}
}
