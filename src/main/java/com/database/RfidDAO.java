package com.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.properties.Queries;
import com.utils.DBConnector;

public class RfidDAO {
	@SuppressWarnings("unused")
	private static void createTable() throws SQLException {
		Connection conn = DBConnector.getConnection();
		Statement stmt = conn.createStatement();
		stmt.executeUpdate(Queries.RFID_CREATE);
		conn.close();
	}
	
	public static void main(String[] args) throws SQLException {
		createTable();
	}

}
