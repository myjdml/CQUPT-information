package com.sp.dao.servlet.Ticket;
/**
 * 退票
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.OrderService;
import com.sp.dao.service.impl.OrderServiceImpl;

public class ReturnTicketServlet extends HttpServlet {


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
		String train_num = request.getParameter("train_num");
		String  userId = request.getParameter("user_id");
		if(order_id ==null || "".equals(order_id.trim())){
			out.println("<script>alert('订单不存在!');history.go(-1);</script>");
			out.close();
			return;
		}
		
		//调用service层方法进行退票
		OrderService orderService = new OrderServiceImpl();
		int remainder1 = orderService.getRemainderByTrainNum(train_num);//余票数
		int remainder2 = remainder1+1; //余票减1 
		
		int result1 = orderService.deleteOrder(Integer.parseInt(order_id));
		int result2 = orderService.updateTrain(remainder2, train_num);
		
		if(result1>0 && result2>0){
			out.println("<script>alert('退票成功！');history.go(-1);</script>");
			out.close();
		}else{
			out.println("<script>alert('退票失败，请重试！');history.go(-1);</script>");
			out.close();
		}
	}

}
