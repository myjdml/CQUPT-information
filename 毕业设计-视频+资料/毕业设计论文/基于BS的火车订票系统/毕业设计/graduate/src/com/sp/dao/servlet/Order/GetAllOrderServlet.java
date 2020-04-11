package com.sp.dao.servlet.Order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.common.PageBean;
import com.sp.dao.service.OrderService;
import com.sp.dao.service.TrainService;
import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.OrderServiceImpl;
import com.sp.dao.service.impl.TrainServiceImpl;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.Order;
import com.sp.entity.Train;
import com.sp.entity.User;

public class GetAllOrderServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		//接收模糊查询参数
		String train_num = request.getParameter("train_num");
		//封装参数
		Order condition = new Order();
		if(train_num!=null && !"".equals(train_num.trim())){
			condition.setTrain_num(train_num);
		}
		
		PageBean pb = new PageBean();  //页面显示条数固定
		//接收分页查询相关参数
		String currentPage = request.getParameter("currentPage");  //当前页
		if(currentPage!=null && !"".equals(currentPage.trim())){
			pb.setCurrentPage(Integer.parseInt(currentPage));   //设置当前页
		}
		//调用service层方法
		OrderService orderService = new OrderServiceImpl();
		UserService userService = new UserServiceImpl();

		List<Order> listOrder = orderService.getOrderByPage(pb, condition);
		List<Order> list = new ArrayList<Order>();
		
		for(int i=0;i<listOrder.size();i++){
			Order order1 = listOrder.get(i);
			Order order = new Order();
			
			int user_id = order1.getUser_id();
			User user = userService.getUserById(user_id);
			int id = order1.getId();
			String name = user.getName();
			String trainNum = order1.getTrain_num();
			String leavaTime = order1.getLeaveTime();
			String origin = order1.getOrigin();
			String terminus = order1.getTerminus();
			String a_time = order1.getA_time();
			String g_time = order1.getG_time();
			float price = order1.getPrice();
			Date order_time = order1.getOrder_time();
			
			order.setId(id);
			order.setName(name);
			order.setTrain_num(trainNum);
			order.setLeaveTime(leavaTime);
			order.setOrigin(origin);
			order.setTerminus(terminus);
			order.setA_time(a_time);
			order.setG_time(g_time);
			order.setPrice(price);
			order.setOrder_time(order_time);
			list.add(order);
		}
		
		//将数据存入request并进行转发
		request.setAttribute("list",list);
		request.setAttribute("pb",pb);
		request.setAttribute("condition", condition);
		
		request.getRequestDispatcher("/files/listOrders.jsp").forward(request, response);
	}


}
