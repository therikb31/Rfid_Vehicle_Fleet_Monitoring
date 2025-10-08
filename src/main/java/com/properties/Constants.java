package com.properties;

public class Constants {
	public static final String DB_URL = "jdbc:mysql://ip:port/nkdaswm";
	public static final String DB_USER = "nkdaswm";
	public static final String DB_PASS = "password";
	public static final String PDF_FILENAME = "document.pdf";
	public static final int ATTENDANCE_MIN_READER_COUNT = 3;
	
	public static final String SMTP_HOST = "smtpout.secureserver.net";
	public static final String SMTP_PORT = "465";
	public static final String SMTP_USER = "info@user.in";
	public static final String SMTP_PASS = "pass";
	
	public static final String ATTENDANCE_DAILY_MAIL_SUBJECT = "Attendance Report";
	public static final String ATTENDANCE_DAILY_MAIL_BODY = "This is the attendance for given date %s";
	public static boolean debug = false;
}
