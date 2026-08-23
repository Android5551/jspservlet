package com.rays.event.util;

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
	
	// event validator
	public static boolean eventValidator(HttpServletRequest request) {
		/*
		 * private long eventId; private String eventName; private Date eventDate;
		 * private String venue; private String organizer
		 */
		String eventName = request.getParameter("eventName");
		String eventDate = request.getParameter("eventDate");
		String venue = request.getParameter("venue");
		String organizer = request.getParameter("organizer");
		
		//set pass to true
		boolean pass = true;
		
		if (eventName.equals("")) {
			pass = false;
			request.setAttribute("eventName", "eventName is required");
		}
		else if (!eventName.matches("[A-Z a-z ]+")) {
			pass = false;
			request.setAttribute("eventName", "eventName must be in alphabets");
		}
		if (eventDate.equals("")) {
			pass = false;
			request.setAttribute("eventDate", "eventDate is required");
		}
		
		if (venue.equals("")) {
			pass = false;
			request.setAttribute("venue", "venue is required");
		}
		else if (!venue.matches("[A-Z a-z ]+")) {
			pass = false;
			request.setAttribute("venue", "venue must be in alphabets");
		}
		if (organizer.equals("")) {
			pass = false;
			request.setAttribute("organizer", "organizer is required");
		}
		else if (!organizer.matches("[A-Z a-z ]+")) {
			pass = false;
			request.setAttribute("organizer", "organizer must be in alphabets");
		}
		
		return pass;
	}

}