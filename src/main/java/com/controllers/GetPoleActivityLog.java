package com.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.EmployeeDAO;
import com.database.PoleDAO;
import com.google.gson.Gson;
import com.models.Pole;

/**
 * Servlet implementation class GetPoleActivityLog
 */
public class GetPoleActivityLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetPoleActivityLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String api_key = request.getParameter("key");
		if (EmployeeDAO.checkApiKey(api_key)) {
			Vector<Pole> data = PoleDAO.getPoleActivityByDateRange(Date.valueOf("2023-01-15"), new Date(System.currentTimeMillis()));
			String jsonData = new Gson().toJson(data);
			response.getWriter().print("{\"data\":" + jsonData + "}");
		}
		else {
			response.sendRedirect("/");
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
