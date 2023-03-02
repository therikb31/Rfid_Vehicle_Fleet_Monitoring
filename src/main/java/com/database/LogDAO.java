package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Vector;

import com.models.Log;
import com.properties.Queries;
import com.utils.DBConnector;

public class LogDAO {
	public static Vector<Log> getVehicleLogByDate(String vehicle_no, Date date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_VEHICLE_LOG_BY_DATE);
			ps.setDate(1, date);
			ps.setString(2, vehicle_no);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return log;
	}

	public static Vector<Log> getVehicleLogByDateLimit(String vehicle_no, Date date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_VEHICLE_LOG_BY_DATE_LIMIT);
			ps.setDate(1, date);
			ps.setString(2, vehicle_no);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return log;
	}

	public static Vector<Log> getVehicleLogByDateRange(String vehicle_no, Date from_date, Date to_date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			;
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_VEHICLE_LOG_BY_DATE_RANGE);
			ps.setDate(1, from_date);
			ps.setDate(2, to_date);
			ps.setString(3, vehicle_no);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return log;
	}

	public static Vector<Log> getDailyLogByDateRange(Date from_date, Date to_date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_DAILY_LOG_BY_DATE_RANGE);
			ps.setDate(1, from_date);
			ps.setDate(2, to_date);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return log;
	}

	public static Vector<Log> getDailyLog(Date date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_DAILY_LOG);
			ps.setDate(1, date);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return log;
	}
	public static Vector<Log> getPoleLogByDate(String pole_no,Date date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_POLE_LOG_BY_DATE);
			ps.setDate(1,date);
			ps.setString(2, pole_no);
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
		return log;
	}
	public static Vector<Log> getReaderLogByDate(String reader_id, Date date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_READER_LOG_BY_DATE);
			ps.setDate(1, date);
			ps.setString(2, reader_id);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
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
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return log;
	}
	public static Vector<Log> getReaderLogByDateRange(String reader_id, Date from_date, Date to_date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_READER_LOG_BY_DATE_RANGE);
			ps.setDate(1, from_date);
			ps.setDate(2, to_date);
			ps.setString(3, reader_id);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Log data = new Log();
				data.setAddress(rs.getString("address"));
				data.setDate(rs.getDate("date"));
				data.setTime(rs.getTime("time"));
				data.setVehicle_no(rs.getString("vehicle_no"));
				data.setType_name(rs.getString("type_name"));
				log.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return log;
	}

	public static Vector<Log> getPoleLogByDateRange(String pole_no, Date from_date, Date to_date) {
		Vector<Log> log = null;
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.LOG_POLE_LOG_BY_DATE_RANGE);
			ps.setDate(1, from_date);
			ps.setDate(2, to_date);
			ps.setString(3, pole_no);
			log = new Vector<Log>();
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Log data = new Log();
				data.setAddress(rs.getString("address"));
				data.setDate(rs.getDate("date"));
				data.setTime(rs.getTime("time"));
				data.setVehicle_no(rs.getString("vehicle_no"));
				data.setType_name(rs.getString("type_name"));
				log.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return log;
	}
	public static void main(String[] args) {
//		String date = "2022-12-22";
		Date fromParam = new java.sql.Date(Calendar.getInstance().getTime().getTime());
//		Date toParam = Date.valueOf("2022-12-19");
//		String reader_id = "P9LR13";
		for (Iterator<Log> iter = getVehicleLogByDate("WB08D3618", fromParam).iterator(); iter.hasNext();) {
			System.out.println(iter.next().toString());
		}
		System.out.println("Hello");
	}

	

}
