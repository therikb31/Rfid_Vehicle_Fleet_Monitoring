package com.models;

import java.sql.Timestamp;

public class Vehicle {
	private String vehicle_no;
	private String type_name;
	private int type_id;
	private Timestamp date_added;
	private int activity;
	
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	public String getType_name() {
		return type_name;
	}
	public void setType_name(String type_name) {
		this.type_name = type_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
	public Timestamp getDate_added() {
		return date_added;
	}
	public void setDate_added(Timestamp date_added) {
		this.date_added = date_added;
	}
	@Override
	public String toString() {
		return "Vehicle [vehicle_no=" + vehicle_no + ", type_name=" + type_name + ", type_id=" + type_id
				+ ", date_added=" + date_added + ", activity=" + activity + "]";
	}
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
}