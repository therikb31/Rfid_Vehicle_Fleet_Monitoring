package com.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import com.database.VehicleDAO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.models.Vehicle;
import com.properties.Constants;

public class DailyVehicleAttendenceMail {
	public static String head;
	DailyVehicleAttendenceMail(String myhead){
		head = myhead;
	}
	public void generate(){
		Document document = null;
		String dateToday = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
		OutputStream outputStream = null;
		Date date = new Date(System.currentTimeMillis() - 24 * 60 * 60 * 1000);
		String filepath = Constants.PDF_FILENAME;
		try {
			int marginLR = 30;
			document = new Document(PageSize.A4, marginLR, marginLR, 50, 50);
			File fileObj = new File(filepath);
			fileObj.createNewFile();
			outputStream = new FileOutputStream(new File(filepath));
			PdfWriter pw = PdfWriter.getInstance(document, outputStream);
			PDFHeaderFooter myHeaderFooter = new PDFHeaderFooter();
			myHeaderFooter.header = head;
			pw.setPageEvent(myHeaderFooter);
			document.open();
			document.add(new Chunk(""));
			Font regular = new Font(FontFamily.HELVETICA, 12);
			Font bold = new Font(FontFamily.HELVETICA, 12, Font.BOLD);
			if (pw.getCurrentPageNumber() == 1) {
				document.add(new Phrase("Report Name:", regular));
				document.add(new Phrase(" Date Specific Vehicle Attendance Log\n", bold));

				document.add(new Phrase("Report of Date: ", regular));
				document.add(new Phrase(new SimpleDateFormat("dd/MM/yyyy").format(date) + "\n", bold));

				document.add(new Phrase("Date Generated: ", regular));
				document.add(new Phrase(new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date()) + "\n", bold));

				document.add(new Phrase("Time Generated: ", regular));
				document.add(new Phrase(new SimpleDateFormat("HH:mm:ss aa").format(new java.util.Date()).toUpperCase() + "\n", bold));

//		document.newPage();
			}
			PdfPTable table = new PdfPTable(5);
			table.setTotalWidth(document.getPageSize().getWidth() - (float) 60.0);
			table.setLockedWidth(true);
			table.setWidths(new int[] { 1, 2, 2, 2, 1 });
			table.addCell(Util.getCell("Sl No", bold));
			table.addCell(Util.getCell("Vehicle No", bold));
			table.addCell(Util.getCell("Vehicle Type", bold));
			table.addCell(Util.getCell("Date Commissioned", bold));
			table.addCell(Util.getCell("Activity", bold));

			table.setHeaderRows(1);
			Font font = FontFactory.getFont(FontFactory.TIMES, 10);
			Vector<Vehicle> log = VehicleDAO.getVehicleActivityByDate(date);
			int i;
			for (i = 0; i < log.size(); i++) {
				if (log.elementAt(i).getActivity() >= Constants.ATTENDANCE_MIN_READER_COUNT) {
					table.addCell(new Phrase(Integer.toString(i + 1), font));
					table.addCell(new Phrase(log.elementAt(i).getVehicle_no(), font));
					table.addCell(new Phrase(log.elementAt(i).getType_name(), font));
					table.addCell(new Phrase(log.elementAt(i).getDate_added().toString(), font));
					table.addCell(new Phrase(Integer.toString(log.elementAt(i).getActivity()), font));
				}
			}

			document.add(table);
			Paragraph end = new Paragraph("--- x --- End of Report --- x ---");
			end.setAlignment(Element.ALIGN_CENTER);
			document.add(end);
			document.close();
			Mail.send("srinjoy960@gmail.com", "Vehicle Attendance Report on "+dateToday, "TODO", fileObj);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
