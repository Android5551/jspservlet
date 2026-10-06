package com.rays.test;

import java.util.Iterator;
import java.util.List;

import com.rays.bean.StudentBean;
import com.rays.model.StudentModel;

public class TestStudentModel {
	public static StudentModel m = new StudentModel();
	public static void main(String[] args) {
		testAdd();
//		testUpdate();
//		testDelete();
//		testSearch();
	}
	
	public static void testAdd() {
		StudentBean b = new StudentBean();
		b.setStudentId(0);
		b.setName(null);
		b.setAge(0);
		b.setCourse(null);
		
		m.add(b);
	}
	public static void testUpdate() {
		StudentBean b = new StudentBean();
		b.setName(null);
		b.setAge(0);
		b.setCourse(null);
		b.setStudentId(0);
		
		m.update(b);
	}
	
	public static void testDelete() {
		m.delete(1);
		
	}
	
	public static List<StudentBean> testSearch(){
		StudentBean b = new StudentBean();
		List<StudentBean> l = m.search(null, 1, 5);
		Iterator <StudentBean> i = l.iterator();
		
		while(i.hasNext()) {
			b = i.next();
			System.out.println(b.getStudentId());
			System.out.println(b.getName());
			System.out.println(b.getAge());
			System.out.println(b.getCourse());
			System.out.println("----------");
		}
		return l;
		
	}
}
