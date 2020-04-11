package com.sp.dao.servlet.Train;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.common.PageBean;
import com.sp.dao.service.TrainService;
import com.sp.dao.service.impl.TrainServiceImpl;
import com.sp.entity.Train;
import com.sp.entity.Station;
/**
 * �õ����г�����Ϣ
 * 
 *
 */
public class GetTrainsServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//����ģ����ѯ����
		String train_num = request.getParameter("train_num");
		//��װ����
		Train condition = new Train();
		if(train_num!=null && !"".equals(train_num.trim())){
			condition.setTrain_num(train_num);
		}
		
		PageBean pb = new PageBean();  //ҳ����ʾ�����̶�
		//���շ�ҳ��ѯ��ز���
		String currentPage = request.getParameter("currentPage");  //��ǰҳ
		if(currentPage!=null && !"".equals(currentPage.trim())){
			pb.setCurrentPage(Integer.parseInt(currentPage));   //���õ�ǰҳ
		}
		//����service�㷽��
		TrainService trainService = new TrainServiceImpl();
		List<Train> list = trainService.getTrainByPage(pb, condition);
		
		if(list.size()<=0 ){
			out.println("<script>alert('���޸ð����Ϣ��');history.go(-1);</script>");
			out.close();
			return;
		}
		
		List<Station> listStation = new ArrayList<Station>();
		for(int i=0;i<list.size();i++){
			Train train = list.get(i);
			Station sta = new Station();
			
			String stations = train.getStation();
			String aTime = train.getA_time();
			String gTime = train.getG_time();
			String prices = train.getPrice();
			String trainNum = train.getTrain_num();
			int amount = train.getAmount();
			int remainder = train.getRemainder();
			
			String []station = stations.split("/");
			String []a_time = aTime.split("/");
			String []g_time = gTime.split("/");
			String []price = prices.split("/"); 
			
			sta.setStart(station[0]);
			sta.setEnd(station[station.length-1]);
			sta.setA_time(a_time[a_time.length-1]);
			sta.setG_time(g_time[0]);
			sta.setPrice(price[price.length-1]);
			sta.setTrain_num(trainNum);
			sta.setAmount(amount);
			sta.setRemainder(remainder);
			listStation.add(sta);
		}
		
		request.setAttribute("listStation", listStation);
		request.setAttribute("pb",pb);
		request.setAttribute("condition", condition);
		request.getRequestDispatcher("/files/listTrains.jsp").forward(request, response);
	}


}
