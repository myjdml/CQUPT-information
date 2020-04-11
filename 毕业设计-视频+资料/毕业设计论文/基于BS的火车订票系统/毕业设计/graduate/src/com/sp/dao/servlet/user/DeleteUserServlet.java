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
		//接收参数id
		String id = request.getParameter("id");
		if(id==null || "".equals(id.trim())){
			out.println("<script>alert('要删除的数据不存在！');window.location.href='/graduate/GetUsersServlet'</script>");
			out.close();
			return;
		}
		//调用userService层的方法
		UserService userService = new UserServiceImpl();
		int result = userService.deleteUser(Integer.parseInt(id));
		if(result>0){
			out.println("<script>alert('删除成功！');window.location.href='/graduate/GetUsersServlet'</script>");
			out.close();
		}else{
			out.println("<script>alert('删除失败，请重试！');history.go(-1);</script>");
			out.close();
		}
	}

}
