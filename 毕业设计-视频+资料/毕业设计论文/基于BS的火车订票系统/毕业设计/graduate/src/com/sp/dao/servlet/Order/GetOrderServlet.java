package com.sp.dao.servlet.Order;
/**
 * 根据order_id得到对应的订单信息
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.OrderService;
import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.OrderServiceImpl;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.Order;
import com.sp.entity.User;

public class GetOrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String order_id = request.getParameter("order_id");
		if(order_id ==null || "".equals(order_id.trim())){
			out.println("<script>alert('您所查询的订单不存在，请重新操作！');history.go(-1);</script>");
			out.close();
			return;
		}
		
		//调用Service层方法
		OrderService orderService = new OrderServiceImpl();
		UserService userService = new UserServiceImpl();
		
		Order order = orderService.getOrderById(Integer.parseInt(order_id));
		int user_id = order.getUser_id();
		User user= userService.getUserById(user_id);
		
		request.setAttribute("user", user);
		request.setAttribute("order",order);
		request.getRequestDispatcher("/files/orderDetails.jsp").forward(request, response);
	}


}
