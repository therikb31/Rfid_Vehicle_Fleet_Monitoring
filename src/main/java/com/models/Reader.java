package com.models;

public class Reader {
	private String reader_id;
	private String address;
	private String lat;
	private String lon;
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
	@Override
	public String toString() {
		return "Reader [reader_id=" + reader_id + ", address=" + address + ", lat=" + lat + ", lon=" + lon + "]";
	}
}
