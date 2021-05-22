package com.techelevator;

import java.io.File;
import java.util.List;

public class Question {
	private File quizFile;
	private List<String> lineAsList;
	
	public Question (File file, List<String> line) {
		this.quizFile = file;
		this.lineAsList = line;
	}
	
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

	public File getQuizFile() {
		return quizFile;
	}

	public List<String> getLineAsList() {
		return lineAsList;
	}

}