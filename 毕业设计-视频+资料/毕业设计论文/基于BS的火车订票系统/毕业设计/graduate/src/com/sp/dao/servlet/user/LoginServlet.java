package com.sp.dao.servlet.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.User;

public class LoginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理响应乱码
		response.setContentType("text/html;charset=utf-8");
		//处理请求乱码
		request.setCharacterEncoding("utf-8");
		
		//接收用户名和密码
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//服务器端验证
		if(username==null || "".equals(username.trim())){
			response.sendRedirect("login.jsp");
			return;
		}
		if(password == null || "".equals(password.trim())){
			response.sendRedirect("login.jsp");
			return;
		}
		
		//调用service层方法进行登陆验证
		UserService userService = new UserServiceImpl();
		User user = userService.getUserByUsername(username);
		boolean result = userService.checkLogin(username, password);
		String alert = "用户名或密码不正确，请重新登陆！";
		HttpSession session = request.getSession();
		if(result){
			int status = user.getStatus(); //权限控制
			String welcome = "欢迎您:";
			//封装参数并进行转发
			session.setAttribute("status", status);
			session.setAttribute("welcome",welcome);
			session.setAttribute("username", username);
			session.setAttribute("commonUsers", user);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}else{
			request.setAttribute("alert", alert);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
