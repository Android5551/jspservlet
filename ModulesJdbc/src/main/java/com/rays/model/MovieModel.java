package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;
import com.rays.bean.MovieBean;
import com.rays.util.modules.JDBCDataSourceMovie;

public class MovieModel {
	public void add(MovieBean b) {
		Connection c = null;
		try {
			c = JDBCDataSourceMovie.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("insert into " + "movie values(?,?,?,?,?)");
			p.setInt(1, b.getMovieId());
			p.setString(2, b.getTitle());
			p.setString(3, b.getGenre());
			p.setInt(4, b.getDuration());
			p.setDouble(5, b.getRating());

			int i = p.executeUpdate();
			System.out.println(i + " row inserted!");

			JDBCDataSourceMovie.trnCommit(c);

		} catch (Exception e) {
			JDBCDataSourceMovie.trnRollBack(c);
			e.printStackTrace();
		} finally {
			JDBCDataSourceMovie.closeConnection(c);
		}
	}

	public void update(MovieBean b) {
		Connection c = null;
		try {
			c = JDBCDataSourceMovie.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement(
					"update movie "
			+"set title=?,genre=?,duration=?,rating=? "
							+ "where movie_id=?");
			p.setString(1, b.getTitle());
			p.setString(2, b.getGenre());
			p.setInt(3, b.getDuration());
			p.setDouble(4, b.getRating());
			p.setInt(5, b.getMovieId());

			int i = p.executeUpdate();
			System.out.println(i + " row updated!");

			JDBCDataSourceMovie.trnCommit(c);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSourceMovie.trnRollBack(c);
		} finally {
			JDBCDataSourceMovie.closeConnection(c);
		}
	}

	public void delete(int movieId) {
		Connection c = null;
		try {
			c = JDBCDataSourceMovie.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("delete from movie " + "where movie_id=?");

			p.setInt(1, movieId);

			int i = p.executeUpdate();
			System.out.println(i + " row deleted!");

			JDBCDataSourceMovie.trnCommit(c);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSourceMovie.trnRollBack(c);
		} finally {
			JDBCDataSourceMovie.closeConnection(c);
		}
	}
/*
 * p.setInt(1, b.getMovieId());
			p.setString(2, b.getTitle());
			p.setString(3, b.getGenre());
			p.setInt(4, b.getDuration());
			p.setDouble(5, b.getRating());
 * */
	public List<MovieBean> search(MovieBean b, int pageNo, int pageSize) {
		Connection c = null;
		List<MovieBean> l = new ArrayList<MovieBean>();
		// getWhereClause()
		StringBuffer s = new StringBuffer("select * from movie "
				+ "where 1=1 ");
		
		if(b!=null) {
			if(b.getTitle()!=null && b.getTitle().length()>0) {
				s.append(" and title like '"+b.getTitle()+"%' ");
			}
			if(b.getGenre()!=null && b.getGenre().length()>0) {
				s.append(" and genre like '"+b.getGenre()+"%' ");
			}
			if(b.getDuration()!=0) {
				s.append(" and duration like '"+b.getDuration()+"%' ");
			}
			if(b.getRating()!=0.0) {
				s.append(" and rating like '"+b.getRating()+"%' ");
			}
			
		}
		
		if(pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			s.append("limit "+index+", "+pageSize);
		}
		
		try {
			c = JDBCDataSourceMovie.getConnection();
			PreparedStatement p = c.prepareStatement(s.toString());
			ResultSet r = p.executeQuery();
			
			while(r.next()) {
				b = new MovieBean();
				b.setMovieId(r.getInt("movie_id"));
				b.setTitle(r.getString("title"));
				b.setGenre(r.getString("genre"));
				b.setDuration(r.getInt("duration"));
				b.setRating(r.getDouble("rating"));
				l.add(b);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSourceMovie.closeConnection(c);
		}
		
		
		return l;
	}
}
