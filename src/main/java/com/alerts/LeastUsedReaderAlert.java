package com.alerts;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
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
 * Servlet implementation class LeastUsedReaderAlert
 */
public class LeastUsedReaderAlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LeastUsedReaderAlert() {
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
			Vector<Reader> log = new Vector<Reader>();
			Vector<Reader> res = ReaderDAO.getReaderActivityByDateRange(from_date,to_date);
			int min = res.elementAt(res.size()-1).getActivity();
			for(int i=0;i<res.size();i++) {
				if(res.elementAt(i).getActivity()==min) {
					log.add(res.elementAt(i));
				}
			}
			String jsonData = new Gson().toJson(log);
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
