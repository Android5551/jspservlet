package com.rays.ctl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.rays.bean.UserBean;
import com.rays.model.UserModel;

@WebServlet("/LoginCtl")
public class LoginCtl extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String op = req.getParameter("operation");
		
		if(op!=null) {
			HttpSession s = req.getSession();
			s.invalidate();
		}
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		UserBean b = new UserBean();
		UserModel u = new UserModel();
		HttpSession s = req.getSession();
		
		String login = req.getParameter("login");
		String pass = req.getParameter("password");
		try {
			b = u.authenticate(login, pass);
			if(b!=null) {
				/* req.setAttribute("succ", "Logged In Succesfully!"); // no time to see this as welcome
				 * comes instantly*/ 
				s.setAttribute("user", b); /* here the bean is getting set to session.
				* as session is stored in browser we can get it from anywhere like from header.
				*/
				
				resp.sendRedirect("WelcomeCtl"); /* the older request was LoginCtl's; 
				* here new 
				* request will get created as we are going from current ctl to welcomeCtl once user
				* gets logged in */
				return; /* now we don't want to create another request on line no. 63 otherwise these 2 get
				* conflicted and we get 500 error */ 
				
			} else {
				req.setAttribute("err", "Invalid Login Credentials!");
			}
			
		} catch (Exception e) {
			e.getStackTrace();
		}
		/* if request has set attribute; to get attribute we run the following line 
		* and it gets forwarded to LoginView from there we get attribute
		*/
		RequestDispatcher rd = req.getRequestDispatcher("LoginView.jsp");
		rd.forward(req, resp);
	}
}
