package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Question {
	private File quizFile;
	private List<String> lineAsList;
	
	public Question (File file, List<String> line) {
		this.quizFile = file;
		this.lineAsList = line;
	}
	
	/*public List<String> getQuizLine() {
		try (Scanner quiz = new Scanner (quizFile)) {
			List<String> questionList = new LinkedList<>();
			questionList.addAll(Arrays.asList(lineInFile.split("\\|")));
			return questionList;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return null; // idk how to return something in a catch block if i don't want to return a list (if it cant find file)
	}*/
	
	public String getQuizQuestion () {
		return lineAsList.get(0);
	}
	
	public String[] getQuizChoices() {
		String [] choices = new String[lineAsList.size()-1];
		for (int i = 0; i < lineAsList.size()-1; i++) {
			choices[i] = lineAsList.get(i+1).substring(0, 1).toUpperCase() + lineAsList.get(i+1).substring(1).replace("*", "");
		}
		return choices;
	}
	
	public String getQuizAnswer() {
		for (int i = 1; i < lineAsList.size(); i++) { // used for loop instead of for-each to skip the first item (question)
			if (lineAsList.get(i).contains("*")) return lineAsList.get(i).replace("*", "");
		}
			return "None!";
	}
	
	/*public String getCorrectAnswer() {
		String[] arr = getQuizChoices();
		//String correctAns = "jhkjh";
		for (String choice : arr) {
			if (choice.contains("*")) {
				return choice;
			}
		}
		return "No correct answer??";
	}*/

	public File getQuizFile() {
		return quizFile;
	}

	public List<String> getLineAsList() {
		return lineAsList;
	}

}


//Create a class that can hold a quiz question, its available answers, and the correct answer.