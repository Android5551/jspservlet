package com.rays.util.modules;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSourceEmployee {
	private final static JDBCDataSourceEmployee jdbc = null;
	private static ComboPooledDataSource c = null;

	private static ResourceBundle r = ResourceBundle.getBundle("com.rays.bundle.modules.movie");

	private JDBCDataSourceEmployee() {
		c = new ComboPooledDataSource();
		try {
			c.setDriverClass(r.getString("driver"));
			c.setJdbcUrl(r.getString("url"));
			c.setUser(r.getString("user"));
			c.setPassword(r.getString("password"));
			c.setInitialPoolSize(10);
			c.setMinPoolSize(10);
			c.setMaxPoolSize(30);
			c.setAcquireIncrement(5);

		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	
	private static JDBCDataSourceEmployee getInstance() {
		if (jdbc==null) {
			return new JDBCDataSourceEmployee();
		}
		return jdbc;
		
	}
	
	public static Connection getConnection() {
		try {
			return getInstance().c.getConnection();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
	
	public static void trnCommit(Connection c) {
		try {
			c.commit();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public static void trnRollback(Connection c) {
		try {
			c.rollback();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	public static void close(Connection c) {
		try {
			c.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
}
