package com.rays.util.modules;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSourceLibrary {
	private static final JDBCDataSourceLibrary j = null; // can't assign value other than null
	private static ComboPooledDataSource c = null;

	ResourceBundle r = ResourceBundle.getBundle("com.rays.bundle.modules.library");

	private JDBCDataSourceLibrary() {
		c = new ComboPooledDataSource();
		try {
			c.setDriverClass(r.getString("driver"));
			c.setJdbcUrl(r.getString("url"));
			c.setUser(r.getString("user"));
			c.setPassword(r.getString("password"));
			c.setInitialPoolSize(10);
			c.setMinPoolSize(10);
			c.setAcquireIncrement(5);
			c.setMaxPoolSize(30);
		}	catch (Exception e) {
			e.getMessage();
		}
	}
	
	private static JDBCDataSourceLibrary getInstance() {
		if(j == null) {
			return new JDBCDataSourceLibrary();
		}
		else {
			return j;
		}
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
	public static void closeConnection(Connection c) {
		try {
			c.close();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	
}
