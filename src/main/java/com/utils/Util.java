package com.utils;

import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;

public class Util {
	public static PdfPCell getCell(String text, Font font) {
		Phrase ph = new Phrase(text, font);
		PdfPCell res = new PdfPCell(ph);
		res.setMinimumHeight(20f);
		res.setVerticalAlignment(Element.ALIGN_CENTER);
		res.setHorizontalAlignment(Element.ALIGN_CENTER);
		return res;
	}
}
