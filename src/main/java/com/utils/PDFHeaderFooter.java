package com.utils;
import java.io.IOException;
import java.net.MalformedURLException;

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

public class PDFHeaderFooter extends PdfPageEventHelper {

    private PdfTemplate t;
    private Image total;

    public void onStartPage(PdfWriter writer, Document document) {
    	String header = "./src/main/resources/Header/log.png";
        Image headerimg;
		try {
			headerimg = Image.getInstance(header);
			headerimg.scalePercent(20);
	        try {
				document.add(headerimg);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (BadElementException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
    public void onEndPage(PdfWriter writer, Document document) {
    	Rectangle pageSize = document.getPageSize();
        ColumnText.showTextAligned(writer.getDirectContent(), Element.ALIGN_RIGHT, new Phrase(String.format("Page No:%s", String.valueOf(writer.getCurrentPageNumber())),FontFactory.getFont(FontFactory.COURIER, 12)),
                pageSize.getRight(30), pageSize.getBottom(30), 0);
    }
    

//    @Override
//    public void onEndPage(PdfWriter writer, Document document) {
//        try {
//			addHeader(document);
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DocumentException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//        addFooter(writer);
//    }
//
//    private void addHeader(Document document) throws MalformedURLException, IOException, DocumentException{
//      String header = "./src/main/resources/Header/log.png";
//      Image headerimg = Image.getInstance(header);
//      headerimg.scalePercent(20);
//      document.add(headerimg);
//    }
//
//    private void addFooter(PdfWriter writer){
//        PdfPTable footer = new PdfPTable(3);
//        try {
//            // set defaults
//            footer.setWidths(new int[]{24, 2, 1});
//            footer.setTotalWidth(527);
//            footer.setLockedWidth(true);
//            footer.getDefaultCell().setFixedHeight(40);
//            footer.getDefaultCell().setBorder(Rectangle.TOP);
//            footer.getDefaultCell().setBorderColor(BaseColor.LIGHT_GRAY);
//
//            // add copyright
//            footer.addCell(new Phrase("\u00A9 Memorynotfound.com", new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD)));
//
//            // add current page count
//            footer.getDefaultCell().setHorizontalAlignment(Element.ALIGN_RIGHT);
//            footer.addCell(new Phrase(String.format("Page %d of", writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)));
//
//            // add placeholder for total page count
//            PdfPCell totalPageCount = new PdfPCell(total);
//            totalPageCount.setBorder(Rectangle.TOP);
//            totalPageCount.setBorderColor(BaseColor.LIGHT_GRAY);
//            footer.addCell(totalPageCount);
//
//            // write page
//            PdfContentByte canvas = writer.getDirectContent();
//            canvas.beginMarkedContentSequence(PdfName.ARTIFACT);
//            footer.writeSelectedRows(0, -1, 34, 50, canvas);
//            canvas.endMarkedContentSequence();
//        } catch(DocumentException de) {
//            throw new ExceptionConverter(de);
//        }
//    }
//
//    public void onCloseDocument(PdfWriter writer, Document document) {
//        int totalLength = String.valueOf(writer.getPageNumber()).length();
//        int totalWidth = totalLength * 5;
//        ColumnText.showTextAligned(t, Element.ALIGN_RIGHT,
//                new Phrase(String.valueOf(writer.getPageNumber()), new Font(Font.FontFamily.HELVETICA, 8)),
//                totalWidth, 6, 0);
//    }
}