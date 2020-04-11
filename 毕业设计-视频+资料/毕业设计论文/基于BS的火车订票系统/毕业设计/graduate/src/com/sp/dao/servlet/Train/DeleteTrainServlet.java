package com.sp.dao.servlet.Train;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.TrainService;
import com.sp.dao.service.impl.TrainServiceImpl;
/**
 * ɾ������
 * 
 *
 */
public class DeleteTrainServlet extends HttpServlet {

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
			out.println("<script>alert('Ҫɾ�������ݲ����ڣ�');window.location.href='/graduate/GetTrainsServlet'</script>");
			out.close();
			return;
		}
		
		TrainService trainService = new TrainServiceImpl();
		int result = trainService.deleteTrain(train_num);
		if(result>0){
			out.println("<script>alert('ɾ���ɹ���');window.location.href='/graduate/GetTrainsServlet'</script>");
			out.close();
		}else{
			out.println("<script>alert('ɾ��ʧ�ܣ������ԣ�');history.go(-1);</script>");
			out.close();
		}
	}


}
