package com.sp.dao.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.User;

public class ToUpdateUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		//接收id
		String id = request.getParameter("id");
		//调用userService层方法得到user
		UserService userService = new UserServiceImpl();
		User user = userService.getUserById(Integer.parseInt(id));
		
		request.setAttribute("user", user);
		request.getRequestDispatcher("/files/updateUser.jsp").forward(request, response);
	}

}
