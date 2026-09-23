package com.rays.event.model;
/*
vehicleId bigint NO PRI  
vehicleName varchar(45) YES   
model varchar(45) YES   
color varchar(45) YES   
price double YES   */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.event.bean.EventBean;
import com.rays.event.bean.VehicleBean;
import com.rays.event.util.JDBCDataSource;

public class VehicleModel {
	// next primary key getting next primary key
	public long nextPk() {
		Connection c = null;
		long pk = 0;

		c = JDBCDataSource.getConnection();
		try {
			PreparedStatement p = c.prepareStatement("select max(vehicleId) from vehicle");
			ResultSet r = p.executeQuery();
			while (r.next()) {
				pk = r.getLong(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(c);
		}
		return pk + 1;
	}

	// insert return type void
	public void add(VehicleBean bean) {
		Connection c = null;
		// business validation
		// checking whether vehicle name already exists in db.
		VehicleBean existBean = findByVehicleName(bean.getVehicleName());
		long pk = 0;
		// if existBean able to find record.
		if (existBean != null) {
			throw new RuntimeException("Vehicle name already exists");
		}

		try {
			pk = nextPk(); // 0 + 1
			c = JDBCDataSource.getConnection();
			c.setAutoCommit(false);
			/*
			 * vehicleId bigint NO PRI vehicleName varchar(45) YES model varchar(45) YES
			 * color varchar(45) YES price double YES
			 */
			PreparedStatement p = c.prepareStatement("insert into vehicle values (?,?,?,?,?)");
			p.setLong(1, pk);
			p.setString(2, bean.getVehicleName());
			p.setString(3, bean.getModel());
			p.setString(4, bean.getColor());
			p.setDouble(5, bean.getPrice());

			int i = p.executeUpdate();
			c.commit();
			System.out.println(i + " record inserted successfully!");
		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(c);
		} finally {
			JDBCDataSource.closeConnection(c);
		}
	}

	// updating rows
	public void update(VehicleBean bean) {
		Connection c = null;
		try {
			c = JDBCDataSource.getConnection();
			c.setAutoCommit(false);

			PreparedStatement p = c.prepareStatement("update vehicle set " + "vehicleName = ?," + "model = ?,"
					+ "color = ?," + "price = ? where vehicleId = ?");
			p.setString(1, bean.getVehicleName());
			p.setString(2, bean.getModel());
			p.setString(3, bean.getColor());
			p.setDouble(4, bean.getPrice());
			p.setLong(5, bean.getVehicleId());

			int i = p.executeUpdate();
			c.commit();

		} catch (Exception e) {
			JDBCDataSource.trnRollBack(c); // roll back
			e.printStackTrace();
		} finally {
			JDBCDataSource.closeConnection(c); // close
		}
	}

	// deleting rows
	public void delete(VehicleBean b) {
		Connection c = null;
		try {
			c = JDBCDataSource.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("delete from vehicle" + " where vehicleId = ?");
			p.setLong(1, b.getVehicleId());
			int i = p.executeUpdate();
			c.commit();
		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(c);
		} finally {
			JDBCDataSource.closeConnection(c);
		}
	}

	// business validation find by vehicle name
	// returning VehicleBean object
	// gets record of said vehicle
	public VehicleBean findByVehicleName(String vehicleName) {
		Connection c = null;
		VehicleBean b = null;
		try {
			c = JDBCDataSource.getConnection();
			c.setAutoCommit(false);
			PreparedStatement p = c.prepareStatement("select * from vehicle where vehicleName = ?");
			p.setString(1, vehicleName);
			ResultSet r = p.executeQuery();
			/*
			 * vehicleId bigint NO PRI vehicleName varchar(45) YES model varchar(45) YES
			 * color varchar(45) YES price double YES
			 */
			while (r.next()) {
				// setting values from r to b
				b = new VehicleBean();
				b.setVehicleId(r.getLong("vehicleId"));
				b.setVehicleName(r.getString("vehicleName"));
				b.setModel(r.getString("model"));
				b.setColor(r.getString("color"));
				b.setPrice(r.getDouble("price"));
			}
		} catch (Exception e) {
			e.printStackTrace();
			JDBCDataSource.trnRollBack(c);
		} finally {
			JDBCDataSource.closeConnection(c);
		}

		return b;
	}

	// listing all the rows page wise
	// returns List of vehicleBean object
	public List<VehicleBean> search(VehicleBean b, int pageNo, int pageSize) throws SQLException{
	Connection c = null;
	List<VehicleBean> l = new ArrayList<>();
	// Sql injection
	StringBuffer s = new StringBuffer("select * from vehicle where 1=1 ");
	
	if (pageSize > 0) {
		int index = (pageNo - 1) * pageSize;
		s.append("limit " + index + ", "+ pageSize);
	}
	
	c = JDBCDataSource.getConnection();
	System.out.println("sql search query ====> " + s.toString());

	PreparedStatement pstmt = c.prepareStatement(s.toString());

	ResultSet r = pstmt.executeQuery();

	while (r.next()) {
		b = new VehicleBean();
		b.setVehicleId(r.getLong("vehicleId"));
		b.setVehicleName(r.getString("vehicleName"));
		b.setModel(r.getString("model"));
		b.setColor(r.getString("color"));
		b.setPrice(r.getDouble("price"));
		l.add(b);
	}
	try {

	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		c.close();
	}

	return l;
	}
}

