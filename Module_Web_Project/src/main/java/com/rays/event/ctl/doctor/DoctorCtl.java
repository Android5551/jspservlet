//package com.rays.event.ctl.doctor;
//
//import java.awt.im.InputContext;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import com.rays.event.bean.DoctorBean;
//import com.rays.event.model.DoctorModel;
//import com.rays.event.util.InputValidatorUtility;
//import com.rays.event.util.ServletUtility;
//
//@WebServlet("/DoctorCtl")
//public class DoctorCtl extends HttpServlet{
//	@Override
//	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("request method ->"+req.getMethod());
//		if(req.getMethod().equalsIgnoreCase("POST")) {
//			if(InputValidatorUtility.doctorValidator(req)==false) {
//				ServletUtility.forward("/doctor/DoctorViw.jsp", req, resp);
//				return;
//			}
//		}
//		super.service(req, resp);
//	}
//	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("this is doGet() method");
//		ServletUtility.forward("/doctor/DoctorView.jsp", req, resp);
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		System.out.println("this is doPost() method");
//		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
//		DoctorBean d = new DoctorBean();
//		DoctorModel m = new DoctorModel();
//		
//		
//		
//	}
//}
