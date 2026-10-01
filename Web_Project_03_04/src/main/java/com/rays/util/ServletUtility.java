package com.rays.util;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletUtility {
	// Error Messages
	// set
	public static void setErrMsg(String msg, HttpServletRequest req) {
		req.setAttribute("errMsg", msg);
	}

	
	// get
	public static String getErrMsg(HttpServletRequest req) {
		String errMsg =  (String) req.getAttribute("errMsg");
		if (errMsg!=null) {
			return errMsg;
		}
		return "";
	}
	
	// Success message
	// set
	public static void setSuccMsg(String msg, HttpServletRequest req) {
		req.setAttribute("succMsg", msg);
	}
	
	// get 
	public static String getSuccMsg(HttpServletRequest req) {
		String succMsg = (String) req.getAttribute("succMsg");
		if(succMsg != null) {
			return succMsg;
		}
		return "";
	}
	// Forward to Controller's own view
	public static void forward(String page, HttpServletRequest req, HttpServletResponse res) {
		RequestDispatcher rd = req.getRequestDispatcher("UserRegistrationView.jsp");
		try {
		rd.forward(req, res); // forward method used to forward same request to it's own view
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
