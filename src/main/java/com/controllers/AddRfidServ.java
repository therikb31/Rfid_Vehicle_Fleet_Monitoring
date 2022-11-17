package com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.RfidDAO;
import com.database.VehicleDAO;
import com.models.Rfid;

/**
 * Servlet implementation class AddRfidServ
 */
public class AddRfidServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRfidServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String rfid = request.getParameter("rfid");
		String vehicle_no = request.getParameter("vehicle_no");
		if(VehicleDAO.checkVehicle(vehicle_no)) {
			Rfid data = new Rfid();
			data.setRfid(rfid);
			data .setVehicle_no(vehicle_no);
			RfidDAO.addRfid(data);
		}
		RequestDispatcher rd = request.getRequestDispatcher("addRfid.jsp");
		rd.forward(request, response);
	}

}
