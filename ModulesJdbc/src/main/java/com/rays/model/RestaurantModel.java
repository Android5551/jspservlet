package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.RestaurantBean;
import com.rays.util.JDBCDataSource;

public class RestaurantModel {
	public void add(RestaurantBean b) {
		Connection c = null;
		try {
			c = JDBCDataSource.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("insert into " + "restaurant values(?,?,?,?,?)");
			p.setInt(1, b.getItemId());
			p.setString(2, b.getItemName());
			p.setString(3, b.getCategory());
			p.setDouble(4, b.getPrice());
			p.setBoolean(5, b.getIsAvailable());

			int i = p.executeUpdate();
			System.out.println(i + " row inserted!");

			JDBCDataSource.trnCommit(c);

		} catch (Exception e) {
			JDBCDataSource.trnRollBack(c);
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(c);
		}
	}

	// --------------------Update --------------
	public void update(RestaurantBean b) {
		Connection c = null;
		try {
			c = JDBCDataSource.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("update " + "restaurant set item_name=?," + "category=?,"
					+ "price=?, is_available=? where item_id=?");
			p.setString(1, b.getItemName());
			p.setString(2, b.getCategory());
			p.setDouble(3, b.getPrice());
			p.setBoolean(4, b.getIsAvailable());
			p.setInt(5, b.getItemId());

			int i = p.executeUpdate();
			System.out.println(i + " row updated!");
			JDBCDataSource.trnCommit(c);
		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(c);
		} finally {
			JDBCDataSource.closeConnection(c);
		}
	}

	// ---------------delete---------------
	public void delete(int itemId) {
		Connection c = null;
		try {
			c = JDBCDataSource.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("delete from restaurant where " + "itemId=?");
			p.setInt(1, itemId);
			int i = p.executeUpdate();
			System.out.println(i + " row deleted!");
			JDBCDataSource.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSource.trnRollBack(c);
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(c);
		}
	}

	// -------- search -----------
	public List<RestaurantBean> search(RestaurantBean b, int pageNo, int pageSize) {
		Connection c = null;
		List<RestaurantBean> l = new ArrayList<RestaurantBean>();
		StringBuffer s = new StringBuffer("select * from restaurant where "
				+ "1=1 ");
		if(b!=null) {
			if(b.getItemName()!=null && b.getItemName().length()>0) {
				s.append(" and item_name like '"+b.getItemName()+"%' ");
			}
		}
		if(pageSize>0) {
			int index = (pageNo - 1) * pageSize;
			s.append("limit "+index+", "+pageSize);
		}
		try {
		c = JDBCDataSource.getConnection();
		PreparedStatement p = c.prepareStatement(s.toString());
		ResultSet r = p.executeQuery();
		
		while(r.next()) {
			b = new RestaurantBean();
			b.setItemId(r.getInt("item_id"));;
			b.setItemName(r.getString("item_name"));
			b.setCategory(r.getString("category"));
			b.setPrice(r.getDouble("price"));
			b.setIsAvailable(r.getBoolean("is_available"));
			System.out.println("added in the list");
			l.add(b);
		}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(c);
		}
		return l;
	}
}
