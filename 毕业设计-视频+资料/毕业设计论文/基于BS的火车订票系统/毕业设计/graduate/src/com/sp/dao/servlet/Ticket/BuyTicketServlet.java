package com.sp.dao.servlet.Ticket;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import oracle.sql.DATE;

import com.sp.common.PageBean;
import com.sp.dao.service.TrainService;
import com.sp.dao.service.impl.TrainServiceImpl;
import com.sp.entity.Order;
import com.sp.entity.Station;
import com.sp.entity.Train;

public class BuyTicketServlet extends HttpServlet {

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
		String start = request.getParameter("start");
		String end = request.getParameter("end");
		String leaveTime = request.getParameter("leaveTime");
		String train_num = request.getParameter("train_num");
		

		
		Order condition = new Order();
		
		if(start==null || "".equals(start.trim())){
			out.println("<script>alert('请输入出发地！');history.go(-1);</script>");
			out.close();
			return;
		}
		if(end==null || "".equals(end.trim())){
			out.println("<script>alert('请输入目的地！');history.go(-1);</script>");
			out.close();
			return;
		}
		if(leaveTime==null || "".equals(leaveTime.trim())){
			out.println("<script>alert('请输入出发日期！');history.go(-1);</script>");
			out.close();
			return;
		}
		
		condition.setOrigin(start);
		condition.setTerminus(end);
		condition.setLeaveTime(leaveTime);
		
		if(train_num != null && !"".equals(train_num.trim())){
			System.out.println("这执行了吗");
			condition.setTrain_num(train_num);
		}
		
		PageBean pb = new PageBean();  //页面显示条数固定
		//接收分页查询相关参数
		String currentPage = request.getParameter("currentPage");  //当前页
		if(currentPage!=null && !"".equals(currentPage.trim())){
			pb.setCurrentPage(Integer.parseInt(currentPage));   //设置当前页
		}
		
		//调用service层方法进行查询
		TrainService trainService = new TrainServiceImpl();
 		List<Order> listTicket = new ArrayList<Order>();
		List<Train> list = trainService.getTrainsByPage(pb, condition);
		
		if(list.size()<=0 ){
			out.println("<script>alert('暂无该班次信息！');history.go(-1);</script>");
			out.close();
			return;
		}
		
		for(int i=0;i<list.size();i++){
			Train train = list.get(i);
			Order ticket = new Order();
			
			String stations = train.getStation();
			String aTime = train.getA_time();
			String gTime = train.getG_time();
			String prices = train.getPrice();
			String trainNum = train.getTrain_num();
			int remainder = train.getRemainder();
			
			String []station = stations.split("/");
			String []a_time = aTime.split("/");
			String []g_time = gTime.split("/");
			String []price = prices.split("/"); 
			
			int startIndex =0 ;
			int endIndex = 0 ;
			for(int j=0;j<station.length;j++){
				if(start.equals(station[j])){
					startIndex = j;
				}
				if(end.equals(station[j])){
					endIndex = j;
				}
			}
			float startPrice =Float.parseFloat(price[startIndex]);
			float endPrice = Float.parseFloat(price[endIndex]);
			float ticketPrice = endPrice - startPrice;

			ticket.setTrain_num(trainNum);
			ticket.setOrigin(start);
			ticket.setTerminus(end);
			ticket.setA_time(a_time[endIndex]);
			ticket.setG_time(g_time[startIndex]);
			ticket.setPrice(ticketPrice);
			ticket.setRemainder(remainder);
			ticket.setLeaveTime(leaveTime);
			listTicket.add(ticket);
		}
		
		request.setAttribute("listTicket",listTicket);
		request.setAttribute("pb",pb);
		request.setAttribute("condition", condition);
		request.getRequestDispatcher("/buyTicket/buyTicket.jsp").forward(request, response);
	}


}
