package com.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.database.LogDAO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.models.LogItem;
import com.properties.Constants;
import com.utils.DirectoryManager;
import com.utils.PDFGenerator;
import com.utils.PDFHeaderFooter;

/**
 * Servlet implementation class DailyLog
 */
public class DailyLog extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DailyLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new java.util.Date());
		Document document = null;
		OutputStream outputStream = null;

		RequestDispatcher rd = null;
		String date_in = request.getParameter("date");
		Date date = Date.valueOf(date_in);
//		String filename = timeStamp + ".pdf";
		String filename = "document.pdf";
		String rootpath = Constants.output;
		String filepath = rootpath + filename;
		System.out.println(filepath);
		try {
			document = new Document(PageSize.A4, 50, 50, 50, 50);
			File fileObj = new File(filepath);
			fileObj.createNewFile();
			outputStream = new FileOutputStream(new File(filepath));
			PdfWriter pw = PdfWriter.getInstance(document, outputStream);
			pw.setPageEvent(new PDFHeaderFooter());
			document.open();
			document.add(new Chunk(""));
			PdfPTable table = new PdfPTable(5);
			table.setWidths(new int[] { 1, 3, 2, 2, 2 });
			table.addCell(new PdfPCell(new Phrase("Sl_No")));
			table.addCell(new PdfPCell(new Phrase("Rfid Tag Number")));
			table.addCell(new PdfPCell(new Phrase("Reader Id")));
			table.addCell(new PdfPCell(new Phrase("Date")));
			table.addCell(new PdfPCell(new Phrase("Time")));
			table.setHeaderRows(1);

			Font font = FontFactory.getFont(FontFactory.COURIER, 12);
			Vector<LogItem> log = LogDAO.getLogByDate(date);
			System.out.println("Log Size:" + log.size());
			int i;
			for (i = 0; i < log.size(); i++) {
				table.addCell(new Phrase(Integer.toString(i + 1), font));
				table.addCell(new Phrase(log.elementAt(i).getRfid(), font));
				table.addCell(new Phrase(log.elementAt(i).getReader_id(), font));
				table.addCell(new Phrase(log.elementAt(i).getDate().toString(), font));
				table.addCell(new Phrase(log.elementAt(i).getTime().toString(), font));

			}

			document.add(table);
			document.close();
			response.setContentType("application/pdf");
			File pdfFile = new File(filepath);
			FileInputStream fileInputStream = new FileInputStream(pdfFile);
			OutputStream responseOutputStream = response.getOutputStream();
			int bytes;
			while ((bytes = fileInputStream.read()) != -1) {
				responseOutputStream.write(bytes);

			}
		} catch (DocumentException e) {
			request.setAttribute("message", "Document Exception");
			request.setAttribute("redirect", "dashboard.jsp");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			request.setAttribute("message", "File Creation Error");
			request.setAttribute("redirect", "dashboard.jsp");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} catch (IOException e) {
			request.setAttribute("message", "IO Error");
			request.setAttribute("redirect", "dashboard.jsp");
			rd = request.getRequestDispatcher("error.jsp");
			rd.forward(request, response);
		} finally {
			if (outputStream != null) {
				outputStream.close();
			}
		}
	}

}
