package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		File fileToRead = validateFile(console);
		System.out.println(fileToRead.getAbsolutePath());
		try (Scanner fileReader = new Scanner(fileToRead)) {
			int wordCount = 0;
			String line;
			int lineNum = 1; //for testing purposes only
			while (fileReader.hasNextLine()) {
				String[] wordsInLine;
				line = fileReader.nextLine();
				if (line.isEmpty() || line == null) wordsInLine = new String[] {};
				else wordsInLine = line.trim().replaceAll("\n", "").split("\\s+");
				System.out.println(lineNum + ") " + Arrays.toString(wordsInLine));
				wordCount += wordsInLine.length;
				System.out.println(lineNum + ") " + wordCount);
				lineNum++;
			}
			//System.out.println("Word Count: " + wordCount);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static File validateFile (Scanner console) {
		File file = null;
		boolean run = true;
		while (run) {
			System.out.println("Where is the text file?");
			String path = console.next();
			file = new File (path);
			if (!file.exists()) System.err.println("This file does not exist!");
			else if (!file.isFile()) System.err.println("This is not a valid file!");
			else run = false;
		}
		return file;
	}

}
