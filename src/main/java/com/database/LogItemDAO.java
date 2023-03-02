package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import com.models.LogItem;
import com.properties.Queries;
import com.utils.DBConnector;

public class LogItemDAO {
	@SuppressWarnings("finally")
	public static Vector<LogItem> getLogByDate(Date date){
		Vector<LogItem> logs = new Vector<LogItem>();
		PreparedStatement ps;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(Queries.LOGITEM_RETRIEVE_BY_DATE);
			ps.setDate(1, date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LogItem log = new LogItem();
				log.setDate(rs.getDate("date"));
				log.setTime(rs.getTime("time"));
				log.setReader_id(rs.getString("reader_id"));
				log.setRfid(rs.getString("rfid"));
				log.setDriven_by(rs.getString("driven_by"));
				log.setPole_no(rs.getString("pole_no"));
				logs.add(log);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			return logs;
		}
	}
	@SuppressWarnings("finally")
	public static Vector<LogItem> getLogByVehicleNo(String vehicle_no){
		Vector<LogItem> logs = new Vector<LogItem>();
		PreparedStatement ps;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(Queries.LOGITEM_RETRIEVE_BY_VEHICLE_NO);
			ps.setString(1, vehicle_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LogItem log = new LogItem();
				log.setDate(rs.getDate("date"));
				log.setTime(rs.getTime("time"));
				log.setReader_id(rs.getString("reader_id"));
				log.setRfid(rs.getString("rfid"));
				log.setDriven_by(rs.getString("driven_by"));
				log.setPole_no(rs.getString("pole_no"));
				logs.add(log);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
			return logs;
		}
	}
	public static Vector<LogItem> getLog(){
		Vector<LogItem> logs = new Vector<LogItem>();
		Connection conn = null;
		PreparedStatement ps;
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(Queries.LOGITEM_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LogItem log = new LogItem();
				log.setDate(rs.getDate("date"));
				log.setTime(rs.getTime("time"));
				log.setReader_id(rs.getString("reader_id"));
				log.setRfid(rs.getString("rfid"));
//				log.setDriven_by(rs.getString("driven_by"));
				log.setPole_no(rs.getString("pole_no"));
				logs.add(log);
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
		return logs;
	}
	public static Vector<LogItem> getLogWithoutReaderId(Date from_date, Date to_date){
		Vector<LogItem> logs = new Vector<LogItem>();
		Connection conn = null;
		PreparedStatement ps;
		try {
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(Queries.LOGITEM_RETRIEVE_BY_DATE_RANGE);
			ps.setDate(1, from_date);
			ps.setDate(2, to_date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LogItem log = new LogItem();
				log.setDate(Date.valueOf(rs.getString("date")));
				log.setTime(rs.getTime("time"));
//				log.setReader_id(rs.getString("reader_id"));
				log.setRfid(rs.getString("rfid"));
//				log.setDriven_by(rs.getString("driven_by"));
				log.setPole_no(rs.getString("pole_no"));
				logs.add(log);
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
		return logs;
	}
	@SuppressWarnings("unused")
	private static void createTable() throws SQLException {
		Connection conn = DBConnector.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Queries.LOGITEM_CREATE);
		conn.close();
	}
	public static boolean addLogItem(LogItem logItem) {
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOGITEM_INSERT);
			ps.setDate(1, logItem.getDate());
			ps.setTime(2, logItem.getTime());
			ps.setString(3, logItem.getReader_id());
			ps.setString(4, logItem.getRfid());
			ps.setString(5, logItem.getVehicle_no());
			ps.setString(6, logItem.getId());
			ps.setString(7, logItem.getDriven_by());
			ps.setString(8, logItem.getPole_no());
			int rowcount = ps.executeUpdate();
			if (rowcount > 0) {
				return true;			
			}
			else {
				System.out.println("Database Error, failed to insert data into Log");
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
	
	public static void main(String[] args) throws SQLException, InterruptedException {
//		createTable();
//		Vector<LogItem> logs = getLogByVehicleNo("WB03D2642");
		Date from_date = Date.valueOf("2023-02-01");
		Date to_date = Date.valueOf("2023-02-02");		
		Vector<LogItem> logs = getLogWithoutReaderId(from_date,to_date);
		System.out.println(logs.size());
		for(int i=0;i<logs.size();i++) {
			System.out.println(logs.elementAt(i).toString());
		}
//		LogItem logItem = new LogItem();
//		Vector<Reader> readers = ReaderDAO.getReaders();
//		Vector<Vehicle> vehicles = VehicleDAO.getVehicle();
//		Vector<Rfid> rfids = RfidDAO.getRfid();
//		System.out.println("ok");
//		while(true) {
//			
//			
//			logItem.setDate(new Date(System.currentTimeMillis()));
//			logItem.setTime(new Time(System.currentTimeMillis()));
//			logItem.setReader_id(readers.elementAt(RandomString.getRandomInt(readers.size()-1)).getReader_id());
//			String rfid = rfids.elementAt(RandomString.getRandomInt(rfids.size()-1)).getRfid();
//			logItem.setRfid(rfid);
//			logItem.setVehicle_no(RfidDAO.getVehicleByRfid(rfid));
//			System.out.println(logItem.toString());
//			LogDAO.addLogItem(logItem);
//			TimeUnit.SECONDS.sleep(1);
//		}
	}
}
