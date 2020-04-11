package com.sp.dao.service;

import java.util.List;

import com.sp.common.PageBean;
import com.sp.entity.Order;
import com.sp.entity.Train;

public interface TrainService {
	/**
	 * 分页显示车次信息
	 */
	public List<Train> getTrainByPage(PageBean pb,Train condition);
	
	/**
	 * 分页显示预购车次信息
	 */
	public List<Train> getTrainsByPage(PageBean pb,Order condition);
	
	/**
	 * 根据sql查询数据总条数
	 */
	public int getCountBySql(String sql);
	
	/**
	 * 根据车次得到车次对象
	 */
	public Train getTrain(String train_num);
	
	/**
	 * 删除车次信息
	 */
	public int deleteTrain(String train_num);
	/**
	 * 修改车次信息
	 */
 	public int updateTrain(Train train,String trainNum);
 	/**
	 * 增加车次
	 */
	public int addTrain(Train train);
}
