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
	 *分页显示订单信息 
	 */
	public List<Order> getOrderByPage(PageBean pb,Order condition){
		return orderDao.getOrderByPage(pb, condition);
	}
	
	/**
	 * 根据车次得到订单信息
	 */
	public List<Order> getOrderByTrainNum(String train_num){
		return orderDao.getOrderByTrainNum(train_num);
	}

	/**
	 * 购票（增加订单）
	 */
	public int addOrder(Order order){
		return orderDao.addOrder(order);
	}
	
	/**
	 * 退票（删除订单）
	 */
	public int deleteOrder(int order_id){
		return orderDao.deleteOrder(order_id);
	}
	
	/**
	 * 购票、退票（减少、增加座位数）
	 */
	public int updateTrain(int remainder,String train_num){
		return orderDao.updateTrain(remainder,train_num);
	}
	
	/**
	 * 根据车次号得到剩余票数
	 */
	public int getRemainderByTrainNum(String train_num){
		return orderDao.getRemainderByTrainNum(train_num);
	}
	
	/**
	 * 根据user_id得到订单信息
	 */
	public List<Order> getMyOrder(PageBean pb,Order condition,int user_id){
		return orderDao.getMyOrder(pb, condition, user_id);
	}
	
	/**
	 * 根据sql查询数据总条数
	 */
	public int getCountBySql(String sql){
		return orderDao.getCountBySql(sql);
	}
	
	/**
	 * 根据id得到对应订单信息
	 */
	public Order getOrderById(int id){
		return orderDao.getOrderById(id);
	}
}
