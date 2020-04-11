package com.sp.dao.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;

public class DeleteUserServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//���ղ���id
		String id = request.getParameter("id");
		if(id==null || "".equals(id.trim())){
			out.println("<script>alert('Ҫɾ�������ݲ����ڣ�');window.location.href='/graduate/GetUsersServlet'</script>");
			out.close();
			return;
		}
		//����userService��ķ���
		UserService userService = new UserServiceImpl();
		int result = userService.deleteUser(Integer.parseInt(id));
		if(result>0){
			out.println("<script>alert('ɾ���ɹ���');window.location.href='/graduate/GetUsersServlet'</script>");
			out.close();
		}else{
			out.println("<script>alert('ɾ��ʧ�ܣ������ԣ�');history.go(-1);</script>");
			out.close();
		}
	}

}
