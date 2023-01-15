package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import com.models.Log;
import com.models.Pole;
import com.properties.Queries;
import com.utils.DBConnector;
import com.utils.Sort;

public class PoleDAO {
	static Connection conn = null;
	public static Vector<Pole> getPoleActivityByDateRange(Date from_date, Date to_date) {
		Vector<Pole> poles = PoleDAO.getPoles();
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			for (Iterator<Pole> iter = poles.iterator(); iter.hasNext();) {
				Pole pole = iter.next();
				PreparedStatement ps = conn.prepareStatement(Queries.POLE_RETRIEVE_ACTIVITY_COUNT_BY_DATE_RANGE);
				ps.setString(1, pole.getPole_no());
				ps.setDate(2, from_date);
				ps.setDate(3, to_date);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					pole.setActivity(rs.getInt(1));
				}
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
		return Sort.sortPoleVector(poles);
	}
	public static Vector<Pole> getPoleActivity(Date date) {
		Vector<Pole> poles = PoleDAO.getPoles();
		Connection conn = null;
		try {
			conn = DBConnector.getConnection();
			for (Iterator<Pole> iter = poles.iterator(); iter.hasNext();) {
				Pole pole = iter.next();
				PreparedStatement ps = conn.prepareStatement(Queries.POLE_RETRIEVE_ACTIVITY_COUNT);
				ps.setString(1, pole.getPole_no());
				ps.setDate(2, date);
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					pole.setActivity(rs.getInt(1));
//					System.out.println(reader.getReader_id()+":"+ rs.getInt(1));
				}
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
		return Sort.sortPoleVector(poles);
	}

	@SuppressWarnings("finally")
	public static Vector<Pole> getPoles() {
		Vector<Pole> poles = new Vector<Pole>();
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.POLE_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pole pole = new Pole();
				pole.setPole_no(rs.getString("pole_no"));
				pole.setAddress(rs.getString("address"));
				pole.setLat(rs.getString("lat"));
				pole.setLon(rs.getString("lon"));
				poles.add(pole);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			return poles;
		}
	}

	public static Pole getPoleByPoleNo(String pole_no) {
		Connection conn = null;
		Pole pole = new Pole();
		try {
			conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.POLE_RETRIEVE_BY_POLE_NO);
			ps.setString(1, pole_no);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				pole.setAddress(rs.getString("address"));
				pole.setLat(rs.getString("lat"));
				pole.setLon(rs.getString("lon"));
				pole.setPole_no(rs.getString("pole_no"));
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
		return pole;
	}

	public static void main(String[] args) {
//		Date date = Date.valueOf("2023-01-15");
//		Vector<Pole> poles = getPoleActivity(date);
//		for (Iterator<Pole> iter = poles.iterator(); iter.hasNext();) {
//			System.out.println(iter.next().toString());
//		}
//		for(Iterator<Pole> iter = getPoles().iterator(); iter.hasNext();) {
//			System.out.println(iter.next().toString());
//		}
		System.out.println(getPoleByPoleNo("P1").toString());
	}

	

}
