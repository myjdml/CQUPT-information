package com.sp.dao.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.User;
/**
 * 根据ID得到用户信息（用于查看用户详细信息）
 * 
 *
 */
public class GetUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String id = request.getParameter("id"); //接收id，根据此id查找相应用户
		//调用userService层方法进行查找
		UserService userService = new UserServiceImpl();
		User user = userService.getUserById(Integer.parseInt(id));
		request.setAttribute("user",user);
		request.getRequestDispatcher("/files/userDetailedInformation.jsp").forward(request, response);
	}


}
