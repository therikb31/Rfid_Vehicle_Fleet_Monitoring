package com.controllers;

import java.io.IOException;
import java.util.Calendar;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.LogDAO;
import com.google.gson.Gson;
import com.models.Log;

/**
 * Servlet implementation class GetVehicleLogTodayServ
 */
public class GetVehicleLogTodayServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetVehicleLogTodayServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("isLoggedIn") != "true") {
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			return;
		}
		else {
			String vehicle_no = request.getParameter("vehicle_no");
			Vector<Log> data = LogDAO.getVehicleLogByDate(vehicle_no,new java.sql.Date(Calendar.getInstance().getTime().getTime()));
			String jsonData = new Gson().toJson(data);
		    response.getWriter().print("{\"data\":"+jsonData+"}");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
