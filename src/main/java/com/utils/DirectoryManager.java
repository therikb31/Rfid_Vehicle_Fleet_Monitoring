package com.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.properties.Constants;

public class DirectoryManager {
	public static String getPath(String filepath) {
		String rootpath = Constants.root.toString();
		return Paths.get(rootpath,filepath).toString();
	}
	public static void main(String[] args) {
		System.out.println(Constants.root);
		System.out.println(getPath("/document.pdf"));
	}
}
