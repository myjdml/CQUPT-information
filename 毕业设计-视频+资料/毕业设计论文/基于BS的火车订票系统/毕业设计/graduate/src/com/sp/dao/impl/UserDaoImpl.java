package com.sp.dao.impl;

import java.awt.print.Pageable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sp.common.PageBean;
import com.sp.dao.BaseDao;
import com.sp.dao.UserDao;
import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.User;

public class UserDaoImpl extends BaseDao implements UserDao {

	/**
	 * �����û�������û�����
	 */
	public User getUserByUsername(String username){
		String sql = "select * from users where username=?";
		List<User> list = getUsersBySql(sql, username);
		return list!=null && list.size()>0 ? list.get(0):null;
	}
	
	/**
	 * ��ҳ��ʾ�û���Ϣ
	 */
	public List<User> getUserByPage(PageBean pb,User condition){
		String conditionSql = "";
		String sql = "select t2.* from(select t1.* from users t1 where 1=1 ";
		if(condition!=null){
			if(condition.getUsername() !=null && !"".equals(condition.getUsername().trim())){
				conditionSql += "and username like '%"+condition.getUsername() +"%' ";
			}
			if(condition.getStatus()>0){
				conditionSql += "and status =" + condition.getStatus();
			}
		}
		sql += conditionSql + " limit ?,? ";
		sql += ")t2  order by id";
		
		List<User> list = getUsersBySql(sql,(pb.getCurrentPage()-1)*pb.getPageSize(),pb.getPageSize());  
		
		String countSql = "select count(*) from users where 1=1"; //1=1Ϊ��ƴ��sql
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
	 * ����id��ȡ�û�����
	 */
	public User getUserById(int id){
		String sql = "select * from users where id=?";
		List<User> list = getUsersBySql(sql, id);
		return list!=null? list.get(0) : null;
	}
	
	/**
	 * �����û�
	 * �û���Ϣ:ID USERNAME PASSWORD STATUS SEX PHONE EMAIL ADDRESS NAME COUNTRY 
	 * 		 PAPERS_TYPE PAPERS_NUM  
	 * 	
	 */
	public int addUser(User user){
		String sql = "insert into users(USERNAME,PASSWORD,STATUS,SEX,PHONE,EMAIL,ADDRESS,NAME,COUNTRY,PAPERS_TYPE,PAPERS_NUM) values(?,?,?,?,?,?,?,?,?,?,?)";
		return updateBySql(sql, user.getUsername(),user.getPassword(),user.getStatus(),user.getSex(),
				user.getPhone(),user.getEmail(),user.getAddress(),user.getName(),
				user.getCounty(),user.getPapers_type(),user.getPapers_num());
	}
	/**
	 * �û�ע��
	 * ע���û����û�Ȩ��Ĭ��Ϊ1����ͨ�û�������Ա���Խ����޸ģ��ĳɹ���Ա
	 */
	public int registerUser(User user){
		String sql = "insert into users(USERNAME,PASSWORD,STATUS,SEX,PHONE,EMAIL,ADDRESS,NAME,COUNTRY,PAPERS_TYPE,PAPERS_NUM) values(?,?,?,?,?,?,?,?,?,?,?)";
		return updateBySql(sql, user.getUsername(),user.getPassword(),1,user.getSex(),
				user.getPhone(),user.getEmail(),user.getAddress(),user.getName(),
				user.getCounty(),user.getPapers_type(),user.getPapers_num());
	}
	
	
	/**
	 * ɾ���û�
	 */
	public int deleteUser(int id){
		String sql = "delete from users where id=?";
		return updateBySql(sql, id);
	}
	
	/**
	 * �޸��û���Ϣ(����Աģʽ�����Զ�Ȩ�޽����޸�)
	 * �û���Ϣ:ID USERNAME PASSWORD STATUS SEX PHONE EMAIL ADDRESS NAME COUNTRY 
	 * 		 PAPERS_TYPE PAPERS_NUM  
	 *
	 */
	public int updateUserByManager(User user){
		String sql = "update users set username=?,password=?,status=?,sex=?,phone=?,email=?," +
				"address=?,name=?,country=?,papers_type=?,papers_num=? where id=?";
		return updateBySql(sql,user.getUsername(),user.getPassword(),user.getStatus(),
				user.getSex(),user.getPhone(),user.getEmail(),user.getAddress(),user.getName(),
				user.getCounty(),user.getPapers_type(),user.getPapers_num(),user.getId() );
	}
	/**
	 * �޸��û���Ϣ����ͨ�û����Լ�����Ϣ�����޸ģ�
	 */
	public int updateUserByConsumer(User user){
		String sql = "update users set username=?,sex=?,phone=?,email=?," +
				"address=?,name=?,country=?,papers_type=?,papers_num=? where id=?";
		return updateBySql(sql,user.getUsername(),user.getSex(),
				user.getPhone(),user.getEmail(),user.getAddress(),user.getName(),
				user.getCounty(),user.getPapers_type(),user.getPapers_num(),user.getId());
	}
	
	
	/**
	 * �����û������в��ң����û����Ƿ����(�û�������Ψһ���ڲ���ǰ��������û����Ƿ���ڣ������ڸ�����ʾ��׼�޸�)
	 */
	public boolean CheckUsernameIsExist(String username){
		boolean result = false;
		String sql = "select * from users where username=?";
		List<User> list = getUsersBySql(sql, username);
		if(list.size()>0){
			//����û�������
			result = true;
		}
		return result;
	}
	
	/**
	 * ����֤����Ž��в��ң���֤�����Ƿ����(֤���ű���Ψһ���ڲ���ǰ�������֤�����Ƿ���ڣ������ڸ�����ʾ��׼�޸�)
	 */
	public boolean CheckPapersNumIsExist(String papers_num){
		boolean result = false;
		String sql = "select * from users where papers_num=?";
		List<User> list = getUsersBySql(sql, papers_num);
		if(list.size()>0){
			//����û�������
			result = true;
		}
		return result;
	}
	/**
	 * ����id�޸�����
	 */
	public int updatePassword(String password,int id){
		String sql="update users set password=?  where id=?";
		return updateBySql(sql, password,id);
	}
	
	
	/**
	 * ����sql��ѯ,�õ��û��б�
	 */
	public List<User> getUsersBySql(String sql,Object...objects){
		List<User> list = new ArrayList<User>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			if(objects!=null && objects.length>0){
				for(int i=0;i<objects.length;i++){
					ps.setObject(i+1, objects[i]);
				}
			}
			rs = ps.executeQuery();
			while(rs.next()){
				User user = new User();
				user.setId(rs.getInt("ID"));
				user.setUsername(rs.getString("USERNAME"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setStatus(rs.getInt("STATUS"));
				user.setSex(rs.getString("SEX"));
				user.setPhone(rs.getString("PHONE"));
				user.setEmail(rs.getString("EMAIL"));
				user.setAddress(rs.getString("ADDRESS"));
				user.setName(rs.getString("NAME"));
				user.setCounty(rs.getString("COUNTRY"));
				user.setPapers_type(rs.getString("PAPERS_TYPE"));
				user.setPapers_num(rs.getString("PAPERS_NUM"));
				list.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeResourse(rs, ps, conn);
		}
		
		return list;
	}

}
