package com.rays.test;

import java.util.Iterator;
import java.util.List;

import com.rays.bean.HospitalBean;
import com.rays.model.HospitalModel;

public class TestHospitalModel {
	public static HospitalModel m = new HospitalModel();
	public static void main(String[] args) {
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
	}
	
	private static void testAdd() {
		HospitalBean b = new HospitalBean();
		b.setPatientId(3);
		b.setName("Sandesh");
		b.setAge(31);
		b.setBloodGroup("O-");
		b.setDisease("Skin Cancer");
		m.add(b);
	}
	
	private static void testUpdate() {
		HospitalBean b = new HospitalBean();
		b.setName("Yogi");
		b.setAge(61);
		b.setBloodGroup("AB+");
		b.setDisease("Anemia");
		b.setPatientId(2);
		m.update(b);
	}
	
	private static void testDelete() {
		m.delete(3);
	}
	
	private static void testSearch() {
		HospitalBean b = new HospitalBean();
		b.setName("Y");
		List<HospitalBean> l = m.search(b, 1, 5);
		Iterator<HospitalBean> i = l.iterator();
		
		while(i.hasNext()) {
			b = i.next();
			System.out.println(b.getPatientId());
			System.out.println(b.getName());
			System.out.println(b.getAge());
			System.out.println(b.getBloodGroup());
			System.out.println(b.getDisease());
			System.out.println("-------------");
		}
		
	}

}
