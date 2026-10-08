package com.rays.util.modules;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JDBCDataSourceHospital {
	private static final JDBCDataSourceHospital jdbc = null;
	private static ComboPooledDataSource cpds = null;
	
	ResourceBundle rb = ResourceBundle.getBundle("com.rays.bundle.modules.hospital");
	
	private JDBCDataSourceHospital() {
		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass(rb.getString("driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("user"));
			cpds.setPassword(rb.getString("password"));
			
			cpds.setMinPoolSize(10);
			cpds.setInitialPoolSize(10);
			cpds.setAcquireIncrement(5);
			cpds.setMaxPoolSize(40);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private static JDBCDataSourceHospital getInstance() {
		if(jdbc == null) {
			return new JDBCDataSourceHospital();
			
		}
		else {
			return jdbc;
		}
	}
	
	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void trnCommit(Connection c) {
		try {
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void trnRollback(Connection c) {
		try {
			c.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void closeConnection(Connection c) {
		try {
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
