package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.models.Vehicle;
import com.properties.Queries;
import com.utils.DBConnector;

public class VehicleDAO {
	@SuppressWarnings("finally")
	public static boolean checkVehicle(String vehicle_no) {
		Connection conn = DBConnector.getConnection();
		boolean res = false;
		if(conn==null) {
			System.out.println("Database Error, failed to Connect");
			return false;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.VEHICLE_RETRIEVE_BY_VEHICLE_NO);
			ps.setString(1, vehicle_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			return res;
		}
		
	}
	public static boolean addVehicle(Vehicle data) {
		Connection conn = DBConnector.getConnection();
		if(conn==null) {
			System.out.println("Database Error, failed to insert data into Vehicle");
			return false;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.VEHICLE_INSERT);
			ps.setString(1,data.getVehicle_no());
			ps.setInt(2,data.getType_id());
			ps.setString(3, data.getType_name());
			ps.setTimestamp(4,data.getDate_added());
			
			int rowcount = ps.executeUpdate();
			if (rowcount > 0) {
				System.out.println("Added 1 rows successfully into Vehicle");
				return true;
						
			}
			else {
				System.out.println("Database Error, failed to insert data into Vehicle");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public static Vector<Vehicle> getVehicle() {
		Connection conn = DBConnector.getConnection();
		Vector<Vehicle> result = new Vector<Vehicle>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(Queries.VEHICLE_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vehicle data = new Vehicle();
				data.setVehicle_no(rs.getString("vehicle_no"));
				data.setType_id(rs.getInt("type_id"));
				data.setType_name(rs.getString("type_name"));
				data.setDate_added(rs.getTimestamp("date_added"));
				result.add(data);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@SuppressWarnings("unused")
	private static void createTable() throws SQLException {
		Connection conn = DBConnector.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Queries.VEHICLE_CREATE);
		conn.close();
	}
	public static void main(String[] args) throws SQLException {
//		Vehicle data = new Vehicle();
//		data.setType_name("test");
//		data.setVehicle_no("test_vehivle");
//		data.setType_id(0);
//		data.setDate_added(new Timestamp(System.currentTimeMillis()));
//		addVehicle(data);
//		Vector<Vehicle> result = getVehicle();
//		for(int i=0;i<result.size();i++) {
//			System.out.println(result.elementAt(i).toString());
//		}
//		createTable();
		System.out.println(checkVehicle("test"));
	}
}
