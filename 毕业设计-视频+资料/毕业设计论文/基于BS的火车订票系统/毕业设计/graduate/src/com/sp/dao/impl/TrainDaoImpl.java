package com.sp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.common.PageBean;
import com.sp.dao.BaseDao;
import com.sp.dao.TrainDao;
import com.sp.entity.Order;
import com.sp.entity.Train;

public class TrainDaoImpl extends BaseDao implements TrainDao {

	/**
	 * ��ҳ��ʾ������Ϣ
	 */
	public List<Train> getTrainByPage(PageBean pb,Train condition){
		String conditionSql = "";
		String sql = "select t2.* from(select t1.* from train t1 where 1=1 ";
		if(condition!=null){
			if(condition.getTrain_num() !=null && !"".equals(condition.getTrain_num().trim())){
				conditionSql += "and train_num like '%"+condition.getTrain_num() +"%' ";
			}
		}
		sql += conditionSql;
		sql += ")t2 LIMIT ?,? ";
		
		List<Train> list = getTrainBySql(sql, (pb.getCurrentPage()-1)*pb.getPageSize(), pb.getPageSize());  
		
		String countSql = "select count(*) from train where 1=1"; //1=1Ϊ��ƴ��sql
		countSql += conditionSql;
		pb.setTotalCount(getCountBySql(countSql));
		return list;
		
	}
	
	/**
	 * ��ҳ��ʾԤ��������Ϣ
	 */
	public List<Train> getTrainsByPage(PageBean pb,Order condition){
		String conditionSql = "";
		String sql = "select t2.* from(select t1.* from train t1 where 1=1 ";
		if(condition!=null){  
			if(condition.getOrigin() !=null && !"".equals(condition.getOrigin().trim()) && condition.getTerminus()!=null && !"".equals(condition.getTerminus().trim())){
				conditionSql += "and station like '%"+condition.getOrigin() +"%"+condition.getTerminus()+"%' ";
			}
			if(condition.getTrain_num() !=null && !"".equals(condition.getTrain_num().trim())){
				conditionSql += "and train_num like '%"+condition.getTrain_num() +"%' ";
			}
			
		}
		sql += conditionSql;
		sql += ")t2 limit ?,?  ";
		
		List<Train> list = getTrainBySql(sql,(pb.getCurrentPage()-1)*pb.getPageSize(), pb.getCurrentPage()*pb.getPageSize());  
		
		String countSql = "select count(*) from train where 1=1 "; //1=1Ϊ��ƴ��sql
		countSql += conditionSql;
		pb.setTotalCount(getCountBySql(countSql));
		return list;
		
	}
	
	/**
	 * ����sql��ѯ����������
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
	 * ���ݳ��εõ����ζ���
	 */
	public Train getTrain(String train_num){
		String sql = "select * from train where train_num=?";
		List<Train> list = getTrainBySql(sql, train_num);
		return list!=null && list.size()>0 ? list.get(0):null;
	}
	
	/**
	 * ɾ��������Ϣ
	 */
	public int deleteTrain(String train_num){
		String sql = "delete from train where train_num=?";
		return updateBySql(sql, train_num);
	}
	
	/**
	 * �޸ĳ�����Ϣ
	 */
 	public int updateTrain(Train train,String trainNum){
 		String sql = "update train set train_num=?,station=?,a_time=?,g_time=?,price=?," +
 				"amount=?,remainder=? where train_num=?";
 		return updateBySql(sql, train.getTrain_num(),train.getStation(),train.getA_time(),train.getG_time(),
 				train.getPrice(),train.getAmount(),train.getRemainder(),trainNum);
	}
	
 	/**
	 * ���ӳ���
	 */
	public int addTrain(Train train){
		String sql = "insert into train values(?,?,?,?,?,?,?)";
		return updateBySql(sql, train.getTrain_num(),train.getStation(),train.getA_time(),
				train.getG_time(),train.getPrice(),train.getAmount(),train.getRemainder());
	}
 	
 	
	/**
	 * ����sql��ѯ,�õ������б�
	 */
	public List<Train> getTrainBySql(String sql,Object...objects){
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs =null;
		List<Train> list = new ArrayList<Train>();
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
				Train train = new Train();
				train.setTrain_num(rs.getString("TRAIN_NUM"));
				train.setStation(rs.getString("STATION"));
				train.setA_time(rs.getString("A_TIME"));
				train.setG_time(rs.getString("G_TIME"));
				train.setPrice(rs.getString("PRICE"));
				train.setAmount(rs.getInt("AMOUNT"));
				train.setRemainder(rs.getInt("REMAINDER"));
				list.add(train);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeResourse(rs, ps, conn);
		}
		return list;
	}
}


















