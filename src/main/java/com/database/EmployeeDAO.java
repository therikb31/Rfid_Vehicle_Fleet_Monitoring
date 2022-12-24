package com.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.models.Employee;
import com.properties.Queries;
import com.utils.DBConnector;
import com.utils.Encryption;

public class EmployeeDAO {
	public static void createEmployeeTab() {
		Connection conn = DBConnector.getConnection();
		Statement stmt;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(Queries.EMPLOYEE_CREATE);
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static boolean checkEmployee(String employee_id) {
		Connection conn = DBConnector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.EMPLOYEE_RETRIEVE);
			ps.setString(1, employee_id);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	public static boolean checkPassword(Employee employee) {
		Connection conn = DBConnector.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.EMPLOYEE_RETRIEVE);
			ps.setString(1, employee.getEmployee_id());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				if (employee.getPassword().equals(rs.getString("password"))) {
					return true;
				}
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	@SuppressWarnings("finally")
	public static boolean insertEmployee(Employee employee) {
		boolean res = false;
		Connection conn = DBConnector.getConnection();
		if(checkEmployee(employee.getEmployee_id())) {
			System.out.println("Employee Already Exists!");
			return false;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.EMPLOYEE_INSERT);
			ps.setString(1, employee.getEmployee_id());
			ps.setString(2, employee.getName());
			ps.setString(3, employee.getPassword());
			int rowcount = ps.executeUpdate();
			if(rowcount > 0) {
				System.out.println("Inserted "+employee.toString());
				res = true;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			return res;
		}
	}

	public static void main(String[] args) {
		Employee employee = new Employee();
		employee.setEmployee_id("E01");
		employee.setName("Rik Biswas");
		employee.setPassword(Encryption.encrypt("1234"));
		System.out.println(checkPassword(employee));
//		System.out.println(checkEmployee("admin"));
//		createEmployeeTab();
	}
	public static Employee getEmployeeByEmployeeID(String employee_id) {
		Connection conn = DBConnector.getConnection();
		Employee res = new Employee();
		try {
			PreparedStatement ps = conn.prepareStatement(Queries.EMPLOYEE_RETRIEVE);
			ps.setString(1, employee_id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				res.setEmployee_id(rs.getString("employee_id"));
				res.setName(rs.getString("name"));
				res.setPassword(rs.getString("password"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}
