package com.rays.event.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rays.event.bean.EventBean;
import com.rays.event.util.JDBCDataSource;

public class EventModel {

	public long nextPk() throws SQLException {

		Connection conn = null;
		long pk = 0;

		try {
			conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement("select max(eventId) from event");
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				pk = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(conn);
		}
		return pk + 1; // return next auto-increment non-business primary key
	}

	public void add(EventBean bean) throws SQLException {

		Connection conn = null;
		EventBean existBean = findByEventName(bean.getEventName());
		long pk = 0;

		if (existBean != null) {
			throw new RuntimeException("Event name already exists");
		}

		try {
			pk = nextPk();
			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("insert into event values(?, ?, ?, ?, ?)");
			/*
			 * private long eventId; private String eventName; private Date eventDate;
			 * private String venue; private String organizer
			 */
			pstmt.setLong(1, pk);
			pstmt.setString(2, bean.getEventName());
			pstmt.setDate(3, new java.sql.Date(bean.getEventDate().getTime()));
			pstmt.setString(4, bean.getVenue());
			pstmt.setString(5, bean.getOrganizer());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record inserted successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(conn);
		} finally {
			JDBCDataSource.closeConnection(conn);
		}

	}

	public void update(EventBean bean) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);
			/*
			 * private long eventId; private String eventName; private Date eventDate;
			 * private String venue; private String organizer
			 */
			PreparedStatement pstmt = conn.prepareStatement(
					"update event set eventName = ?, eventDate = ?, venue = ?, organizer = ? where eventId = ?");

			pstmt.setString(1, bean.getEventName());
			pstmt.setDate(2, new java.sql.Date(bean.getEventDate().getTime()));
			pstmt.setString(3, bean.getVenue());
			pstmt.setString(4, bean.getOrganizer());
			pstmt.setLong(5, bean.getEventId());

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record updated successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	public void delete(int eventId) throws SQLException {

		Connection conn = null;

		try {

			conn = JDBCDataSource.getConnection();

			conn.setAutoCommit(false);

			PreparedStatement pstmt = conn.prepareStatement("delete from event where eventId = ?");

			pstmt.setInt(1, eventId);

			int i = pstmt.executeUpdate();

			conn.commit();

			System.out.println("record delete successfully: " + i);

		} catch (Exception e) {
			e.printStackTrace();
			conn.rollback();
		} finally {
			conn.close();
		}

	}

	/*
	 * public EventBean findByPk(int id) throws SQLException {
	 * 
	 * Connection conn = null; EventBean bean = null;
	 * 
	 * try {
	 * 
	 * conn = JDBCDataSource.getConnection();
	 * 
	 * PreparedStatement pstmt =
	 * conn.prepareStatement("select * from st_user where id = ?");
	 * 
	 * pstmt.setInt(1, id);
	 * 
	 * ResultSet rs = pstmt.executeQuery();
	 * 
	 * private long eventId; private String eventName; private Date eventDate;
	 * private String venue; private String organizer
	 * 
	 * while (rs.next()) { bean = new EventBean(); bean = new EventBean();
	 * bean.setEventId(rs.getLong("eventId"));
	 * bean.setEventName(rs.getString("eventName"));
	 * bean.setEventDate(rs.getDate("eventDate"));
	 * bean.setVenue(rs.getString("venue"));
	 * bean.setOrganizer(rs.getString("organizer")); }
	 * 
	 * } catch (Exception e) { e.printStackTrace(); } finally { conn.close(); }
	 * 
	 * return bean;
	 * 
	 * }
	 */

	public EventBean findByEventName(String eventName) throws SQLException {

		Connection conn = null;
		EventBean bean = null;

		try {

			conn = JDBCDataSource.getConnection();

			PreparedStatement pstmt = conn.prepareStatement("select * from event where eventName = ?");

			pstmt.setString(1, eventName);

			ResultSet rs = pstmt.executeQuery();
			/*
			 * private long eventId; private String eventName; private Date eventDate;
			 * private String venue; private String organizer
			 */
			while (rs.next()) {
				bean = new EventBean();
				bean.setEventId(rs.getLong("eventId"));
				bean.setEventName(rs.getString("eventName"));
				bean.setEventDate(rs.getDate("eventDate"));
				bean.setVenue(rs.getString("venue"));
				bean.setOrganizer(rs.getString("organizer"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return bean;

	}

//	public EventBean authenticate(String loginId, String password) throws SQLException {
//
//		EventBean bean = findByLogin(loginId);
//
//		if (bean != null && bean.getPassword().equals(password)) {
//			return bean;
//		}
//
//		return null;
//
//	}

	public List<EventBean> search(EventBean bean, int pageNo, int pageSize) throws SQLException {

		Connection conn = null;
		List<EventBean> list = new ArrayList<EventBean>();
		StringBuffer sql = new StringBuffer("select * from event where 1=1 ");

		/*
		 * if (bean != null) { if (bean.getFirstName() != null &&
		 * bean.getFirstName().length() > 0) { sql.append("and firstName like '" +
		 * bean.getFirstName() + "%' "); } if (bean.getLastName() != null &&
		 * bean.getLastName().length() > 0) { sql.append("and lastName like '" +
		 * bean.getLastName() + "%' "); } if (bean.getLoginId() != null &&
		 * bean.getLoginId().length() > 0) { sql.append("and loginId like '" +
		 * bean.getLoginId() + "%' "); } if (bean.getPassword() != null &&
		 * bean.getPassword().length() > 0) { sql.append("and password like '" +
		 * bean.getPassword() + "%' "); } if (bean.getDob() != null &&
		 * bean.getDob().getTime() > 0) { sql.append("and dob like '" + new
		 * java.sql.Date(bean.getDob().getTime()) + "'% "); } }
		 */

		if (pageSize > 0) {
			int index = (pageNo - 1) * pageSize;
			sql.append("limit " + index + ", " + pageSize);
		}

		conn = JDBCDataSource.getConnection();

		System.out.println("sql search query ====> " + sql.toString());

		PreparedStatement pstmt = conn.prepareStatement(sql.toString());

		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			bean = new EventBean();
			bean.setEventId(rs.getLong("eventId"));
			bean.setEventName(rs.getString("eventName"));
			bean.setEventDate(rs.getDate("eventDate"));
			bean.setVenue(rs.getString("venue"));
			bean.setOrganizer(rs.getString("organizer"));
			list.add(bean);
		}

		try {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
		}

		return list;

	}

}