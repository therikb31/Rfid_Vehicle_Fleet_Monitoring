package com.utils;

import java.io.File;
import java.io.IOException;

public class DirectoryManager {
	public static void main(String[] args) throws IOException {
		File pdffile = new File("document.pdf");
		pdffile.createNewFile();
		System.out.println(pdffile.getAbsolutePath());
		
	}
}
