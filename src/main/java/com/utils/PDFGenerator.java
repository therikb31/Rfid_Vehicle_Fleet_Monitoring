package com.utils;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.util.Vector;

import com.database.LogDAO;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImage;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.models.LogItem;
import com.itextpdf.text.Image;

public class PDFGenerator {
	public static void generate(String filepath) throws DocumentException, MalformedURLException, IOException {
        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
		OutputStream outputStream = new FileOutputStream(new File(filepath));
		PdfWriter pw = PdfWriter.getInstance(document, outputStream);
		pw.setPageEvent(new PDFHeaderFooter());
        document.open();
        
//        String header = "./src/main/resources/Header/log.png";
//        Image headerimg = Image.getInstance(header);
//        headerimg.scalePercent(20);
//        document.add(headerimg);
        
        PdfPTable table = new PdfPTable(4);
        table.setWidths(new int[]{1,3,2,4});
        table.addCell(new PdfPCell(new Phrase("Sl_No")));
        table.addCell(new PdfPCell(new Phrase("Rfid Tag Number")));
        table.addCell(new PdfPCell(new Phrase("Reader Id")));
        table.addCell(new PdfPCell(new Phrase("Crossed At")));
        table.setHeaderRows(1);
        
        Font font = FontFactory.getFont(FontFactory.COURIER, 12);
        Vector<LogItem> log = LogDAO.getLog();
        int i;
        for(i=0;i<log.size();i++) {
        	table.addCell(new Phrase(Integer.toString(i+1),font));
        	table.addCell(new Phrase(log.elementAt(i).getRfid(),font));
        	table.addCell(new Phrase(log.elementAt(i).getReader_id(),font));
        	table.addCell(new Phrase(log.elementAt(i).getCrossed_at().toString(),font));
        }
        document.add(table);
        document.close();
        System.out.println("Success");
		
	}
	public static void main(String[] args) throws DocumentException, MalformedURLException, IOException {
		generate("./src/main/resources/PDFOutput/output.pdf");
	}

}
