package com.models;

public class Pole {
	private String pole_no;
	private String address;
	private String lat;
	private String lon;
	private int activity;
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
	
	public int getActivity() {
		return activity;
	}
	public void setActivity(int activity) {
		this.activity = activity;
	}
	public String getPole_no() {
		return pole_no;
	}
	public void setPole_no(String pole_no) {
		this.pole_no = pole_no;
	}
	@Override
	public String toString() {
		return "Pole [pole_no=" + pole_no + ", address=" + address + ", lat=" + lat + ", lon=" + lon + ", activity="
				+ activity + "]";
	}
	
}
