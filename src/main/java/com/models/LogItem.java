package com.models;

import java.sql.Timestamp;

public class LogItem {
	Timestamp crossed_at;
	String reader_id;
	String rfid;
	public Timestamp getCrossed_at() {
		return crossed_at;
	}
	public void setCrossed_at(Timestamp crossed_at) {
		this.crossed_at = crossed_at;
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
	@Override
	public String toString() {
		return "LogItem [crossed_at=" + crossed_at + ", reader_id=" + reader_id + ", rfid=" + rfid + "]";
	}
	
}
