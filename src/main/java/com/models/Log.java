package com.models;

import java.sql.Date;
import java.sql.Time;

public class Log {
	private String vehicle_no;
	String type_name;
	private String address;
	private Date date;
	private Time time;

	public String getVehicle_no() {
		return vehicle_no;
	}

	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getType_name() {
		return type_name;
	}

	public void setType_name(String type_name) {
		this.type_name = type_name;
	}

	@Override
	public String toString() {
		return "Log [vehicle_no=" + vehicle_no + ", type_name=" + type_name + ", address=" + address + ", date=" + date
				+ ", time=" + time + "]";
	}

}
