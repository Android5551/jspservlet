package com.rays.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.rays.bean.StudentBean;
import com.rays.util.modules.JDBCDataSourceStudent;

public class StudentModel {
	public void add(StudentBean b) {
		Connection c = null;
		try {
			c = JDBCDataSourceStudent.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("insert into"
					+ " student values(?,?,?,?)");
			p.setInt(1, b.getStudentId());
			p.setString(2, b.getName());
			p.setInt(3, b.getAge());
			p.setString(4, b.getCourse());
			
			int i = p.executeUpdate();
			System.out.println(i+" row added!");
			JDBCDataSourceStudent.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceStudent.trnRollback(c);
			e.printStackTrace();
		}finally {
			JDBCDataSourceStudent.closeConnection(c);
		}
	}
	public void update(StudentBean b) {
		Connection c = null;
		try {
			c = JDBCDataSourceStudent.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("update "
					+ "student set name=?, age=?, course=? "
					+ "where student_id=?");
			p.setString(1, b.getName());
			p.setInt(2, b.getAge());
			p.setString(3, b.getCourse());
			p.setInt(4, b.getStudentId());
			
			int i = p.executeUpdate();
			System.out.println(i+" row updated!");
			JDBCDataSourceStudent.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceStudent.trnRollback(c);
			e.printStackTrace();
		} finally {
			JDBCDataSourceStudent.closeConnection(c);
		}
	}
	public void delete(int studentId) {
		Connection c = null;
		try {
			c = JDBCDataSourceStudent.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("delete from student where "
					+ "student_id=?");
			p.setInt(1, studentId);
			int i = p.executeUpdate();
			System.out.println(i+" row deleted!");
			JDBCDataSourceStudent.trnCommit(c);
		} catch (Exception e) {
			JDBCDataSourceStudent.trnRollback(c);
			e.printStackTrace();
		}finally {
			JDBCDataSourceStudent.closeConnection(c);
		}
	}
	public List<StudentBean> search(StudentBean b, int pageNo, int pageSize) {
		Connection c = null;
		List<StudentBean> l = new ArrayList<StudentBean>();
		StringBuffer s = new StringBuffer("select * from student "
				+ "where 1=1");
		if(b!=null) {
			if(b.getName()!=null && b.getName().length()>0) {
				s.append(" and name like '"+b.getName()+"%' ");
			}
			if(b.getAge()!=0) {
				s.append(" and age like '"+b.getAge()+"%' ");
				
			}
			if(b.getCourse()!=null && b.getCourse().length()>0) {
				s.append(" and course like '"+b.getCourse()+"' ");
			}
		}
		if(pageSize>0) {
			int index = (pageNo - 1) * pageSize;
			s.append("limit "+index+", "+pageSize);
 		}
		try {
		c = JDBCDataSourceStudent.getConnection();
		PreparedStatement p = c.prepareStatement(s.toString());
		ResultSet r = p.executeQuery();
		while(r.next()) {
			b = new StudentBean();
			b.setStudentId(r.getInt("student_id"));
			b.setName(r.getString("name"));
			b.setAge(r.getInt("age"));
			b.setCourse(r.getString("course"));
			
			l.add(b);
		}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			JDBCDataSourceStudent.closeConnection(c);
		}
		return l;
		
	}
}
