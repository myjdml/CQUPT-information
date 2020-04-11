package com.sp.dao.servlet.Train;
/**
 * 车次录入
 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.TrainService;
import com.sp.dao.service.impl.TrainServiceImpl;
import com.sp.entity.Train;

public class AddTrainServlet extends HttpServlet {



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
		String train_num = request.getParameter("train_num");
		String station = request.getParameter("station");
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
		
		TrainService trainService = new TrainServiceImpl();
		int result = trainService.addTrain(train);
		if(result>0){
			out.println("<script>alert('车次增加成功！');window.location.href='/graduate/GetTrainsServlet'</script>");
			out.close();
		}else{
			out.println("<script>alert('车次增加失败！');history.go(-1);</script>");
			out.close();
		}
	}


}
