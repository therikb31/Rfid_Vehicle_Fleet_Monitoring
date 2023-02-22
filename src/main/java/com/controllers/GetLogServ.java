package com.controllers;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.EmployeeDAO;
import com.database.LogItemDAO;
import com.google.gson.Gson;
import com.models.LogItem;

/**
 * Servlet implementation class GetLogServ
 */
@WebServlet("/GetLogServ")
public class GetLogServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetLogServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String api_key = request.getParameter("key");
		if(EmployeeDAO.checkApiKey(api_key)) {			
			Vector<LogItem> data = LogItemDAO.getLogWithoutReaderId();
			String jsonData = new Gson().toJson(data);
			response.getWriter().print("{\"data\":"+jsonData+"}");
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
