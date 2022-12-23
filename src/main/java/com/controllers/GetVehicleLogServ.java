package com.controllers;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.LogItemDAO;
import com.google.gson.Gson;
import com.models.LogItem;

/**
 * Servlet implementation class GetVehicleLogServ
 */
public class GetVehicleLogServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVehicleLogServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vehicle_no = request.getParameter("vehicle_no");
		Vector<LogItem> data = LogItemDAO.getLogByVehicleNo(vehicle_no);
		String jsonData = new Gson().toJson(data);
	    response.getWriter().print("{\"data\":"+jsonData+"}");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
