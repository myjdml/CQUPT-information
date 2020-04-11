package com.sp.dao.service.impl;

import java.util.List;

import com.sp.common.PageBean;
import com.sp.dao.UserDao;
import com.sp.dao.impl.UserDaoImpl;
import com.sp.dao.service.UserService;
import com.sp.entity.User;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();
	/**
	 * �����û�������û�����
	 */
	public User getUserByUsername(String username){
		return userDao.getUserByUsername(username);
	}
	
	/**
	 * ��½���
	 */
	public boolean checkLogin(String username,String password){
		//�����û�����ȡ�û�����
		User user =  userDao.getUserByUsername(username);
		if(user!=null){  //�û�������
			if(user.getPassword().equals(password)){  //����Ҳ��ȷ
				//��¼�ɹ�
				return true;
			}
		}
		return false;
	}
	
	/**
	 * ��ҳ��ʾ�û���Ϣ
	 */
	public List<User> getUserByPage(PageBean pb,User condition){
		return userDao.getUserByPage(pb, condition);
	}
	
	/**
	 * ����sql��ѯ����������
	 */
	public int getCountBySql(String sql){
		return userDao.getCountBySql(sql);
	}
	
	/**
	 * ����id��ȡ�û�����
	 */
	public User getUserById(int id){
		return userDao.getUserById(id);
	}
	
	/**
	 * �����û�
	 */
	public int addUser(User user){
		return userDao.addUser(user);
	}
	/**
	 * �û�ע��
	 * ע���û����û�Ȩ��Ĭ��Ϊ1����ͨ�û�������Ա���Խ����޸ģ��ĳɹ���Ա
	 */
	public int registerUser(User user){
		return userDao.registerUser(user);
	}
	
	/**
	 * ɾ���û�
	 */
	public int deleteUser(int id){
		return userDao.deleteUser(id);
	}
	
	/**
	 * �޸��û��޸��û�(����Աģʽ�����Զ�Ȩ�޽����޸�)
	 */
	public int updateUserByManager(User user){
		return userDao.updateUserByManager(user);
	}
	
	/**
	 * �޸��û�����ͨ�û����Լ�����Ϣ�����޸ģ�
	 */
	public int updateUserByConsumer(User user){
		return userDao.updateUserByConsumer(user);
	}
	
	/**
	 * �����û������в��ң����û����Ƿ����(�û�������Ψһ�����޸�ǰ��������û����Ƿ���ڣ������ڸ�����ʾ��׼�޸�)
	 */
	public boolean CheckUsernameIsExist(String username){
		return userDao.CheckUsernameIsExist(username);
	}
	
	/**
	 * ����֤����Ž��в��ң���֤�����Ƿ����(֤���ű���Ψһ���ڲ���ǰ�������֤�����Ƿ���ڣ������ڸ�����ʾ��׼�޸�)
	 */
	public boolean CheckPapersNumIsExist(String papers_num){
		return userDao.CheckPapersNumIsExist(papers_num);
	}
	/**
	 * ����id�޸�����
	 */
	public int updatePassword(String password,int id){
		return userDao.updatePassword(password, id);
	}
}
