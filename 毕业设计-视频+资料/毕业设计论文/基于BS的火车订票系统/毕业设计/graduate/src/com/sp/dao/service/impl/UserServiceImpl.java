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
	 * 根据用户名获得用户对象
	 */
	public User getUserByUsername(String username){
		return userDao.getUserByUsername(username);
	}
	
	/**
	 * 登陆检查
	 */
	public boolean checkLogin(String username,String password){
		//根据用户名获取用户对象
		User user =  userDao.getUserByUsername(username);
		if(user!=null){  //用户名存在
			if(user.getPassword().equals(password)){  //密码也正确
				//登录成功
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 分页显示用户信息
	 */
	public List<User> getUserByPage(PageBean pb,User condition){
		return userDao.getUserByPage(pb, condition);
	}
	
	/**
	 * 根据sql查询数据总条数
	 */
	public int getCountBySql(String sql){
		return userDao.getCountBySql(sql);
	}
	
	/**
	 * 根据id获取用户对象
	 */
	public User getUserById(int id){
		return userDao.getUserById(id);
	}
	
	/**
	 * 增加用户
	 */
	public int addUser(User user){
		return userDao.addUser(user);
	}
	/**
	 * 用户注册
	 * 注册用户的用户权限默认为1，普通用户。管理员可以进行修改，改成管理员
	 */
	public int registerUser(User user){
		return userDao.registerUser(user);
	}
	
	/**
	 * 删除用户
	 */
	public int deleteUser(int id){
		return userDao.deleteUser(id);
	}
	
	/**
	 * 修改用户修改用户(管理员模式，可以对权限进行修改)
	 */
	public int updateUserByManager(User user){
		return userDao.updateUserByManager(user);
	}
	
	/**
	 * 修改用户（普通用户对自己的信息进行修改）
	 */
	public int updateUserByConsumer(User user){
		return userDao.updateUserByConsumer(user);
	}
	
	/**
	 * 根据用户名进行查找，看用户名是否存在(用户名必须唯一，在修改前必须检查此用户名是否存在，若存在给出提示不准修改)
	 */
	public boolean CheckUsernameIsExist(String username){
		return userDao.CheckUsernameIsExist(username);
	}
	
	/**
	 * 根据证件编号进行查找，看证件号是否存在(证件号必须唯一，在插入前必须检查此证件号是否存在，若存在给出提示不准修改)
	 */
	public boolean CheckPapersNumIsExist(String papers_num){
		return userDao.CheckPapersNumIsExist(papers_num);
	}
	/**
	 * 根据id修改密码
	 */
	public int updatePassword(String password,int id){
		return userDao.updatePassword(password, id);
	}
}
