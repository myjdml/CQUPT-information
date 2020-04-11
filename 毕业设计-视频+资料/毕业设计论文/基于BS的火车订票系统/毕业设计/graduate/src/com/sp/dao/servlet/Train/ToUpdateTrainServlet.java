package com.sp.dao.servlet.Train;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.TrainService;
import com.sp.dao.service.impl.TrainServiceImpl;
import com.sp.entity.Train;
/**
 * 查找要修改的车次信息
 * 
 *
 */
public class ToUpdateTrainServlet extends HttpServlet {



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
			out.println("<script>alert('要编辑的数据不存在！');window.location.href='/graduate/GetTrainsServlet'</script>");
			out.close();
			return;
		}
		
		TrainService trainService = new TrainServiceImpl();
		Train train = trainService.getTrain(train_num);
		request.setAttribute("train",train);
		request.getRequestDispatcher("/files/updateTrain.jsp").forward(request, response);
	}

}
