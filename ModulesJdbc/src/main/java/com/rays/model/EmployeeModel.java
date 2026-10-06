package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.EmployeeBean;
import com.rays.util.modules.JDBCDataSourceEmployee;

public class EmployeeModel {
	public void add(EmployeeBean b) {
		Connection c = null;
		try {
			c = JDBCDataSourceEmployee.getConnection();
			c.setAutoCommit(false);
			
			PreparedStatement p = c.prepareStatement("insert "
					+ "into employee values(?,?,?,?,?)");
			p.setInt(1, b.getEmployeeId());
			p.setString(2, b.getName());
			p.setString(3, b.getDepartment());
			p.setDouble(4, b.getSalary());
			p.setDate(5, new java.sql.Date(b.getJoiningDate().getTime()));
			
			int i = p.executeUpdate();
			System.out.println(i+ " row inserted!");
			JDBCDataSourceEmployee.trnCommit(c);
		
		} catch (Exception e) {
			JDBCDataSourceEmployee.trnRollback(c);
			e.getMessage();
		} finally {
			JDBCDataSourceEmployee.close(c);
		}
	}
	
	// ----------------------
	public void update(EmployeeBean b) {
		Connection c = null;
		try {
			c = JDBCDataSourceEmployee.getConnection();
			c.setAutoCommit(false);
			
			PreparedStatement p = c.prepareStatement("update "
					+ "employee set name = ?"
					+ ", department=?, salary=?, joining_date=? "
					+ "where employee_id=?");
			
			p.setString(1, b.getName());
			p.setString(2, b.getDepartment());
			p.setDouble(3, b.getSalary());
			p.setDate(4, new java.sql.Date(b.getJoiningDate().getTime()));
			p.setInt(5, b.getEmployeeId());
			
			int i = p.executeUpdate();
			System.out.println(i+" row updated!");
			JDBCDataSourceEmployee.trnCommit(c);
			
		} catch (Exception e) {
			JDBCDataSourceEmployee.trnRollback(c);
			e.getMessage();
		} finally {
			JDBCDataSourceEmployee.close(c);
		}
	}
		
		// ----------------------
		
		public void delete(int employeeId) {
			Connection c = null;
			try {
				c = JDBCDataSourceEmployee.getConnection();
				c.setAutoCommit(false);
				PreparedStatement p = c.prepareStatement("delete "
						+ "from employee where employee_id=?");
				p.setInt(1, employeeId);
				
				int i = p.executeUpdate();
				System.out.println(i+ " row deleted!");
				JDBCDataSourceEmployee.trnCommit(c);
			} catch (Exception e) {
				JDBCDataSourceEmployee.trnRollback(c);
				e.getMessage();
			} finally {
				JDBCDataSourceEmployee.close(c);
			}
			
		}
		
		// ---------
	
		public List<EmployeeBean> search(EmployeeBean b, int pageNo, int pageSize){
			Connection c = null;
			List<EmployeeBean> l = new ArrayList<EmployeeBean>();
			StringBuffer s = new StringBuffer("select * from "
					+ "employee where 1=1 ");
			if(b!=null) {
				if(b.getName()!=null && b.getName().length()>0) {
					s.append(" and name like '"+b.getName()+"%' ");
				}
				if(b.getDepartment()!=null && b.getDepartment().length()>0) {
					s.append(" and department like '"+b.getDepartment()+"%' ");
				}
				if(b.getSalary()!=0) {
					s.append(" and salary like '"+b.getSalary()+"%' ");
				}
				if(b.getJoiningDate()!=null && b.getJoiningDate().getTime()>0) {
					s.append(" and joining_date like '"+b.getJoiningDate()+"%' ");
				}
			}
			if(pageSize>0) {
				int index = (pageNo - 1) * pageSize;
				s.append("limit "+index+", "+pageSize);
				
			}
			
			try {
				c = JDBCDataSourceEmployee.getConnection();
				PreparedStatement p = c.prepareStatement(s.toString());
				ResultSet r = p.executeQuery();
				
				while(r.next()) {
					b = new EmployeeBean();
					b.setEmployeeId(r.getInt("employee_id"));
					b.setName(r.getString("name"));
					b.setDepartment(r.getString("department"));
					b.setSalary(r.getDouble("salary"));
					b.setJoiningDate(new java.sql.Date(r.getDate("joining_date").getTime()));
					l.add(b);
				}
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return l;
		
		}
		
	}
	
	
	

