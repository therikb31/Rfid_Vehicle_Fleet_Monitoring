package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.models.Reader;
import com.properties.Queries;
import com.utils.DBConnector;

public class ReaderDAO {
	@SuppressWarnings("finally")
	public static boolean checkReader(String reader_id) {
		boolean res = false;
		try {
			Connection conn = DBConnector.getConnection();
			PreparedStatement ps = conn.prepareStatement(Queries.READER_RETRIEVE_BY_READER_ID);
			ps.setString(1, reader_id);
			ResultSet rs = ps.executeQuery();
			res = rs.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			return res;
		}
		
	}
	public static Reader getReaderByReaderId(String reader_id){
		Connection conn = DBConnector.getConnection();
		Reader reader = new Reader();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(Queries.READER_RETRIEVE_BY_READER_ID);
			ps.setString(1, reader_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				reader.setReader_id(rs.getString("reader_id"));
				reader.setAddress(rs.getString("address"));
				reader.setLat(rs.getString("lat"));
				reader.setLon(rs.getString("lon"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return reader;
	}
	
	public static Vector<Reader> getReaders(){
		Connection conn = DBConnector.getConnection();
		Vector<Reader> readers = new Vector<Reader>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(Queries.READER_RETRIEVE_ALL);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Reader reader = new Reader();
				reader.setReader_id(rs.getString("reader_id"));
				reader.setAddress(rs.getString("address"));
				reader.setLat(rs.getString("lat"));
				reader.setLon(rs.getString("lon"));
				readers.add(reader);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return readers;
	}
	public static boolean addReader(Reader reader) {
		Connection conn = DBConnector.getConnection();
		if (conn == null) {
			System.out.println("Database Error, failed to insert data into Vehicle");
			return false;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.READER_INSERT);
			ps.setString(1, reader.getReader_id());
			ps.setString(2, reader.getAddress());
			ps.setString(3, reader.getLat());
			ps.setString(4, reader.getLon());
			int rowcount = ps.executeUpdate();
			if (rowcount > 0) {
				System.out.println("Added 1 rows successfully into Reader");
				return true;

			} else {
				System.out.println("Database Error, failed to insert data into Reader");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@SuppressWarnings("unused")
	private static void createTable() throws SQLException {
		Connection conn = DBConnector.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Queries.READER_CREATE);
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException {
		Reader reader = getReaderByReaderId("P9LR13");
		System.out.println(reader.toString());
//		reader.setReader_id("rid");
//		reader.setAddress("Novotel");
//		reader.setLat("22.2");
//		reader.setLon("88.4");
//		addReader(reader);
//		createTable();
	}
}
