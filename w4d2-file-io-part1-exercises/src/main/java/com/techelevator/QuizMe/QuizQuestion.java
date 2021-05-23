package com.techelevator.QuizMe;

import java.util.Arrays;

public class QuizQuestion {
	private String[] lineArr;
	
	public QuizQuestion (String line) {
		lineArr = line.split("\\|");
	}
	
	public String askQuestion() {
		return lineArr[0];
	}
	
	public String getChoices() {
		String choicesString = "";
		String [] choices = new String[lineArr.length - 1];
		for (int i = 0; i < choices.length; i++) {
			choices[i] = lineArr[i+1];
			choicesString += (i+1) + ". " + choices[i] + "\n";
		}
		return choicesString.replace("*", "");
	}
	
	public String getCorrectAnswer() {
		int index = 0;
		for (int i = 1; i < lineArr.length; i++) {
			if (lineArr[i].contains("*")) index = i;
		}
		return lineArr[index];
	}

	public String[] getQuestionArr() {
		return lineArr;
	}

}
