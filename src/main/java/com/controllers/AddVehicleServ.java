package com.controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.database.VehicleDAO;
import com.models.Vehicle;

/**
 * Servlet implementation class AddVehicleServ
 */
@WebServlet("/AddVehicleServ")
public class AddVehicleServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddVehicleServ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String vehicle_no = request.getParameter("vehicle_no");
		int type_id = Integer.parseInt(request.getParameter("type_id"));
		String type_name = request.getParameter("type_name");
		Timestamp date_added = new Timestamp(System.currentTimeMillis());
		String rfid = request.getParameter("rfid");
		
		Vehicle data = new Vehicle();
		data.setVehicle_no(vehicle_no);
		data.setType_id(type_id);
		data.setType_name(type_name);
		data.setDate_added(date_added);
		data.setRfid(rfid);
		
		VehicleDAO.addVehicle(data);
		request.setAttribute("addedVehicle","true");
		request.setAttribute("vehicle_no",vehicle_no);
		RequestDispatcher rd = request.getRequestDispatcher("addVehicle.jsp");
		rd.forward(request, response);
		
	}

}
