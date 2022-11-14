package com.properties;

public class Queries {
	public static final String VEHICLE_INSERT = "INSERT INTO vehicle(vehicle_no,type_id,type_name,date_added,rfid) VALUES (?,?,?,?,?)";
	public static final String VEHICLE_RETRIEVE_ALL = "SELECT * FROM vehicle";
	public static final String VEHICLE_CREATE = "CREATE TABLE `vehicle` (	`vehicle_no` VARCHAR(64) NOT NULL,	`type_id` INT,	`type_name` VARCHAR(128),`date_added` TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,	`rfid` VARCHAR(64),	PRIMARY KEY (`vehicle_no`));";
	
	public static final String READER_INSERT = "INSERT INTO reader(reader_id,address,lat,lon) VALUES (?,?,?,?)";
	public static final String READER_RETRIEVE_ALL = "SELECT * FROM reader";
	public static final String READER_CREATE = "CREATE TABLE `reader` (	`reader_id` VARCHAR(64),	`address` VARCHAR(256),	`lat` VARCHAR(32),	`lon` VARCHAR(32));";
	
	public static final String LOGITEM_CREATE = "CREATE TABLE `log` (`crossed_at` TIMESTAMP,`reader_id` VARCHAR(64),	`rfid` VARCHAR(64))";
	public static final String LOGITEM_INSERT = "INSERT INTO log (crossed_at,reader_id,rfid) VALUES (?,?,?)";
	public static final String LOGITEM_RETRIEVE_ALL = "SELECT * FROM log";
	
	public static final String RFID_CREATE = "CREATE TABLE `rfid` (`rfid` varchar(32),`vehicle_no` VARCHAR(64), PRIMARY KEY (`rfid`))";
	public static final String RFID_INSERT = "INSERT INTO rfid(rfid,vehicle_no) VALUES (?,?)";
	public static final String RFID_RETRIEVE_ALL = "SELECT * FROM rfid";
}
