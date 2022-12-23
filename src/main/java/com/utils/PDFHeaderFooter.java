package com.utils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfPageEventHelper;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;
import com.properties.Constants;

public class PDFHeaderFooter extends PdfPageEventHelper {
	public String header;

	public void onStartPage(PdfWriter writer, Document document) {
//    	String rootpath = Constants.root.toString();
//    	String headerpath = "/Header/log.png";
//    	String header = Paths.get(root,headerpath).toString();
		Image headerimg;
		if (header != null) {
			try {
				headerimg = Image.getInstance(header);
				headerimg.scalePercent(20);
				document.add(headerimg);
			} catch (BadElementException | IOException e) {
				e.printStackTrace();
			} catch (DocumentException e) {
				e.printStackTrace();
			}
		}

	}

	public void onEndPage(PdfWriter writer, Document document) {
		Rectangle pageSize = document.getPageSize();
		ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT,
				new Phrase(String.format("Page No:%s", String.valueOf(writer.getCurrentPageNumber())),
						FontFactory.getFont(FontFactory.COURIER, 12)),
				pageSize.getRight(30), pageSize.getBottom(30), 0);
	}
}