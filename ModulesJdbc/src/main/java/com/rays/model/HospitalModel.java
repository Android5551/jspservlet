package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.HospitalBean;
import com.rays.util.modules.JDBCDataSourceHospital;

public class HospitalModel {
	public void add(HospitalBean bean) {
		Connection c = null;
		try {
			c = JDBCDataSourceHospital.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("insert "
					+ "into hospital values(?,?,?,?,?)");
			p.setInt(1, bean.getPatientId());
			p.setString(2, bean.getName());
			p.setInt(3, bean.getAge());
			p.setString(4, bean.getBloodGroup());
			p.setString(5, bean.getDisease());
			
			int i = p.executeUpdate();
			System.out.println(i+" row inserted!");
			JDBCDataSourceHospital.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceHospital.trnRollback(c);
			e.printStackTrace();
		} finally {
			JDBCDataSourceHospital.closeConnection(c);
		}
	}
	
	public void update(HospitalBean bean) {
		Connection c = null;
		try {
			c = JDBCDataSourceHospital.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("update hospital set name=?,"
					+ "age=?, blood_group=?, disease=? where "
					+ "patient_id=?");
			p.setString(1, bean.getName());
			p.setInt(2, bean.getAge());
			p.setString(3, bean.getBloodGroup());
			p.setString(4, bean.getDisease());
			p.setInt(5, bean.getPatientId());
			
			int i = p.executeUpdate();
			System.out.println(i+" row updated!");
			JDBCDataSourceHospital.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceHospital.trnRollback(c);
			e.printStackTrace();
		}finally {
			JDBCDataSourceHospital.closeConnection(c);
		}
	}
	
	public void delete(int patientId) {
		Connection c = null;
		try {
			c = JDBCDataSourceHospital.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("delete from hospital where "
					+ "patient_id=?");
			p.setInt(1, patientId);
			int i = p.executeUpdate();
			System.out.println(i+" row deleted!");
			JDBCDataSourceHospital.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceHospital.trnRollback(c);
			e.printStackTrace();
			
		}finally {
			JDBCDataSourceHospital.closeConnection(c);
		}
	}
	
	public List<HospitalBean> search(HospitalBean bean, int pageNo, int pageSize){
		Connection c = null;
		List<HospitalBean> l = new ArrayList<HospitalBean>();
		StringBuffer sql = new StringBuffer("select * from "
				+ "hospital where 1=1");
		if(bean!=null) {
			if(bean.getName()!=null && bean.getName().length()>0) {
				sql.append(" and name like '"+bean.getName()+"%' ");
			}
			if(bean.getAge()!=0) {
				sql.append(" and age like '"+bean.getAge()+"%' ");
			}
			if(bean.getBloodGroup()!=null && bean.getBloodGroup().length()>0) {
				sql.append(" and blood_group like '"+bean.getBloodGroup()+"%' ");
			}
			if(bean.getDisease()!=null && bean.getDisease().length()>0) {
				sql.append(" and disease like '"+bean.getDisease()+"%' ");
			}
		}
		if(pageSize>0) {
			int index = (pageNo - 1) * pageSize;
			sql.append(" limit "+index+", "+pageSize);
		}
		
		try {
			c = JDBCDataSourceHospital.getConnection();
			PreparedStatement p = c.prepareStatement(sql.toString());
			
			ResultSet rs = p.executeQuery();
			
			while(rs.next()) {
				bean = new HospitalBean();
				bean.setPatientId(rs.getInt("patient_id"));
				bean.setName(rs.getString("name"));
				bean.setAge(rs.getInt("age"));
				bean.setBloodGroup(rs.getString("blood_group"));
				bean.setDisease(rs.getString("disease"));
				
				l.add(bean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSourceHospital.closeConnection(c);
		}
		return l;
		
	}
}
