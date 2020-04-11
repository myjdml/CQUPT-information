package com.sp.dao;

import java.util.List;

import com.sp.common.PageBean;
import com.sp.entity.User;

/**
 *�û��ӿ�
 */
public interface UserDao {
	
	/**
	 * �����û�������û�����
	 */
	public User getUserByUsername(String username);
	
	/**
	 * ��ҳ��ʾ�û���Ϣ
	 */
	public List<User> getUserByPage(PageBean pb,User condition);
	
	/**
	 * ����sql��ѯ����������
	 */
	public int getCountBySql(String sql);
	
	/**
	 * ����id��ȡ�û�����
	 */
	public User getUserById(int id);
	
	/**
	 * �����û�
	 */
	public int addUser(User user);
	
	/**
	 * �û�ע��
	 * ע���û����û�Ȩ��Ĭ��Ϊ1����ͨ�û�������Ա���Խ����޸ģ��ĳɹ���Ա
	 */
	public int registerUser(User user);
	
	/**
	 * ɾ���û�
	 */
	public int deleteUser(int id);
	
	/**
	 * �޸��û��޸��û�(����Աģʽ�����Զ�Ȩ�޽����޸�)
	 */
	public int updateUserByManager(User user);
	
	/**
	 * �޸��û�����ͨ�û����Լ�����Ϣ�����޸ģ�
	 */
	public int updateUserByConsumer(User user);
	
	/**
	 * �����û������в��ң����û����Ƿ����(�û�������Ψһ�����޸�ǰ��������û����Ƿ���ڣ������ڸ�����ʾ��׼�޸�)
	 */
	public boolean CheckUsernameIsExist(String username);
	
	/**
	 * ����֤����Ž��в��ң���֤�����Ƿ����(֤���ű���Ψһ���ڲ���ǰ�������֤�����Ƿ���ڣ������ڸ�����ʾ��׼�޸�)
	 */
	public boolean CheckPapersNumIsExist(String papers_num);
	
	/**
	 * ����id�޸�����
	 */
	public int updatePassword(String password,int id);
}
