package com.sp.dao.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.User;
/**
 * �޸ĸ�����Ϣ
 * 
 */
public class UpdatePersonalInformationServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//��������
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//���ղ���
		String id = request.getParameter("userId");
		String username = request.getParameter("username");  //�û���
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String country = request.getParameter("country");
		String papers_type = request.getParameter("papers_type");
		String papers_num = request.getParameter("papers_num");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		//��װ����
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setName(name);
		user.setSex(sex);
		user.setCounty(country);
		user.setPapers_type(papers_type);
		user.setPapers_num(papers_num);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		
		//����userService�㷽�������޸�
		UserService userService = new UserServiceImpl();
		int result = userService.updateUserByConsumer(user);
		if(result>0){
			out.println("<script>alert('�޸ĳɹ�!');window.location.href='/graduate/files/personalInformation.jsp';</script>");
			out.close();
		}else{
			out.println("<script>alert('�޸�ʧ�ܣ������ԣ�');history.go(-1);</script>");
			out.close();
		}
	}


}
