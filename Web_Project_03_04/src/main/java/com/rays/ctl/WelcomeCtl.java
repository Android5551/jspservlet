package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.util.ServletUtility;

@WebServlet("/WelcomeCtl")
public class WelcomeCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher rd = req.getRequestDispatcher("WelcomeView.jsp");
//		rd.forward(req, resp);
		ServletUtility.forward("WelcomeView.jsp", req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		RequestDispatcher rd = req.getRequestDispatcher("WelcomeView.jsp");
//		rd.forward(req, resp);
		ServletUtility.forward("WelcomeView.jsp", req, resp);
	}
}
