package com.view;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.EmployeeDAO;
import com.models.Employee;
import com.utils.DBConnector;
import com.utils.Encryption;

/**
 * Servlet implementation class dashboard
 */
public class dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public dashboard() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		if (session.getAttribute("isLoggedIn") == "true") {
			rd = request.getRequestDispatcher("dashboard.jsp");
		} else {
			rd = request.getRequestDispatcher("index.jsp");
		}
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RequestDispatcher rd = null;
		Connection conn = DBConnector.getConnection();
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Employee employee = new Employee();
			employee.setEmployee_id(request.getParameter("employee_id"));
			employee.setPassword(Encryption.encrypt(request.getParameter("password")));
			employee.toString();
			if(EmployeeDAO.checkEmployee(employee.getEmployee_id())) {
				if(EmployeeDAO.checkPassword(employee)) {
					employee.setName(EmployeeDAO.getEmployeeByEmployeeID(employee.getEmployee_id()).getName());
					rd = request.getRequestDispatcher("dashboard.jsp");
					HttpSession session=request.getSession();  
			        session.setAttribute("isLoggedIn","true");
			        session.setAttribute("employee",employee);
					rd.forward(request, response);
				}
				else {
					request.setAttribute("message","Incorrect Password");
					request.setAttribute("redirect", "index.jsp");
					rd = request.getRequestDispatcher("error.jsp");
					rd.forward(request, response);
				}
			}
			else {
				request.setAttribute("message","Employee Doesnot Exists");
				request.setAttribute("redirect", "index.jsp");
				rd = request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}
		}
		else {
			request.setAttribute("message","Connection not established");
			request.setAttribute("redirect", "index.jsp");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		}
	}

}
