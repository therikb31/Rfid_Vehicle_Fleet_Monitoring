package com.controllers;

import com.database.EmployeeDAO;
import com.database.VehicleDAO;
import com.google.gson.Gson;
import com.models.Vehicle;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetVehiclesServ
 */
@WebServlet("/GetVehiclesServ")
public class GetVehiclesServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GetVehiclesServ() {
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
		String api_key = request.getParameter("key");
		if (EmployeeDAO.checkApiKey(api_key) || request.getSession().getAttribute("isLoggedIn") == "true") {
			Vector<Vehicle> data = VehicleDAO.getVehicle();
			String jsonData = new Gson().toJson(data);
			response.getWriter().print("{\"data\":" + jsonData + "}");
		}
		else {
			response.sendRedirect("/");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
