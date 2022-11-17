package com.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.LogDAO;
import com.models.LogItem;

/**
 * Servlet implementation class AddPassServ
 */
@WebServlet("/AddLogItemServ")
public class AddLogItemServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddLogItemServ() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reader_id = request.getParameter("reader_id");
		String rfid = request.getParameter("rfid");
		LogItem logItem = new LogItem();
		logItem.setDate(new Date(System.currentTimeMillis()));
		logItem.setTime(new Time(System.currentTimeMillis()));
		logItem.setReader_id(reader_id);
		logItem.setRfid(rfid);
		System.out.println(logItem.toString());
		LogDAO.addLogItem(logItem);
		RequestDispatcher rd = request.getRequestDispatcher("dashboard.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
