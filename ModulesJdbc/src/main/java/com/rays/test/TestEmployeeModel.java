package com.rays.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;

import com.rays.bean.EmployeeBean;
import com.rays.model.EmployeeModel;

public class TestEmployeeModel {
	public static EmployeeModel m = new EmployeeModel();
	public static SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
	
	public static void main(String[] args) throws ParseException {
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
	}


	private static void testSearch() {
		EmployeeBean b = new EmployeeBean();
		
		 List<EmployeeBean> l = m.search(b, 1, 10);
		 Iterator<EmployeeBean> i = l.iterator();
		 
		 while(i.hasNext()) {
			 b = i.next();
			 System.out.println(b.getEmployeeId()); 
			 System.out.println(b.getName());
			 System.out.println(b.getDepartment());
			 System.out.println(b.getSalary());
			 System.out.println(b.getJoiningDate());
			 System.out.println("-----------");
		 }
		
	}


	public static void testAdd() throws ParseException {
		EmployeeBean b = new EmployeeBean();
		b.setEmployeeId(3);
		b.setName("shyam");
		b.setDepartment("HR");
		b.setSalary(30000);
		b.setJoiningDate(s.parse("2009-03-19"));
		m.add(b);
	}
	public static void testUpdate() throws ParseException {
		EmployeeBean b = new EmployeeBean();
		
		b.setName("Xavier");
		b.setDepartment("Sales");
		b.setSalary(50000);
		b.setJoiningDate(s.parse("2019-03-19"));
		b.setEmployeeId(2);
		m.update(b);
	}
	public static void testDelete() {
		m.delete(2);
	}
	

}
