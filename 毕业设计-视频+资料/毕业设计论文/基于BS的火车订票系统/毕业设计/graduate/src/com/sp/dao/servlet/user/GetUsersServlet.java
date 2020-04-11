package com.sp.dao.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.common.PageBean;
import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.User;
/**
 *�û���������û���Ϣ 
 */
public class GetUsersServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//������������
		request.setCharacterEncoding("utf-8");
		//������Ӧ����
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//����ģ����ѯ����,���ڷ�ҳ��ѯ
		String username = request.getParameter("username");  //�û���
		String status = request.getParameter("status");  //�û����
		//��װ����
		User condition = new User();
		if(username!=null && !"".equals(username.trim())){
			condition.setUsername(username);
		}
		if(status!=null && !"".equals(status.trim())){
			condition.setStatus(Integer.parseInt(status));
		}
		
		PageBean pb = new PageBean();  //ҳ����ʾ�����̶�
		//���շ�ҳ��ѯ��ز���
		String currentPage = request.getParameter("currentPage");  //��ǰҳ
		if(currentPage!=null && !"".equals(currentPage.trim())){
			pb.setCurrentPage(Integer.parseInt(currentPage));   //���õ�ǰҳ
		}
		//����userService�㷽��
		UserService userService = new UserServiceImpl();
		List<User> list = userService.getUserByPage(pb, condition);
		//�����ݴ���request������ת��
		request.setAttribute("list",list);
		request.setAttribute("pb",pb);
		request.setAttribute("condition", condition);
		
		request.getRequestDispatcher("/files/listuser.jsp").forward(request, response);
	}


}
