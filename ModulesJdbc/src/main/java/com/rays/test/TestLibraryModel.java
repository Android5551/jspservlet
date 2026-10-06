package com.rays.test;

import java.util.Iterator;
import java.util.List;

import com.rays.bean.LibraryBean;
import com.rays.model.LibraryModel;

public class TestLibraryModel {
	public static LibraryModel m = new LibraryModel();
	public static void main(String[] args) {
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
	}
	public static void testAdd() {
		LibraryBean b = new LibraryBean();
		b.setBookId(3);
		b.setAuthor("Dale Carnegie");
		b.setTitle("How to win friends");
		b.setPrice(500.98);
		b.setAvailability(true);
		
		m.add(b);
	}
	public static void testUpdate() {
		LibraryBean b = new LibraryBean();
		
		b.setAuthor("Benjamin");
		b.setTitle("Intelligent Investor");
		b.setPrice(999);
		b.setAvailability(false);
		b.setBookId(2);
		
		m.update(b);
	}
	
	public static void testDelete() {
		m.delete(3);
	}
	
	public static List<LibraryBean> testSearch(){
		LibraryBean b = new LibraryBean();
		b.setAuthor("D");
		List<LibraryBean> l = m.search(b, 1, 10);
		Iterator<LibraryBean> i = l.iterator();
		while(i.hasNext()) {
			b= i.next();
			System.out.println(b.getBookId());
			System.out.println(b.getTitle());
			System.out.println(b.getPrice());
			System.out.println(b.getAuthor());
			System.out.println(b.getAvailability());
		}
		return l;
		
		
	}

}
