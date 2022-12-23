package com.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.properties.Constants;

public class DirectoryManager {
	public static void main(String[] args) throws IOException {
		File pdffile = new File("document.pdf");
		pdffile.createNewFile();
		System.out.println(pdffile.getAbsolutePath());
		
	}
}
