package com.controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.Vector;

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
			Date from_date = Date.valueOf(request.getParameter("from_date"));
			Date to_date = Date.valueOf(request.getParameter("to_date"));
			Vector<LogItem> data = LogItemDAO.getLogWithoutReaderId(from_date,to_date);
			
			System.out.println(data.size());
			for(int i=0;i<data.size();i++) {
				System.out.println(data.elementAt(i).toString());
			}
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
