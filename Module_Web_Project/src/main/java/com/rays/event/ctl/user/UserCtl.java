package com.rays.event.ctl.user;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.event.bean.UserBean;
import com.rays.event.model.UserModel;
import com.rays.event.util.ServletUtility;

//@WebServlet("/UserCtl")
@WebServlet("/UserCtl.do")
public class UserCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("/user/UserView.jsp", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(login);
			bean.setPassword(password);
			bean.setDob(sdf.parse(dob));
			model.add(bean);

			request.setAttribute("successMsg", "user saved successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "loginId already exist");
			e.printStackTrace();
		}

		ServletUtility.forward("/user/UserView.jsp", request, response);

	}

}