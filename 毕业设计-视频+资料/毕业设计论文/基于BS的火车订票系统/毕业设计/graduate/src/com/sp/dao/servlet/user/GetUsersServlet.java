package com.sp.dao.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.common.PageBean;
import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.User;
/**
 *用户管理，获得用户信息 
 */
public class GetUsersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理请求乱码
		request.setCharacterEncoding("utf-8");
		//处理响应乱码
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//接收模糊查询参数,用于分页查询
		String username = request.getParameter("username");  //用户名
		String status = request.getParameter("status");  //用户身份
		//封装参数
		User condition = new User();
		if(username!=null && !"".equals(username.trim())){
			condition.setUsername(username);
		}
		if(status!=null && !"".equals(status.trim())){
			condition.setStatus(Integer.parseInt(status));
		}
		
		PageBean pb = new PageBean();  //页面显示条数固定
		//接收分页查询相关参数
		String currentPage = request.getParameter("currentPage");  //当前页
		if(currentPage!=null && !"".equals(currentPage.trim())){
			pb.setCurrentPage(Integer.parseInt(currentPage));   //设置当前页
		}
		//调用userService层方法
		UserService userService = new UserServiceImpl();
		List<User> list = userService.getUserByPage(pb, condition);
		//将数据存入request并进行转发
		request.setAttribute("list",list);
		request.setAttribute("pb",pb);
		request.setAttribute("condition", condition);
		
		request.getRequestDispatcher("/files/listuser.jsp").forward(request, response);
	}


}
