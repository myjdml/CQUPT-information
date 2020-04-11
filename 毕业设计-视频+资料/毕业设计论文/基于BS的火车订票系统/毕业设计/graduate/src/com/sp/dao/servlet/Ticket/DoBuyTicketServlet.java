package com.sp.dao.servlet.Ticket;

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
/**
 * π∫∆±
 * @author Administrator
 *
 */
public class DoBuyTicketServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=gbk");
		request.setCharacterEncoding("gbk");
		PrintWriter out = response.getWriter();
		
		//Ω” ’∂©∆±–≈œ¢
		String user_id = request.getParameter("user_id");
		String train_num = request.getParameter("train_num");
		String leaveTime = request.getParameter("leaveTime");
		String start = request.getParameter("origin");
		String end = request.getParameter("terminus");
		String g_time = request.getParameter("g_time");
		String a_time = request.getParameter("a_time");
		String price = request.getParameter("price");
		
		
		Order order = new Order();
		order.setUser_id(Integer.parseInt(user_id));
		order.setTrain_num(train_num);
		order.setLeaveTime(leaveTime);
		order.setOrigin(start);
		order.setTerminus(end);
		order.setG_time(g_time);
		order.setA_time(a_time);
		order.setPrice(Float.parseFloat(price));
		
		OrderService orderService = new OrderServiceImpl();
		
		int remainder1 = orderService.getRemainderByTrainNum(train_num);//”‡∆± ˝
		int remainder2 = remainder1-1; //”‡∆±ºı1
		
		int result = orderService.addOrder(order);
		int result2 = orderService.updateTrain(remainder2,train_num);
		
		if(result>0 && result2>0){
			out.println("<script>alert('π∫∆±≥…π¶£°');history.go(-1);</script>");
			out.close();
		}else{
			out.println("<script>alert('π∫∆± ß∞‹£¨«Î÷ÿ ‘£°');window.location.href='/graduate/buyTicket/buyTicket.jsp'</script>");
			out.close();
		}
		
	}
	


}
