package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.models.Rfid;
import com.properties.Queries;
import com.utils.DBConnector;

public class RfidDAO {
	public static Vector<Rfid> getRfid(){
		Connection conn = DBConnector.getConnection();
		Vector<Rfid> rfids = new Vector<Rfid>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(Queries.RFID_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Rfid rfid = new Rfid();
				rfid.setRfid(rs.getString("rfid"));
				rfid.setVehicle_no(rs.getString("vehicle_no"));
				rfids.add(rfid);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rfids;
	}
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
	@SuppressWarnings("unused")
	private static void createTable() throws SQLException {
		Connection conn = DBConnector.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Queries.RFID_CREATE);
		conn.close();
	}
	public static boolean checkRfid(String rfid) {
		Connection conn = DBConnector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.RFID_RETRIEVE_VEHICLE_NO);
			ps.setString(1, rfid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
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
//		Vector<Rfid> rfids = getRfid();
//		for(Rfid each:rfids) {
//			System.out.println(each.toString());
//		}
		System.out.println(getVehicleByRfid("767461673137000000000000"));
	}

}
