package com.sp.dao.service.impl;

import java.util.List;

import com.sp.common.PageBean;
import com.sp.dao.OrderDao;
import com.sp.dao.impl.OrderDaoImpl;
import com.sp.dao.service.OrderService;
import com.sp.entity.Order;

public class OrderServiceImpl implements OrderService {

	
	OrderDao orderDao = new OrderDaoImpl();

	/**
	 *��ҳ��ʾ������Ϣ 
	 */
	public List<Order> getOrderByPage(PageBean pb,Order condition){
		return orderDao.getOrderByPage(pb, condition);
	}
	
	/**
	 * ���ݳ��εõ�������Ϣ
	 */
	public List<Order> getOrderByTrainNum(String train_num){
		return orderDao.getOrderByTrainNum(train_num);
	}

	/**
	 * ��Ʊ�����Ӷ�����
	 */
	public int addOrder(Order order){
		return orderDao.addOrder(order);
	}
	
	/**
	 * ��Ʊ��ɾ��������
	 */
	public int deleteOrder(int order_id){
		return orderDao.deleteOrder(order_id);
	}
	
	/**
	 * ��Ʊ����Ʊ�����١�������λ����
	 */
	public int updateTrain(int remainder,String train_num){
		return orderDao.updateTrain(remainder,train_num);
	}
	
	/**
	 * ���ݳ��κŵõ�ʣ��Ʊ��
	 */
	public int getRemainderByTrainNum(String train_num){
		return orderDao.getRemainderByTrainNum(train_num);
	}
	
	/**
	 * ����user_id�õ�������Ϣ
	 */
	public List<Order> getMyOrder(PageBean pb,Order condition,int user_id){
		return orderDao.getMyOrder(pb, condition, user_id);
	}
	
	/**
	 * ����sql��ѯ����������
	 */
	public int getCountBySql(String sql){
		return orderDao.getCountBySql(sql);
	}
	
	/**
	 * ����id�õ���Ӧ������Ϣ
	 */
	public Order getOrderById(int id){
		return orderDao.getOrderById(id);
	}
}
