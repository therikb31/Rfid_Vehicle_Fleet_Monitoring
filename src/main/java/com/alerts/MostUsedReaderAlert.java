package com.alerts;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.ReaderDAO;
import com.google.gson.Gson;
import com.models.Reader;

/**
 * Servlet implementation class MostUsedReaderAlert
 */
public class MostUsedReaderAlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostUsedReaderAlert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		LocalDate ld = LocalDate.now();
		Date from_date = Date.valueOf(ld.plusMonths(-1));
		Date to_date = Date.valueOf(ld);
		RequestDispatcher rd = null;
		HttpSession session = request.getSession();
		if(session.getAttribute("isLoggedIn") != null) {
			Reader res = ReaderDAO.getReaderActivityByDateRange(from_date,to_date).elementAt(0);
			String jsonData = new Gson().toJson(res);
		    response.getWriter().print("{\"data\":"+jsonData+"}");
		}
		else {
			rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
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
