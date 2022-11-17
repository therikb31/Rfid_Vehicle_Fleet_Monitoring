package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.models.Rfid;
import com.properties.Queries;
import com.utils.DBConnector;

public class RfidDAO {
	@SuppressWarnings("unused")
	public static void addRfid(Rfid data) {
		Connection conn = DBConnector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.RFID_INSERT);
			ps.setString(1, data.getRfid());
			ps.setString(2, data.getVehicle_no());
			int rowcount = ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	private static void createTable() throws SQLException {
		Connection conn = DBConnector.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Queries.RFID_CREATE);
		conn.close();
	}
	public static String getVehicleByRfid(String rfid) {
		Connection conn = DBConnector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.RFID_RETRIEVE_VEHICLE_NO);
			ps.setString(1, rfid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				return rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public static void main(String[] args) throws SQLException {
//		createTable();
		System.out.println(getVehicleByRfid("test"));
	}

}
