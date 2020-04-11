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
			out.println("<script>alert('������Ҫ��ѯ�ĳ��Σ�');history.go(-1);</script>");
			out.close();
			return;
		}
		TrainService trainService = new TrainServiceImpl();
		Train train  = trainService.getTrain(train_num);  //���ݳ��εõ��г���Ϣ
		
		if(train == null ){
			out.println("<script>alert('���޸ð����Ϣ��');history.go(-1);</script>");
			out.close();
			return;
		}
		
		String stations = train.getStation();  //�õ���վ�ַ���
		String aTime = train.getA_time();		//��վ��ʱ���ַ���
		String gTime = train.getG_time();		//����ʱ���ַ���
		String prices = train.getPrice(); 		//Ʊ���ַ���
		
		//�и��ַ������õ���վ���飬����ʱ�����飬��վʱ�������Լ�Ʊ������
		String []station = stations.split("/");
		String []a_time = aTime.split("/");
		String []g_time = gTime.split("/");
		String []price = prices.split("/");
		int length = station.length;
		//��װ����
		request.setAttribute("train", train);
		request.setAttribute("station",station);
		request.setAttribute("a_time", a_time);
		request.setAttribute("g_time", g_time);
		request.setAttribute("price",price);
		request.setAttribute("length",length);
		request.getRequestDispatcher("/files/listTrain.jsp").forward(request, response);
	}


}
