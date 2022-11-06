package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.models.Reader;
import com.models.Vehicle;
import com.properties.Queries;
import com.utils.DBConnector;

public class ReaderDAO {
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
		Reader reader = new Reader();
		reader.setReader_id("rid");
		reader.setAddress("Novotel");
		reader.setLat("22.2");
		reader.setLon("88.4");
		addReader(reader);
//		createTable();
	}
}
