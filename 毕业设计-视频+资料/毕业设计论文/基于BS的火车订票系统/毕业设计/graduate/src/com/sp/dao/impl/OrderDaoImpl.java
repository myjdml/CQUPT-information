package com.sp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.common.PageBean;
import com.sp.dao.BaseDao;
import com.sp.dao.OrderDao;
import com.sp.entity.Order;
import com.sp.entity.Train;
import com.sp.entity.User;

public class OrderDaoImpl extends BaseDao implements OrderDao {

	
	/**
	 *��ҳ��ʾ������Ϣ 
	 */
	public List<Order> getOrderByPage(PageBean pb,Order condition){
		String conditionSql = "";
		String sql = "select t2.* from(select t1.* from orders t1 where 1=1 ";
		if(condition!=null){
			if(condition.getTrain_num() !=null && !"".equals(condition.getTrain_num().trim())){
				conditionSql += "and train_num like '%"+condition.getTrain_num() +"%' ";
			}
		}
		sql += conditionSql;
		sql += ")t2 LIMIT ?,? ";
		
		List<Order> list = getOrderBySql(sql,(pb.getCurrentPage()-1)*pb.getPageSize(), pb.getPageSize());  
		
		String countSql = "select count(*) from orders where 1=1"; //1=1Ϊ��ƴ��sql
		countSql += conditionSql;
		pb.setTotalCount(getCountBySql(countSql));
		return list;
	}
	
	
	/**
	 * ���ݳ��εõ�������Ϣ
	 */
	public List<Order> getOrderByTrainNum(String train_num){
		String sql = "select * from orders where train_num=?";
		List<Order> list = getOrderBySql(sql, train_num);
		return list;
	}
	
	/**
	 * ��Ʊ�����Ӷ�����
	 */
	public int addOrder(Order order){
		String sql="insert into orders(user_id,train_num,g_time,order_time,origin,terminus,leavetime,a_time,price) values(?,?,?,SYSDATE(),?,?,?,?,?)";
		return updateBySql(sql, order.getUser_id(),order.getTrain_num(),order.getG_time(),
				order.getOrigin(),order.getTerminus(),order.getLeaveTime(),order.getA_time(),order.getPrice());
	}
	
	/**
	 * ��Ʊ��ɾ��������
	 */
	public int deleteOrder(int order_id){
		String sql = "delete from orders where id =?";
		return updateBySql(sql, order_id);
	}
	
	/**
	 * ��Ʊ����Ʊ�����١�������λ����
	 */
	public int updateTrain(int remainder,String train_num){
		String sql = "update train set remainder=? where train_num=?";
		return updateBySql(sql, remainder,train_num);
	}
	
	/**
	 * ���ݳ��κŵõ�ʣ��Ʊ��
	 */
	public int getRemainderByTrainNum(String train_num){
		String sql = "select remainder from train where train_num=? ";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn=getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, train_num);
			rs = ps.executeQuery();
			if(rs.next()){
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeResourse(rs, ps, conn);
		}
		return result;
	}
	
	/**
	 * ����user_id�õ�������Ϣ
	 */
	public List<Order> getMyOrder(PageBean pb,Order condition,int user_id){
		String conditionSql = "";
		String sql = "select t2.* from ( select t1.* from orders t1 where user_id=? ";
		if(condition!=null){
			if(condition.getTrain_num() !=null && !"".equals(condition.getTrain_num().trim())){
				conditionSql += "and train_num like '%"+condition.getTrain_num() +"%' ";
			}
		}
		sql += conditionSql;
		sql += " ) t2 LIMIT ?,? ";
		
		List<Order> list = getOrderBySql(sql,user_id ,(pb.getCurrentPage()-1)*pb.getPageSize(),pb.getPageSize());  
		
		String countSql = "select count(*) from orders where user_id="+user_id; 
		countSql += conditionSql;
		pb.setTotalCount(getCountBySql(countSql));
		return list;
	}
	
	/**
	 * ����sql��ѯ���ݸ��˶���������
	 */
	public int getCountBySql(String sql){
		int result =0;
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				result = rs.getInt(1); //�õ�����������
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeResourse(rs, ps, conn);
		}
		return result;
	}
	
	/**
	 * ����id�õ���Ӧ������Ϣ
	 */
	public Order getOrderById(int id){
		String sql = "select * from orders where id=?";
		List<Order> list = getOrderBySql(sql, id) ;
		return list !=null ? list.get(0) :null;
	}
	
	/**
	 * ����sql��ѯ,�õ������б�
	 */
	public List<Order> getOrderBySql(String sql,Object...objects){
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<Order> list = new ArrayList<Order>();
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			if(objects.length>0 && objects!=null){
				for(int i=0;i<objects.length;i++){
					ps.setObject(i+1, objects[i]);
				}
			}
			rs = ps.executeQuery();
			while(rs.next()){
				Order order = new Order();
				order.setId(rs.getInt("ID"));
				order.setUser_id(rs.getInt("USER_ID"));
				order.setTrain_num(rs.getString("TRAIN_NUM"));
				order.setG_time(rs.getString("G_TIME"));
				order.setOrigin(rs.getString("ORIGIN"));
				order.setTerminus(rs.getString("TERMINUS"));
				order.setOrder_time(rs.getTimestamp("ORDER_TIME"));
				order.setLeaveTime(rs.getString("LEAVETIME"));
				order.setPrice(rs.getFloat("PRICE"));
				order.setA_time(rs.getString("A_TIME"));
				list.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeResourse(rs, ps, conn);
		}
		return list;
	}
}
