package com.rays.ctl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;
import com.rays.util.ServletUtility;

@WebServlet("/UserListCtl")
public class UserListCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	UserModel m = new UserModel();
	UserBean b = new UserBean();
	
	try {
		List <UserBean> l = m.search(b, 1, 20);
		request.setAttribute("list", l);
		
	}catch(Exception e) {
		e.getStackTrace();
	} 
	
	ServletUtility.forward("UserListView.jsp", request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
