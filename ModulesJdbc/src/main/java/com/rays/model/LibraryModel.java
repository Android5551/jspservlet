package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.LibraryBean;
import com.rays.util.modules.JDBCDataSourceLibrary;

public class LibraryModel {
	public void add(LibraryBean b) {
		Connection c = null;
		try {
			c = JDBCDataSourceLibrary.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("insert into library values(?,?,?,?,?)");
			p.setInt(1, b.getBookId());
			p.setString(2, b.getTitle());
			p.setString(3, b.getAuthor());
			p.setDouble(4, b.getPrice());
			p.setBoolean(5, b.getAvailability());
			
			int i = p.executeUpdate();
			System.out.println(i+" row inserted!");
			JDBCDataSourceLibrary.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceLibrary.trnRollback(c);
			e.getMessage();
		} finally {
			JDBCDataSourceLibrary.closeConnection(c);
		}
	}
	
	public void update(LibraryBean b) {
		Connection c = null;
		try {
			c = JDBCDataSourceLibrary.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("update "
					+ "library set title=?, author=?, price=?,"
					+ "availability=? where book_id=?");
			p.setString(1, b.getTitle());
			p.setString(2, b.getAuthor());
			p.setDouble(3, b.getPrice());
			p.setBoolean(4, b.getAvailability());
			p.setInt(5, b.getBookId());
			
			int i = p.executeUpdate();
			System.out.println(i+" row updated!");
			JDBCDataSourceLibrary.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceLibrary.trnRollback(c);
			e.getMessage();
		} finally {
			JDBCDataSourceLibrary.closeConnection(c);
		}
	}
	
	public void delete(int bookId) {
		Connection c = null;
		try {
			c = JDBCDataSourceLibrary.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("delete from library where book_id=?");
			p.setInt(1, bookId);
			
			int i = p.executeUpdate();
			System.out.println(i+" row deleted!");
			JDBCDataSourceLibrary.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceLibrary.trnRollback(c);
			e.printStackTrace();
		} finally {
			JDBCDataSourceLibrary.closeConnection(c);
		}
	}
	
	public List<LibraryBean> search(LibraryBean b,int pageNo, int pageSize){
		Connection c = null;
		List<LibraryBean> l = new ArrayList<LibraryBean>();
		StringBuffer s = new StringBuffer("select * from library where 1=1");
		if(b!= null) {
			if(b.getTitle()!= null && b.getTitle().length()>0) {
				s.append(" and title like '"+b.getTitle()+"%' ");
			}
			if(b.getAuthor()!=null && b.getAuthor().length()>0) {
				s.append(" and author like '"+b.getAuthor()+"%' ");
			}
			if(b.getPrice()!=0) {
				s.append(" and price like '"+b.getPrice()+"%' ");
			}
		
		}
		if(pageSize > 0) {
			int index = (pageNo - 1)* pageSize;
			s.append("limit "+index+", "+pageSize);
		}
		
		try {
			c = JDBCDataSourceLibrary.getConnection();
			PreparedStatement p = c.prepareStatement(s.toString());
			ResultSet r = p.executeQuery();
			while(r.next()) {
				b = new LibraryBean();
				b.setBookId(r.getInt("book_id"));
				b.setTitle(r.getString("title"));
				b.setAuthor(r.getString("author"));
				b.setPrice(r.getDouble("price"));
				b.setAvailability(r.getBoolean("availablity"));
				l.add(b);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSourceLibrary.closeConnection(c);
		}
		return l;
		
	}
}
