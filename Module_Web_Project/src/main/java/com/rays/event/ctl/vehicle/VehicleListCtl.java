package com.rays.event.ctl.vehicle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.event.bean.EventBean;
import com.rays.event.bean.VehicleBean;
import com.rays.event.model.EventModel;
import com.rays.event.model.VehicleModel;
import com.rays.event.util.ServletUtility;

@WebServlet("/VehicleListCtl")
public class VehicleListCtl extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		VehicleModel m = new VehicleModel();
		VehicleBean b = new VehicleBean();
		
		try {
			List <VehicleBean> l = m.search(b, 1, 20);
			request.setAttribute("list", l);
			
		}catch(Exception e) {
			e.getStackTrace();
		} 
		
		ServletUtility.forward("/vehicle/VehicleListView.jsp", request, response);
		
		}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		}
	
}
