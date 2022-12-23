package com.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.LogItemDAO;
import com.database.MarkerDAO;
import com.google.gson.Gson;
import com.models.LogItem;
import com.models.Marker;

/**
 * Servlet implementation class GetMarkerServ
 */
public class GetMarkerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetMarkerServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String vehicle_no = request.getParameter("vehicle_no");
		Date date = Date.valueOf(java.time.LocalDate.now());
		Vector<Marker> data = MarkerDAO.getMarkers(vehicle_no,date);
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
