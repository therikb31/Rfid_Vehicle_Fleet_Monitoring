package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Iterator;
import java.util.Vector;

import com.models.Log;
import com.properties.Queries;
import com.utils.DBConnector;

public class LogDAO {
	public static Vector<Log> getDailyLog(Date date) {
		Vector<Log> log = null;
		try {
			Connection conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_DAILYLOG);
			ps.setDate(1,date);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Log data = new Log();
				data.setAddress(rs.getString("address"));
				data.setDate(rs.getDate("date"));
				data.setTime(rs.getTime("time"));
				data.setVehicle_no(rs.getString("vehicle_no"));
				data.setType_name(rs.getString("type_name"));
				log.add(data);
			}
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return log;
	}

	public static void main(String[] args) {
		String date = "2022-12-19";
		Date dateParam = Date.valueOf(date);
		for(Iterator<Log> iter = getDailyLog(dateParam).iterator();iter.hasNext(); ) {
			System.out.println(iter.next().toString());
		}
	}

}
