package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import com.models.LogItem;
import com.models.Reader;
import com.models.Rfid;
import com.models.Vehicle;
import com.properties.Queries;
import com.utils.DBConnector;
import com.utils.RandomString;

public class LogDAO {
	@SuppressWarnings("finally")
	public static Vector<LogItem> getLogByDate(Date date){
		Connection conn = DBConnector.getConnection();
		Vector<LogItem> logs = new Vector<LogItem>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(Queries.LOGITEM_RETRIEVE_BY_DATE);
			ps.setDate(1, date);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LogItem log = new LogItem();
				log.setDate(rs.getDate("date"));
				log.setTime(rs.getTime("time"));
				log.setReader_id(rs.getString("reader_id"));
				log.setRfid(rs.getString("rfid"));
				logs.add(log);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return logs;
		}
	}
	@SuppressWarnings("finally")
	public static Vector<LogItem> getLogByVehicleNo(String vehicle_no){
		Connection conn = DBConnector.getConnection();
		Vector<LogItem> logs = new Vector<LogItem>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(Queries.LOGITEM_RETRIEVE_BY_VEHICLE_NO);
			ps.setString(1, vehicle_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LogItem log = new LogItem();
				log.setDate(rs.getDate("date"));
				log.setTime(rs.getTime("time"));
				log.setReader_id(rs.getString("reader_id"));
				log.setRfid(rs.getString("rfid"));
				logs.add(log);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return logs;
		}
	}
	public static Vector<LogItem> getLog(){
		Connection conn = DBConnector.getConnection();
		Vector<LogItem> logs = new Vector<LogItem>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(Queries.LOGITEM_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LogItem log = new LogItem();
				log.setDate(rs.getDate("date"));
				log.setTime(rs.getTime("time"));
				log.setReader_id(rs.getString("reader_id"));
				log.setRfid(rs.getString("rfid"));
				logs.add(log);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		Connection conn = DBConnector.getConnection();
		if(conn==null) {
			System.out.println("Database Error, failed to insert data into Log");
			return false;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.LOGITEM_INSERT);
			ps.setDate(1, logItem.getDate());
			ps.setTime(2, logItem.getTime());
			ps.setString(3, logItem.getReader_id());
			ps.setString(4, logItem.getRfid());
			ps.setString(5, logItem.getVehicle_no());
			ps.setString(6, logItem.getId());
			int rowcount = ps.executeUpdate();
			if (rowcount > 0) {
				System.out.println("Added 1 rows successfully into Log");
				return true;
						
			}
			else {
				System.out.println("Database Error, failed to insert data into Log");
				return false;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static void main(String[] args) throws SQLException, InterruptedException {
//		createTable();
//		Vector<LogItem> logs = getLogByVehicleNo("WB03D2642");
		
		Vector<LogItem> logs = getLogByDate(Date.valueOf("2022-12-14"));
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
