package com.rays.ctl;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/UserRegistrationCtl")
public class UserRegistrationCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do get method");
		RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
		rd.forward(req, resp); // forward method used to forward same request to it's own view

	}

	@Override
	protected void doPost(HttpServletRequest r, HttpServletResponse resp) throws ServletException, IOException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserBean bean = new UserBean();
		UserModel model = new UserModel();

		String firstName = r.getParameter("firstName");
		String lastName = r.getParameter("lastName");
		String login = r.getParameter("login");
		String password = r.getParameter("password");
		String dob = r.getParameter("dob");

		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setFirstName(firstName);
			bean.setLastName(lastName);
			bean.setLoginId(login);
			bean.setPassword(password);
			bean.setDob(sdf.parse(dob));

			model.add(bean);
			r.setAttribute("succ", "Success");

		} catch (Exception e) {
			r.setAttribute("err", "Fail");
			e.printStackTrace();
		}
		System.out.println("in do post method");
		// to show the view again empty one
		RequestDispatcher rd = r.getRequestDispatcher("UserRegistrationView.jsp");
		rd.forward(r, resp);
	}
}
