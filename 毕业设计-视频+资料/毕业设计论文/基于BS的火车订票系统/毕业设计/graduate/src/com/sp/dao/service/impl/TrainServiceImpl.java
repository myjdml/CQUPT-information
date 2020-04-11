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
	 * ��ҳ��ʾ������Ϣ
	 */
	public List<Train> getTrainByPage(PageBean pb,Train condition){
		return trainDao.getTrainByPage(pb, condition);
	}
	
	/**
	 * ��ҳ��ʾԤ��������Ϣ
	 */
	public List<Train> getTrainsByPage(PageBean pb,Order condition){
		return trainDao.getTrainsByPage(pb, condition);
	}
	
	/**
	 * ����sql��ѯ����������
	 */
	public int getCountBySql(String sql){
		return trainDao.getCountBySql(sql);
	}
	
	/**
	 * ���ݳ��εõ����ζ���
	 */
	public Train getTrain(String train_num){
		return trainDao.getTrain(train_num);
	}
	
	/**
	 * ɾ��������Ϣ
	 */
	public int deleteTrain(String train_num){
		return trainDao.deleteTrain(train_num);
	}
	
	/**
	 * �޸ĳ�����Ϣ
	 */
 	public int updateTrain(Train train,String trainNum){
 		return trainDao.updateTrain(train,trainNum);
 	}
 	
 	/**
	 * ���ӳ���
	 */
	public int addTrain(Train train){
		return trainDao.addTrain(train);
	}
}
