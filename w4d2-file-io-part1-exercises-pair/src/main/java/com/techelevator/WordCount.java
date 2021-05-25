package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {

	public static void main(String[] args) {
		Scanner console = new Scanner (System.in);
		File fileToRead = validateFile(console);
		wordAndSentenceCounter(fileToRead);
	}
	
	// is it better to put these in static methods or put them all in main method
	// this way seems more readable to me but does it impact performance (to a non-negligible degree)
	
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
	
	private static void wordAndSentenceCounter(File fileToRead) {
		int wordCount = 0;
		int sentenceCount = 0;
		try (Scanner fileReader = new Scanner(fileToRead)) {
			String line;
			while (fileReader.hasNextLine()) {
				line = fileReader.nextLine();
				if (!line.isEmpty()) {
					String [] words = line.trim().split("\\s+"); // does not account for edge cases but this is final number in pdf that they want
					wordCount += words.length;
					for (String word : words) {
						if (word.endsWith(".") || word.endsWith("?") || word.endsWith("!")) sentenceCount++; // edge cases?? (Mr. Smith, www.website.com, so excited!!!)
					}
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Word Count: " + wordCount);
		System.out.println("Sentence Count: " + sentenceCount);
	}
}
