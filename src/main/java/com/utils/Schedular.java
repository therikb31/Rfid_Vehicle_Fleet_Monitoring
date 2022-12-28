package com.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.TimerTask;

public class Schedular extends TimerTask{
	String head;
	public Schedular(String head){
		this.head  = head;
	}
	@Override
	public void run() {
		new DailyVehicleAttendenceMail(head).generate();	
	}

}
