package com.reports;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.LogDAO;
import com.models.LogItem;
import com.utils.PDFGenerator;

/**
 * Servlet implementation class DailyLog
 */
public class DailyLog extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyLog() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = null;
			String date_in = request.getParameter("date");
			Date date = Date.valueOf(date_in);
			Vector<LogItem> log = LogDAO.getLogByDate(date);
			while(PDFGenerator.logGenerator("", log));
			rd = request.getRequestDispatcher("reports.jsp");
			request.setAttribute("filepath", "");
			rd.forward(request, response);
		
	}

}
