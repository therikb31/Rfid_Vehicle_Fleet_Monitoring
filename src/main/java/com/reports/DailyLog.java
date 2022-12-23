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
import com.database.LogItemDAO;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.models.Log;
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
	private static PdfPCell getCell(String text,Font font) {
		Phrase ph = new Phrase(text,font);
		PdfPCell res = new PdfPCell(ph);
		res.setMinimumHeight(20f);
		res.setVerticalAlignment(Element.ALIGN_CENTER);
		res.setHorizontalAlignment(Element.ALIGN_CENTER);
		return res;
	}
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
		
		
		String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new java.util.Date());
		String dateValue = new SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date());
		String time = new SimpleDateFormat("HH:mm:ss aa").format(new java.util.Date()).toUpperCase();
		Document document = null;
		OutputStream outputStream = null;

		RequestDispatcher rd = null;
		String date_in = request.getParameter("date");
		Date date = Date.valueOf(date_in);
//		String filepath = timeStamp + ".pdf";
		String filepath = "document.pdf";
		try {
			int marginLR = 20;
			document = new Document(PageSize.A4, marginLR, marginLR, 50, 50);
			File fileObj = new File(filepath);
			fileObj.createNewFile();
			outputStream = new FileOutputStream(new File(filepath));
			PdfWriter pw = PdfWriter.getInstance(document, outputStream);
			PDFHeaderFooter myHeaderFooter = new PDFHeaderFooter();
			myHeaderFooter.header = getServletContext().getRealPath("/static/Header/log.png");
			pw.setPageEvent(myHeaderFooter);
			document.open();
			document.add(new Chunk(""));
			Font regular = new Font(FontFamily.HELVETICA, 12);
			Font bold =new Font(FontFamily.HELVETICA, 12, Font.BOLD);
			if(pw.getCurrentPageNumber()==1) {
				document.add(new Phrase("Report Name:",regular));
				document.add(new Phrase(" Daily Log\n",bold));
				document.add(new Phrase("Date Generated: ",regular));
				document.add(new Phrase(dateValue+"\n",bold));
				document.add(new Phrase("Time Generated: ",regular));
				document.add(new Phrase(time+"\n",bold));
//				document.newPage();
			}
			PdfPTable table = new PdfPTable(6);
			table.setTotalWidth(document.getPageSize().getWidth() - (float)60.0);
			table.setLockedWidth(true);
			table.setWidths(new float[] { (float) 0.6, (float)1.2, (float)1.8,(float)3.2, 1, 1 });
			table.addCell(getCell("Sl No",bold));
			table.addCell(getCell("Vehicle No",bold));
			table.addCell(getCell("Vehicle Type",bold));
			table.addCell(getCell("Address",bold));
			table.addCell(getCell("Date",bold));
			table.addCell(getCell("Time",bold));
			
			
			table.setHeaderRows(1);
			Font font = FontFactory.getFont(FontFactory.TIMES, 10);
			Vector<Log> log = LogDAO.getDailyLog(date);
			int i;
			for (i = 0; i < log.size(); i++) {
				table.addCell(new Phrase(Integer.toString(i + 1), font));
				table.addCell(new Phrase(log.elementAt(i).getVehicle_no(), font));
				table.addCell(new Phrase(log.elementAt(i).getType_name(), font));
				table.addCell(new Phrase(log.elementAt(i).getAddress(), font));
				table.addCell(new Phrase(log.elementAt(i).getDate().toString(), font));
				table.addCell(new Phrase(log.elementAt(i).getTime().toString(), font));

			}

			document.add(table);
			document.close();
			response.setContentType("application/pdf");
			File pdfFile = new File(filepath);
			pdfFile.createNewFile();
			FileInputStream fileInputStream = new FileInputStream(pdfFile);
			OutputStream responseOutputStream = response.getOutputStream();
			int bytes;
			while ((bytes = fileInputStream.read()) != -1) {
				responseOutputStream.write(bytes);

			}
			fileInputStream.close();
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
