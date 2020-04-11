package com.sp.dao.servlet.Ticket;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sp.dao.service.OrderService;
import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.OrderServiceImpl;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.Order;
import com.sp.entity.User;

public class ToBuyTicketServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		//接收订票信息
		String train_num = request.getParameter("train_num");
		String leaveTime = request.getParameter("leaveTime");
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String g_time = request.getParameter("g_time");
		String a_time = request.getParameter("a_time");
		String price = request.getParameter("price");
		String username = request.getParameter("username");
		
		if(username ==null || "".equals(username.trim())){
			out.println("<script>alert('您的登陆已过期，请重新登录后再进行操作！')</script>");
			out.close();
			return;
		}
		//调用service层方法得到user对象 
		UserService userService = new UserServiceImpl();
		User user = userService.getUserByUsername(username);
		
		int user_id = user.getId();
		
		
		Order order = new Order();
		order.setUser_id(user_id);
		order.setTrain_num(train_num);
		order.setLeaveTime(leaveTime);
		order.setOrigin(start);
		order.setTerminus(end);
		order.setG_time(g_time);
		order.setA_time(a_time);
		order.setPrice(Float.parseFloat(price));
		
		request.setAttribute("order", order);
		request.getRequestDispatcher("/files/myOrder.jsp").forward(request, response);
		
		
	}


}
