package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileSplitter {

	public static void main(String[] args) {

	}

	public static void fileSplitter (File fileToSplit, int maxLines) {
		try {
			Scanner fileInput = new Scanner (fileToSplit);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	// you have one large file and have to split it into 100 line files
	// first read fileToSplit
	// figure out how many total lines are in original file and then deduce how many files you need
	// make file writer for first file
	// add line by line using a loop
}
