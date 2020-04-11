package com.sp.dao.servlet.Train;
/**
 * 修改车次信息
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.OrderService;
import com.sp.dao.service.TrainService;
import com.sp.dao.service.impl.OrderServiceImpl;
import com.sp.dao.service.impl.TrainServiceImpl;
import com.sp.entity.Order;
import com.sp.entity.Train;

public class UpdateTrainServlet extends HttpServlet {



	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//接收参数
		String trainNum = request.getParameter("trainNum");
		String train_num = request.getParameter("train_num");
		String station  = request.getParameter("station");
		String a_time = request.getParameter("a_time");
		String g_time = request.getParameter("g_time");
		String price = request.getParameter("price");
		String amount = request.getParameter("amount");
		String remainder = request.getParameter("remainder");
		//封装参数
		Train train = new Train();
		train.setTrain_num(train_num);
		train.setStation(station);
		train.setA_time(a_time);
		train.setG_time(g_time);
		train.setPrice(price);
		train.setAmount(Integer.parseInt(amount));
		train.setRemainder(Integer.parseInt(remainder));
		
		//调用service层方法进行修改
		OrderService orderService = new OrderServiceImpl();
		List<Order> list = orderService.getOrderByTrainNum(train_num);
		if(list.size()>0){
			out.println("<script>alert('要修改的车次已有订单，不允许修改！');window.location.href='/graduate/GetTrainsServlet'</script>");
			out.close();
			return;
		}
		TrainService trainService = new TrainServiceImpl();
		int result = trainService.updateTrain(train,trainNum);
		if(result>0){
			out.println("<script>alert('修改成功!');window.location.href='/graduate/GetTrainsServlet';</script>");
			out.close();
		}else{
			out.println("<script>alert('修改失败，请重试！');window.location.href='/graduate/GetTrainsServlet'</script>");
			out.close();
		}
	}


}
