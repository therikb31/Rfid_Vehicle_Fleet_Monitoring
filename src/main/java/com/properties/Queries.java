package com.properties;

public class Queries {
	public static final String VEHICLE_INSERT = "INSERT INTO vehicle(vehicle_no,type_id,type_name,date_added,rfid) VALUES (?,?,?,?,?)";
	public static final String VEHICLE_RETRIEVE_ALL = "SELECT * FROM vehicle";
}
