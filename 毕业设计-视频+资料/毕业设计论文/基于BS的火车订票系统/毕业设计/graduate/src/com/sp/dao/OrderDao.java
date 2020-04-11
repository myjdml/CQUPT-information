package com.sp.dao;

import java.util.List;

import com.sp.common.PageBean;
import com.sp.entity.Order;
import com.sp.entity.Train;
import com.sp.entity.User;

public interface OrderDao {
	
	/**
	 *��ҳ��ʾ������Ϣ 
	 */
	public List<Order> getOrderByPage(PageBean pb,Order condition);
	
	/**
	 * ���ݳ��εõ�������Ϣ
	 */
	public List<Order> getOrderByTrainNum(String train_num);
	
	/**
	 * ��Ʊ�����Ӷ�����
	 */
	public int addOrder(Order order);
	
	/**
	 * ��Ʊ��ɾ��������
	 */
	public int deleteOrder(int order_id);
	
	/**
	 * ��Ʊ����Ʊ�����١�������Ʊ����
	 */
	public int updateTrain(int remainder,String train_num);
	
	/**
	 * ���ݳ��κŵõ�ʣ��Ʊ��
	 */
	public int getRemainderByTrainNum(String train_num);
	
	/**
	 * ����user_id�õ�������Ϣ
	 */
	public List<Order> getMyOrder(PageBean pb,Order condition,int user_id);
	
	
	/**
	 * ����sql��ѯ����������
	 */
	public int getCountBySql(String sql);
	
	/**
	 * ����id�õ���Ӧ������Ϣ
	 */
	public Order getOrderById(int id);
}
