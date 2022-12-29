package com.models;

import java.sql.Timestamp;

public class Vehicle {
	private String vehicle_no;
	private String type_name;
	private int type_id;
	private Timestamp date_added;
	private int activity;
	private String current_location;
	private String driven_by;
	
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
				+ ", date_added=" + date_added + ", activity=" + activity + ", current_location=" + current_location
				+ ", driven_by=" + driven_by + "]";
	}
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	public String getCurrent_location() {
		return current_location;
	}
	public void setCurrent_location(String current_location) {
		this.current_location = current_location;
	}
	public String getDriven_by() {
		return driven_by;
	}
	public void setDriven_by(String driven_by) {
		this.driven_by = driven_by;
	}
}