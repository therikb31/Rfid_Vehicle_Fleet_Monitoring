package com.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import com.properties.Constants;

public class Mail {
	public static void send(String to, String Subject, String text,File file) throws FileNotFoundException {
		String user = Constants.SMTP_USER;
		String pass = Constants.SMTP_PASS;
		String host = Constants.SMTP_HOST;// or IP addressr
		String port = Constants.SMTP_PORT;

		Properties props = new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smpt.port", port);
		props.put("mail.smtp.auth", "true");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(user, pass);
			}
		});

		// Compose the message
		try {
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("javatpoint");
			
			BodyPart messageBodyPart1 = new MimeBodyPart();  
		    messageBodyPart1.setText("This is message body");  
		    
		    
		    
		    MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
		    String filename = file.getName(); //change accordingly  
		    FileDataSource source = new FileDataSource(file);  
		    messageBodyPart2.setDataHandler(new DataHandler(source));  
		    messageBodyPart2.setFileName(filename);  
		     
		     
		    //5) create Multipart object and add MimeBodyPart objects to this object      
		    Multipart multipart = new MimeMultipart();  
		    multipart.addBodyPart(messageBodyPart1);  
		    multipart.addBodyPart(messageBodyPart2);  
		  
		    //6) set the multiplart object to the message object  
		    message.setContent(multipart);  

			// send the message
			Transport.send(message);

		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) throws FileNotFoundException {
		String to = "therikb31@gmail.com";
		String Subject = Constants.ATTENDANCE_DAILY_MAIL_SUBJECT;
		String text = Constants.ATTENDANCE_DAILY_MAIL_BODY;
		File file = new File("./src/main/resources/PDFOutput/output.pdf");
		send(to, Subject, text,file);
	}
}