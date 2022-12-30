package com.controllers;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.LogItemDAO;
import com.database.ReaderDAO;
import com.database.RfidDAO;
import com.database.VehicleDAO;
import com.models.LogItem;
import com.properties.Constants;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String reader_id = request.getParameter("reader_id");
		String rfid = request.getParameter("rfid");
		String id = request.getParameter("id");
		if (ReaderDAO.checkReader(reader_id)) {
			if (Constants.debug || RfidDAO.checkRfid(rfid)) {
				LogItem logItem = new LogItem();
				logItem.setDate(new Date(System.currentTimeMillis()));
				logItem.setTime(new Time(System.currentTimeMillis()));
				logItem.setReader_id(reader_id);
				logItem.setRfid(rfid);
				String vehicle_no = RfidDAO.getVehicleByRfid(rfid);
				logItem.setVehicle_no(vehicle_no);
				logItem.setId(id);
				logItem.setDriven_by(VehicleDAO.getVehicleByVehicleNo(vehicle_no).getDriven_by());
				System.out.println(logItem.toString());
				LogItemDAO.addLogItem(logItem);
				response.getWriter().write("Success");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
