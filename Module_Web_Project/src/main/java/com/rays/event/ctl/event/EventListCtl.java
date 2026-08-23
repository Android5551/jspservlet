package com.rays.event.ctl.event;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.event.bean.EventBean;
import com.rays.event.model.EventModel;
import com.rays.event.util.ServletUtility;

@WebServlet("/EventListCtl")
public class EventListCtl extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	EventModel m = new EventModel();
	EventBean b = new EventBean();
	
	try {
		List <EventBean> l = m.search(b, 1, 20);
		request.setAttribute("list", l);
		
	}catch(Exception e) {
		e.getStackTrace();
	} 
	
	ServletUtility.forward("/event/EventListView.jsp", request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
