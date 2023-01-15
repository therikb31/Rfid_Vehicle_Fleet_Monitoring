package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Iterator;
import java.util.Vector;

import com.models.Vehicle;
import com.properties.Queries;
import com.utils.DBConnector;

public class VehicleDAO {
	public static void updateDrivenBy(String vehicle_no,String driver_name) {
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.VEHICLE_UPDATE_DRIVEN_BY);
			ps.setString(2, vehicle_no);
			ps.setString(1, driver_name);
			int rowcount = ps.executeUpdate();
			System.out.println(rowcount);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	public static String getCurrentLocationByVehicleNo(String vehicle_no) {
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.VEHICLE_RETRIEVE_VEHICLE_CURRENT_LOCATION);
			ps.setString(1, vehicle_no);
			ps.setDate(2, new Date(System.currentTimeMillis()));
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				return rs.getString("reader_id");
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	public static Vector<Vehicle> getVehicleActivityByDate(Date date) {
		Vector<Vehicle> vehicles = getVehicle();
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			for (Iterator<Vehicle> iter = vehicles.iterator(); iter.hasNext();) {
				Vehicle vehicle = iter.next();
				PreparedStatement ps = conn.prepareStatement(Queries.VEHICLE_RETRIEVE_ACTIVITY_COUNT_BY_DATE);
				ps.setString(1, vehicle.getVehicle_no());
				ps.setDate(2, date);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					vehicle.setActivity(rs.getInt(1));
//				System.out.println(reader.getReader_id()+":"+ rs.getInt(1));
				}
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sortVehicleVector(vehicles);

	}
	public static Vector<Vehicle> getVehicleActivityByDateRange(Date from_date, Date to_date) {
		Vector<Vehicle> vehicles = getVehicle();
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			for (Iterator<Vehicle> iter = vehicles.iterator(); iter.hasNext();) {
				Vehicle vehicle = iter.next();
				PreparedStatement ps = conn.prepareStatement(Queries.VEHICLE_RETRIEVE_ACTIVITY_COUNT_BY_DATE_RANGE);
				ps.setString(1, vehicle.getVehicle_no());
				ps.setDate(2, from_date);
				ps.setDate(3, to_date);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					vehicle.setActivity(rs.getInt(1));
//				System.out.println(reader.getReader_id()+":"+ rs.getInt(1));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return sortVehicleVector(vehicles);
		
	}
	public static Vector<Vehicle> sortVehicleVector(Vector<Vehicle> arr) {
		int len = arr.size();
		for(int i=0;i<len;i++) {
			for(int j=i+1;j<len;j++) {
				if(arr.elementAt(i).getActivity() < arr.elementAt(j).getActivity()) {
					Collections.swap(arr, i, j);
				}
			}
		}
		return arr;
	}
	@SuppressWarnings("finally")
	public static boolean checkVehicle(String vehicle_no) {
		Connection conn = null;
		boolean res = false;
		try {
			conn = DBConnector.getConnection();
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
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return res;
		}
		
	}
	public static boolean addVehicle(Vehicle data) {
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.VEHICLE_INSERT);
			ps.setString(1,data.getVehicle_no());
			ps.setInt(2,data.getType_id());
			ps.setString(3, data.getType_name());
			ps.setTimestamp(4,data.getDate_added());
			ps.setString(5, data.getDriven_by());
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
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	public static Vehicle getVehicleByVehicleNo(String vehicle_no) {
		PreparedStatement ps;
		Connection conn = null;
		Vehicle data = new Vehicle();
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(Queries.VEHICLE_RETRIEVE_BY_VEHICLE_NO);
			ps.setString(1, vehicle_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				data.setVehicle_no(rs.getString("vehicle_no"));
				data.setType_id(rs.getInt("type_id"));
				data.setType_name(rs.getString("type_name"));
				data.setDate_added(rs.getTimestamp("date_added"));
				data.setDriven_by(rs.getString("driven_by"));
				String current_location = ReaderDAO.getReaderByReaderId(getCurrentLocationByVehicleNo(vehicle_no)).getAddress();
				if(current_location == null) {
					current_location = "N/A";
				}
				data.setCurrent_location(current_location);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return data;
		
	}
	public static Vector<Vehicle> getVehicle() {
		Connection conn = null;
		Vector<Vehicle> result = new Vector<Vehicle>();
		PreparedStatement ps;
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(Queries.VEHICLE_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vehicle data = new Vehicle();
				data.setVehicle_no(rs.getString("vehicle_no"));
				data.setType_id(rs.getInt("type_id"));
				data.setType_name(rs.getString("type_name"));
				data.setDate_added(rs.getTimestamp("date_added"));
//				data.setDriven_by(rs.getString("driven_by"));
				result.add(data);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
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
//		Vector<Vehicle> result = getVehicleActivityByDate(Date.valueOf("2022-12-24"));
//		for(int i=0;i<result.size();i++) {
//			System.out.println(result.elementAt(i).toString());
//		}
//		createTable();
//		
		updateDrivenBy("RD160", "sample");
		System.out.println("success");
	}
}
