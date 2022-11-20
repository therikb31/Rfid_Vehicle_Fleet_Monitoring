package com.models;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Marker {
	private String reader_id;
	private String address;
	private String lat;
	private String lon;
	private String vehicle_no;
	private String type_name;
	private int type_id;
	private Timestamp date_added;
	private Date date;
	private Time time;
	public String getReader_id() {
		return reader_id;
	}
	public void setReader_id(String reader_id) {
		this.reader_id = reader_id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getLon() {
		return lon;
	}
	public void setLon(String lon) {
		this.lon = lon;
	}
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
	@Override
	public String toString() {
		return "Marker [reader_id=" + reader_id + ", address=" + address + ", lat=" + lat + ", lon=" + lon
				+ ", vehicle_no=" + vehicle_no + ", type_name=" + type_name + ", type_id=" + type_id + ", date_added="
				+ date_added + ", date=" + date + ", time=" + time + "]";
	}
}
