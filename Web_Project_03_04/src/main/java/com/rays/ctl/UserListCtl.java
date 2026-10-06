package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel m = new UserModel();
		UserBean b = new UserBean();
		
		int pageNo = 1;
		int pageSize = 5;
		// b is null
		List<UserBean> l= m.search(b, pageNo, pageSize);
		System.out.println(l.size());
		req.setAttribute("pageNo",pageNo);
		req.setAttribute("pageSize",pageSize);
		req.setAttribute("list",l);
		
		RequestDispatcher r = req.getRequestDispatcher("UserListView.jsp");
		System.out.println("in userlistctl do get");
		r.forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserModel m = new UserModel();
		UserBean b = new UserBean();
		System.out.println("in userlistctl do post");
		int pageNo = 1;
		int pageSize = 5;
		
	}
}
