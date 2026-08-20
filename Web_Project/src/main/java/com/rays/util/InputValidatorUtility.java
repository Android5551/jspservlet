package com.rays.util;

import javax.servlet.http.HttpServletRequest;

public class InputValidatorUtility {

	public static boolean loginValidator(HttpServletRequest request) {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		boolean pass = true;

		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "loginId is required");
		}

		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		} 
		else if (password.length() < 8 || password.length() > 12) { 
			pass = false; 
			request.setAttribute("password","password length should be > 8 or == 12"); 
			}
		 
		return pass;

	}
	
	// user validator
	public static boolean userValidator(HttpServletRequest request) {
		/*firstName
		lastName
		login
		password
		dob*/
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String dob = request.getParameter("dob");
		
		//set pass to true
		boolean pass = true;
		
		if (firstName.equals("")) {
			pass = false;
			request.setAttribute("firstName", "firstName is required");
		}
		else if (!firstName.matches("[A-Z a-z ]+")) {
			pass = false;
			request.setAttribute("firstName", "firstName must be in alphabets");
		}
		if (lastName.equals("")) {
			pass = false;
			request.setAttribute("lastName", "lastName is required");
		}
		else if (!lastName.matches("[A-Z a-z ]+")) {
			pass = false;
			request.setAttribute("lastName", "lastName must be in alphabets");
		}
		if (login.equals("")) {
			pass = false;
			request.setAttribute("login", "login is required");
		}
		if (password.equals("")) {
			pass = false;
			request.setAttribute("password", "password is required");
		}
		else if (password.length() < 8 || password.length() > 12) { 
			pass = false; 
			request.setAttribute("password","password length should be > 8 or == 12"); 
			}
		if (dob.equals("")) {
			pass = false;
			request.setAttribute("dob", "dob is required");
		}
		
		
		
		return pass;
	}
	

}