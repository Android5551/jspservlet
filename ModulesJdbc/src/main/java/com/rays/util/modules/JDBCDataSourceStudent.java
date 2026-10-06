package com.rays.util.modules;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSourceStudent {
	private static final JDBCDataSourceStudent j = null;
	private static ComboPooledDataSource c = null;
	private static ResourceBundle r = ResourceBundle.getBundle("com.rays.bundle.modules.student");
	
	private JDBCDataSourceStudent() {
		c = new ComboPooledDataSource();
		try {
		c.setDriverClass(r.getString("driver"));
		c.setJdbcUrl(r.getString("url"));
		c.setUser(r.getString("user"));
		c.setPassword(r.getString("password"));
		c.setInitialPoolSize(10);
		c.setMinPoolSize(10);
		c.setAcquireIncrement(5);
		c.setMaxPoolSize(50);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static JDBCDataSourceStudent getInstance() {
		if(j == null) {
			return new JDBCDataSourceStudent();
		}
		else {
			return j;
		}
	}
	
	public static Connection getConnection() {
		try {
			return getInstance().c.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void trnCommit(Connection c) {
		try {
			c.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void trnRollback(Connection c) {
		try {
			c.rollback();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void closeConnection(Connection c) {
		try {
			c.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
