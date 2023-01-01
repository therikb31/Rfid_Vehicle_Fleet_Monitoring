package com.models;

import java.sql.Date;
import java.sql.Time;

public class LogItem {
	Date date;
	Time time;
	String reader_id;
	String rfid;
	String vehicle_no;
	String id;
	String driven_by;
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
	public String getReader_id() {
		return reader_id;
	}
	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}
	public String getRfid() {
		return rfid;
	}
	public void setRfid(String rfid) {
		this.rfid = rfid;
	}
	public String getVehicle_no() {
		return vehicle_no;
	}
	public void setVehicle_no(String vehicle_no) {
		this.vehicle_no = vehicle_no;
	}
	@Override
	public String toString() {
		return "LogItem [date=" + date + ", time=" + time + ", reader_id=" + reader_id + ", rfid=" + rfid
				+ ", vehicle_no=" + vehicle_no + ", id=" + id + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDriven_by() {
		return driven_by;
	}
	public void setDriven_by(String driven_by) {
		this.driven_by = driven_by;
	}
	
	
}
