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
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		//������������
		request.setCharacterEncoding("utf-8");
		
		//�����û���������
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		//����������֤
		if(username==null || "".equals(username.trim())){
			response.sendRedirect("login.jsp");
			return;
		}
		if(password == null || "".equals(password.trim())){
			response.sendRedirect("login.jsp");
			return;
		}
		
		//����service�㷽�����е�½��֤
		UserService userService = new UserServiceImpl();
		User user = userService.getUserByUsername(username);
		boolean result = userService.checkLogin(username, password);
		String alert = "�û��������벻��ȷ�������µ�½��";
		HttpSession session = request.getSession();
		if(result){
			int status = user.getStatus(); //Ȩ�޿���
			String welcome = "��ӭ��:";
			//��װ����������ת��
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
