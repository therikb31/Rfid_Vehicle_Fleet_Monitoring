package com.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.models.Marker;
import com.properties.Queries;
import com.utils.DBConnector;

public class MarkerDAO {
	public static Vector<Marker> getMarkers(String vehicle_no, Date date){
		Vector<Marker> markers = new Vector<>();
		try {
			Connection conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.MARKER_RETRIEVE_ALL);
			ps.setDate(2, date);
			ps.setString(1, vehicle_no);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Marker marker = new Marker();
				marker.setAddress(rs.getString("address"));
				marker.setDate(rs.getDate("date"));
				marker.setDate_added(rs.getTimestamp("date_added"));
				marker.setLat(rs.getString("lat"));
				marker.setLon(rs.getString("lon"));
				marker.setReader_id(rs.getString("reader_id"));
				marker.setTime(rs.getTime("time"));
				marker.setType_id(rs.getInt("type_id"));
				marker.setType_name(rs.getString("type_name"));
				marker.setVehicle_no(rs.getString("vehicle_no"));
				markers.add(marker);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return markers;
	}
	public static void main(String[] args) {
		String str="2022-11-18";  
	    Date date=Date.valueOf(str);
		for(Marker marker: getMarkers("RD160",date)){
			System.out.println(marker.toString());
		}
	}

}
