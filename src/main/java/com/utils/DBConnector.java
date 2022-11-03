package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.properties.Constants;

public class DBConnector {
	@SuppressWarnings("finally")
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.DB_PASS);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			return con;
		}
	}

	public static void main(String args[]) {
		Connection conn = getConnection();
		if (conn != null) {
			System.out.println("Connected to " + Constants.DB_URL);
		}
	}
}
