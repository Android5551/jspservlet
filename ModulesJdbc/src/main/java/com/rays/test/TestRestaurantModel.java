package com.rays.test;

import java.util.Iterator;
import java.util.List;

import com.rays.bean.RestaurantBean;
import com.rays.model.RestaurantModel;

public class TestRestaurantModel {
	public static RestaurantModel m = new RestaurantModel();
	public static void main(String[] args) {
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
	}
	
	private static void testSearch() {
		RestaurantBean b = new RestaurantBean();
		// b is null
		b.setItemName("C");
		List <RestaurantBean> l = m.search(b, 1, 5);
		Iterator<RestaurantBean> i = l.iterator();
		
		while(i.hasNext()) {
			b = i.next();
			System.out.println(b.getItemId());
			System.out.println(b.getItemName());
			System.out.println(b.getCategory());
			System.out.println(b.getPrice());
			System.out.println(b.getIsAvailable());
			System.out.println("---------");
		}
	}

	public static void testAdd() {
		RestaurantBean b = new RestaurantBean();
		b.setItemId(2);
		b.setItemName("Macroni Pizza");
		b.setCategory("Fast Food");
		b.setPrice(100);
		b.setIsAvailable(false);
		
		m.add(b);
	}
	
	public static void testUpdate() {
		RestaurantBean b = new RestaurantBean();
		b.setItemName("Tandoori Pizza");
		b.setCategory("Fast Food");
		b.setPrice(100);
		b.setIsAvailable(false);
		b.setItemId(2);
		m.update(b);
	}
	
	public static void testDelete() {
		m.delete(2);
	}
}
