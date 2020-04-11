package com.sp.dao.service;

import java.util.List;

import com.sp.common.PageBean;
import com.sp.entity.Order;
import com.sp.entity.Train;

public interface TrainService {
	/**
	 * ��ҳ��ʾ������Ϣ
	 */
	public List<Train> getTrainByPage(PageBean pb,Train condition);
	
	/**
	 * ��ҳ��ʾԤ��������Ϣ
	 */
	public List<Train> getTrainsByPage(PageBean pb,Order condition);
	
	/**
	 * ����sql��ѯ����������
	 */
	public int getCountBySql(String sql);
	
	/**
	 * ���ݳ��εõ����ζ���
	 */
	public Train getTrain(String train_num);
	
	/**
	 * ɾ��������Ϣ
	 */
	public int deleteTrain(String train_num);
	/**
	 * �޸ĳ�����Ϣ
	 */
 	public int updateTrain(Train train,String trainNum);
 	/**
	 * ���ӳ���
	 */
	public int addTrain(Train train);
}
