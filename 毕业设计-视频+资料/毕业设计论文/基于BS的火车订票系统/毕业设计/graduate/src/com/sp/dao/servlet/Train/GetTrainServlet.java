package com.sp.dao.servlet.Train;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.TrainDao;
import com.sp.dao.service.TrainService;
import com.sp.dao.service.impl.TrainServiceImpl;
import com.sp.entity.Train;

public class GetTrainServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String train_num = request.getParameter("train_num");
		if(train_num==null || "".equals(train_num.trim())){
			out.println("<script>alert('请输入要查询的车次！');history.go(-1);</script>");
			out.close();
			return;
		}
		TrainService trainService = new TrainServiceImpl();
		Train train  = trainService.getTrain(train_num);  //根据车次得到列车信息
		
		if(train == null ){
			out.println("<script>alert('暂无该班次信息！');history.go(-1);</script>");
			out.close();
			return;
		}
		
		String stations = train.getStation();  //得到车站字符串
		String aTime = train.getA_time();		//到站车时间字符串
		String gTime = train.getG_time();		//发车时间字符串
		String prices = train.getPrice(); 		//票价字符串
		
		//切割字符串，得到车站数组，发车时间数组，到站时间数组以及票价数组
		String []station = stations.split("/");
		String []a_time = aTime.split("/");
		String []g_time = gTime.split("/");
		String []price = prices.split("/");
		int length = station.length;
		//封装参数
		request.setAttribute("train", train);
		request.setAttribute("station",station);
		request.setAttribute("a_time", a_time);
		request.setAttribute("g_time", g_time);
		request.setAttribute("price",price);
		request.setAttribute("length",length);
		request.getRequestDispatcher("/files/listTrain.jsp").forward(request, response);
	}


}
