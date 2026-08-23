package com.rays.event.ctl.event;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.event.bean.EventBean;
import com.rays.event.model.EventModel;
import com.rays.event.util.InputValidatorUtility;
import com.rays.event.util.ServletUtility;

@WebServlet("/EventCtl")
public class EventCtl extends HttpServlet {
	
	
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request method ->" + req.getMethod());
		if(req.getMethod().equalsIgnoreCase("POST")) {
			if(InputValidatorUtility.eventValidator(req) == false) {
				ServletUtility.forward("/event/EventView.jsp", req, resp); return; 
				} 
			}
	super.service(req, resp); 
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("/event/EventView.jsp", request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		EventBean bean = new EventBean();
		EventModel model = new EventModel();

		String eventName = request.getParameter("eventName");
		String eventDate = request.getParameter("eventDate");
		String venue = request.getParameter("venue");
		String organizer = request.getParameter("organizer");

//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			bean.setEventName(eventName);
			bean.setEventDate(sdf.parse(eventDate));
			bean.setVenue(venue);
			bean.setOrganizer(organizer);
			model.add(bean);

			request.setAttribute("successMsg", "Event added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "Event already exists");
			e.printStackTrace();
		}

		ServletUtility.forward("/event/EventView.jsp", request, response);

	}

}