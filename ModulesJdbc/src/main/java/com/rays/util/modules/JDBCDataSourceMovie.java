package com.rays.util.modules;

import java.sql.Connection;
import java.util.ResourceBundle;

import com.mchange.v2.c3p0.ComboPooledDataSource;

//1. Provide Connection Re-useablity.
//2. Provide Reliable Connection with database.
//3. Provide Maximum Connection limitation with database.
public final class JDBCDataSourceMovie {

	// class type static variable having only one copy in lifetime
	private static final JDBCDataSourceMovie jdbc = null;

	private ComboPooledDataSource c = null;

	private static ResourceBundle r = ResourceBundle.getBundle("com.rays.bundle.modules.movie");

	// private constructor
	private JDBCDataSourceMovie() {
		c = new ComboPooledDataSource();
		try {
			c.setDriverClass(r.getString("driver"));
			c.setJdbcUrl(r.getString("url"));
			c.setUser(r.getString("user"));
			c.setPassword(r.getString("password"));
			// -----------------
			c.setMaxPoolSize(30);
			c.setInitialPoolSize(10);
			c.setMinPoolSize(10);
			c.setAcquireIncrement(5);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// getInstance method to get instance of class type
	private static JDBCDataSourceMovie getInstance() {
		if (jdbc == null) {
			return new JDBCDataSourceMovie();
		}
		return jdbc;
	}

	// get connection
	public static Connection getConnection() {
		try {
			return getInstance().c.getConnection();
		} catch (Exception e) {
			e.getMessage();
		}
		return null;

	}

	// transaction commit
	public static void trnCommit(Connection c) {
		if (c != null) {
			try {
				c.commit();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	// transaction rollback
	public static void trnRollBack(Connection c) {
		if (c != null) {
			try {
				c.rollback();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

	// close connection
	public static void closeConnection(Connection c) {
		if (c != null) {
			try {
				c.close();
			} catch (Exception e) {
				e.getMessage();
			}
		}
	}

}
