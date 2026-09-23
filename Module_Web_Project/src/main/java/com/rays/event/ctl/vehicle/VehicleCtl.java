package com.rays.event.ctl.vehicle;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rays.event.bean.VehicleBean;
import com.rays.event.model.VehicleModel;
import com.rays.event.util.InputValidatorUtility;
import com.rays.event.util.ServletUtility;


@WebServlet("/VehicleCtl")
public class VehicleCtl extends HttpServlet {
	@Override 
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("request method ->" + req.getMethod());
		if(req.getMethod().equalsIgnoreCase("POST")) {
			if(InputValidatorUtility.vehicleValidator(req) == false) {
				ServletUtility.forward("/vehicle/VehicleView.jsp", req, resp); return; 
				} 
			}
	super.service(req, resp); 
	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doGet() method");

		ServletUtility.forward("/vehicle/VehicleView.jsp", request, response);

	}
//	private long vehicleId;
//	private String vehicleName;
//	private String model;
//	private String color;
//	private double price;
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("this is doPost() method");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		VehicleBean b = new VehicleBean();
		VehicleModel m = new VehicleModel();

		String vehicleName = request.getParameter("vehicleName");
		String model = request.getParameter("model");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		double dPrice = Double.parseDouble(price);
//		System.out.println(firstName + "\n" + lastName + "\n" + login + "\n" + password + "\n" + dob);

		try {

			b.setVehicleName(vehicleName);
			b.setModel(model);
			b.setColor(color);
			b.setPrice(dPrice);
			m.add(b);

			request.setAttribute("successMsg", "vehicle added successfully");

		} catch (Exception e) {
			request.setAttribute("errorMsg", "vehicle already exists");
			e.printStackTrace();
		}

		ServletUtility.forward("/vehicle/VehicleView.jsp", request, response);

	}

}

