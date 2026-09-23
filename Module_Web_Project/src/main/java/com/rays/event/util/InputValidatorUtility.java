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
	
	// Vehicle validator
		public static boolean vehicleValidator(HttpServletRequest request) {
		
			
//			private long vehicleId;
//			private String vehicleName;
//			private String model;
//			private String color;
//			private double price;
			
			String vehicleName = request.getParameter("vehicleName");
			String model = request.getParameter("model");
			String color = request.getParameter("color");
			String price = request.getParameter("price");
			
			//set pass to true
			boolean pass = true;
			
			if (vehicleName.equals("")) {
				pass = false;
				request.setAttribute("vehicleName", "vehicleName is required");
			}
			else if (!vehicleName.matches("[A-Z a-z ]+")) {
				pass = false;
				request.setAttribute("vehicleName", "vehicleName must be in alphabets");
			}
			if (model.equals("")) {
				pass = false;
				request.setAttribute("model", "model is required");
			}
			else if (!model.matches("[A-Z a-z ]+")) {
				pass = false;
				request.setAttribute("model", "model must be in alphabets");
			}
			
			if (color.equals("")) {
				pass = false;
				request.setAttribute("color", "color is required");
			}
			else if (!color.matches("[A-Z a-z ]+")) {
				pass = false;
				request.setAttribute("color", "color must be in alphabets");
			}
			if (price.equals("")) {
				pass = false;
				request.setAttribute("price", "price is required");
			}
			else if (price.matches("[A-Z a-z ]+")) {
				pass = false;
				request.setAttribute("price", "price must be in numericals");
			}
			
			return pass;
		}
		
//		// Doctor validator
//				public static boolean doctorValidator(HttpServletRequest request) {
//				
//					
////					private long doctorId;
////					private String doctorName;
////					private String specialization;
////					private int experience;
////					private String contactNo;
//					
//					String doctorName = request.getParameter("doctorName");
//					String specialization = request.getParameter("specialization");
//					String experience = request.getParameter("experience");
//					String contactNo = request.getParameter("contactNo");
//					
//					
//					//set pass to true
//					boolean pass = true;
//					
//					if (doctorName.equals("")) {
//						pass = false;
//						request.setAttribute("doctorName", "doctorName is required");
//					}
//					else if (!doctorName.matches("[A-Z a-z ]+")) {
//						pass = false;
//						request.setAttribute("doctorName", "doctorName must be in alphabets");
//					}
//					if (model.equals("")) {
//						pass = false;
//						request.setAttribute("model", "model is required");
//					}
//					else if (!model.matches("[A-Z a-z ]+")) {
//						pass = false;
//						request.setAttribute("model", "model must be in alphabets");
//					}
//					
//					if (color.equals("")) {
//						pass = false;
//						request.setAttribute("color", "color is required");
//					}
//					else if (!color.matches("[A-Z a-z ]+")) {
//						pass = false;
//						request.setAttribute("color", "color must be in alphabets");
//					}
//					if (price.equals("")) {
//						pass = false;
//						request.setAttribute("price", "price is required");
//					}
//					else if (price.matches("[A-Z a-z ]+")) {
//						pass = false;
//						request.setAttribute("price", "price must be in numericals");
//					}
//					
//					return pass;
//				}
//
		}