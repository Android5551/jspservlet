package com.rays.test;

import java.util.Iterator;
import java.util.List;

import com.rays.bean.MovieBean;
import com.rays.model.MovieModel;

public class TestMovieModel {
	public static MovieModel m = new MovieModel();
	
	public static void main(String[] args) {
//		testAdd();
//		testUpdate();
//		testDelete();
		testSearch();
	}

	private static void testAdd() {
		MovieBean b = new MovieBean();
		b.setMovieId(3);
		b.setTitle("3 Idiots");
		b.setGenre("Comedy");
		b.setDuration(3);
		b.setRating(4.9);
		
		m.add(b);
		
	}
	private static void testUpdate() {
		MovieBean b = new MovieBean();
		
		b.setTitle("Fast and Furious:4");
		b.setGenre("Action");
		b.setDuration(2);
		b.setRating(4.3);
		b.setMovieId(1);
		
		m.update(b);
		
	}
	
	private static void testDelete() {
		MovieBean b = new MovieBean();
		m.delete(1);
	}
	
	private static void testSearch() {
		MovieBean b = new MovieBean();
//		b.setTitle("T");
		b.setRating(4.9);
		List<MovieBean> l = m.search(b, 1, 10);
		Iterator<MovieBean> i = l.iterator();
		
		
		while(i.hasNext())
		{
			b = i.next();
			System.out.println(b.getMovieId());
			System.out.println(b.getTitle());
			System.out.println(b.getGenre());
			System.out.println(b.getRating());
			System.out.println(b.getDuration());
			System.out.println("----------");
		}
	}
	
	
}
