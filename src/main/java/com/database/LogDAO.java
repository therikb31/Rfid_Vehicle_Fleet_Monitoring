package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import com.models.LogItem;
import com.models.Vehicle;
import com.properties.Queries;
import com.utils.DBConnector;
import com.utils.RandomString;

public class LogDAO {
	public static Vector<LogItem> getLog(){
		Connection conn = DBConnector.getConnection();
		Vector<LogItem> logs = new Vector<LogItem>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(Queries.LOGITEM_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				LogItem log = new LogItem();
				log.setCrossed_at(rs.getTimestamp("crossed_at"));
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
			ps.setTimestamp(1, logItem.getCrossed_at());
			ps.setString(2, logItem.getReader_id());
			ps.setString(3, logItem.getRfid());
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
//		Vector<LogItem> logs = getLog();
//		for(int i=0;i<logs.size();i++) {
//			System.out.println(logs.elementAt(i).toString());
//		}
		while(true) {
			LogItem logItem = new LogItem();
			logItem.setCrossed_at(new Timestamp(System.currentTimeMillis()));
			logItem.setReader_id(RandomString.getAlphaNumericString(8));
			logItem.setRfid(RandomString.getAlphaNumericString(8));
			System.out.println("Added "+logItem.toString());
			addLogItem(logItem);
			TimeUnit.MINUTES.sleep(1);
		}
	}
}
