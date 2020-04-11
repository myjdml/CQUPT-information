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
 * 修改用户信息
 * 
 *
 */
public class UpdateUserServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//处理乱码
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		//接收参数
		String id = request.getParameter("userId");
		String username = request.getParameter("username");  //用户名
		String password = request.getParameter("password");
		String status = request.getParameter("status");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String country = request.getParameter("country");
		String papers_type = request.getParameter("papers_type");
		String papers_num = request.getParameter("papers_num");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		
		
		//封装参数
		User user = new User();
		user.setId(Integer.parseInt(id));
		user.setUsername(username);
		user.setPassword(password);
		user.setStatus(Integer.parseInt(status));
		user.setName(name);
		user.setSex(sex);
		user.setCounty(country);
		user.setPapers_type(papers_type);
		user.setPapers_num(papers_num);
		user.setPhone(phone);
		user.setEmail(email);
		user.setAddress(address);
		
		//调用userService层方法进行修改
		UserService userService = new UserServiceImpl();
		
		/*//验证用户名以及证件号码是否重复
		User user1 = userService.getUserById(Integer.parseInt(id));
		if(!user1.getUsername().equals(username)){
			out.println("<script>alert('用户名已存在！');history.go(-1);</script>");
		}*/
		
		int result = userService.updateUserByManager(user);
		if(result>0){
			out.println("<script>alert('修改成功!');window.location.href='/graduate/GetUsersServlet';</script>");
			out.close();
		}else{
			out.println("<script>alert('修改失败，请重试！');window.location.href='/graduate/GetUsersServlet'</script>");
			out.close();
		}
	}


}
