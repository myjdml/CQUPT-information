package com.sp.dao.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sp.dao.service.UserService;
import com.sp.dao.service.impl.UserServiceImpl;
import com.sp.entity.User;

public class UpdatePasswordServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		//接收参数
		String id = request.getParameter("userId");
		String oldPassword = request.getParameter("oldPassword");
		String newPassword = request.getParameter("newPassword");
		
		if(id==null || "".equals(id.trim())){
			HttpSession session = request.getSession();
			session.removeAttribute("status");
			session.removeAttribute("welcome");
			session.removeAttribute("username");
			session.removeAttribute("user");
			out.println("<script>alert('请重新登陆！');window.location.href='/graduate/login.jsp'</script>");
			out.close();
			return;
		}
		
		UserService userService = new UserServiceImpl();
		User user = userService.getUserById(Integer.parseInt(id));
		if( !user.getPassword().equals(oldPassword) ){
			out.println("<script>alert('原始密码不正确，请重新输入！');history.go(-1);</script>");
			out.close();
		}else{
			int result = userService.updatePassword(newPassword, Integer.parseInt(id));
			if(result>0){
				out.println("<script>alert('密码修改成功！');window.location.href='/graduate/files/personalInformation.jsp'</script>");
				out.close();
			}else{
				out.println("<script>alert('修改失败，请重试！');history.go(-1)</script>");
				out.close();
			}
		}
		
	}
}
