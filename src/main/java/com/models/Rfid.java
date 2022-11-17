package com.models;

public class Rfid {
	String rfid;
	String vehicle_no;
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
		return "Rfid [rfid=" + rfid + ", vehicle_no=" + vehicle_no + "]";
	}

}
