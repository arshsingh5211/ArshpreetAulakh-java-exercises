package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordSearch {

	public static void main (String args[]) {
		Scanner console = new Scanner (System.in);
		System.out.print("Please enter the path of the text file to search: ");
		File file = getFile(console);
		System.out.print("Please enter a word you would like to seach for in the text: ");
		String wordToSearch = console.next();
		// TYPO (wanted to see printStackTrace) // File testFile = new File("alices_adventure_in_wonderland.txt");
		System.out.print("Would you like the search to be case-sensitive? Y/N: ");
		String result = console.next();
		boolean run = true;
		boolean caseSensitive = false;
		while (run) {
			if (result.equalsIgnoreCase("y") || result.equalsIgnoreCase("yes")) {
				caseSensitive = true;
				break;
			}
			else if (result.equalsIgnoreCase("n") || result.equalsIgnoreCase("no")) {
				caseSensitive = false;
				break;
			}
			else {
				System.err.println("Sorry, that is not a valid option! Please enter Y or N: ");
				result = console.next();
			}
		}
		getSearchResults(file, wordToSearch, caseSensitive);
	}
	
	private static File getFile (Scanner console) {
		boolean run = true;
		File file = null;
		String path;
		while (run) {
			path = console.next();
			file = new File (path);
			if (!file.exists()) System.err.println("Sorry, that file does not exist! Please try again."); // easy to create error
			else if (!file.isFile()) System.err.println("Sorry, that is not a valid file! Please try again."); // how do i get this error
			else run = false;
		}
		return file;
	}
	
	private static void getSearchResults (File file, String wordSearched, boolean caseSensitive) {
		try (Scanner fileInput = new Scanner (file)) {
			int lineNum = 1;
			int numOfResults = 0;
			System.out.println("\n************************************************************");
			while (fileInput.hasNextLine()) {
				String line = fileInput.nextLine();
				if ((caseSensitive && line.contains(wordSearched)) ^ (!caseSensitive && line.toLowerCase().contains(wordSearched.toLowerCase()))) {
					System.out.println(lineNum + ") " + line);
					numOfResults++;
				}
				lineNum += 1;
			}
			System.out.println("************************************************************");
			System.out.println("Total Occurrences of \"" + wordSearched + "\" in file: " + numOfResults + "."); 
			// prompt the user to see if they would like to search again? would have to put everything in methods, too much work
		}
		catch (FileNotFoundException e) {
			System.err.println("\nOh no! Unable to find a file named " + file.getPath() + "!\n");
			e.printStackTrace();
		}
	}
	
}