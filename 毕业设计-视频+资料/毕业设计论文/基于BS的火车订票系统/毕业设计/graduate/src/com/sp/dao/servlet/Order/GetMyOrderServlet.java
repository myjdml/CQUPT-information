package com.sp.dao.servlet.Order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.common.PageBean;
import com.sp.dao.service.OrderService;
import com.sp.dao.service.impl.OrderServiceImpl;
import com.sp.entity.Order;

public class GetMyOrderServlet extends HttpServlet {

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
		Order condition = new Order();
		if(train_num!=null && !"".equals(train_num.trim())){
			condition.setTrain_num(train_num);
		}
		
		PageBean pb = new PageBean();  //ҳ����ʾ�����̶�
		//���շ�ҳ��ѯ��ز���
		String currentPage = request.getParameter("currentPage");  //��ǰҳ
		if(currentPage!=null && !"".equals(currentPage.trim())){
			pb.setCurrentPage(Integer.parseInt(currentPage));   //���õ�ǰҳ
		}
		
		String user_id = request.getParameter("user_id");
		OrderService orderService = new OrderServiceImpl();
		List<Order> list = orderService.getMyOrder(pb, condition, Integer.parseInt(user_id));
		
		if(list.size()<=0 ){
			out.println("<script>alert('������ض�����');history.go(-1);</script>");
			out.close();
			return;
		}
		
		request.setAttribute("list", list);
		request.setAttribute("pb",pb);
		request.setAttribute("condition", condition);
		request.getRequestDispatcher("/files/myOrders.jsp").forward(request, response);
	}


}
