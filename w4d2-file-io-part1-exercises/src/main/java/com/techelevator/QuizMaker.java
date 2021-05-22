package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {
	public static void main (String args[]) {
		Scanner console = new Scanner (System.in);
		System.out.println("Please enter the path of the text file to search: ");
		File file = getFile(console);
		runQuiz(file);
	}
	
	private static File getFile(Scanner console) {
		String fileString;
		File file = null;
		boolean run = true;
		while (run) {
			fileString = console.next();
			file = new File (fileString);
			if (!file.exists()) System.out.println("Sorry, that file does not exist! Please try again");
			else if (!file.isFile()) System.out.println("Sorry, that is not a valid file! Please try again");
			else run = false;
		}
		return file;
	}
	
	public static List<String> getLineAsList (File quizFile, String line) {
		List<String> list = new ArrayList<>();
		try (Scanner quiz = new Scanner (quizFile)) {
			list = Arrays.asList(line.split("\\|"));
			return list;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null; // idk how to return something in a catch block if i don't want to return a list (if it cant find file)
		}
	}
	
	public static boolean askAQuestion (Question quizQuestion) {
		boolean isCorrect = false;
		Scanner userAnswers = new Scanner (System.in);
		String[] quizArr = quizQuestion.getQuizChoices();
		int choiceNum = 1;
		System.out.println("\n" + quizQuestion.getQuizQuestion());
		for (int i = 0; i < quizArr.length; i++) {
			System.out.println(choiceNum + ". " + quizArr[i]);
			choiceNum++;
		}
		try {
			System.out.print("\nPlease select the number that corresponds to your selection: "); // fix wording
			int selection = userAnswers.nextInt();
			if (selection < 1 || selection > quizArr.length) {
				System.err.println("Sorry, that is not a valid selection! Please try again.\n");
				askAQuestion (quizQuestion);
			}
			else {
				System.out.println("Your answer: " + quizArr[selection-1]);
				if (quizArr[selection-1].equalsIgnoreCase(quizQuestion.getQuizAnswer())) {
					isCorrect = true;
					System.out.println("Great Job!");
				}
				else System.out.println("Sorry, that is incorrect!");
			}
		}
		catch (InputMismatchException e) {
			System.err.println("Selection must be a number! Please enter a number (1-4) to indicate your selection:");
			askAQuestion (quizQuestion);
		}
			return isCorrect;
	}

	public static void runQuiz (File file) {
		try (Scanner quizInput = new Scanner (file)) {
			Question quizQuestion;
			int score = 0;
			int totalQuestions = 0;
			while (quizInput.hasNextLine()) {
				String line = quizInput.nextLine();
				List<String>lineList = getLineAsList(file, line);
				quizQuestion = new Question (file, lineList);
				if (askAQuestion(quizQuestion)) score++; // this seems messy and error-prone
				totalQuestions++;
				if (quizInput.hasNextLine()) System.out.println("\n\nNext Question...\n");
				else System.out.println("\n\nQuiz complete!\n");
			}
			System.out.println("\nHere is your score: " + score + " out of " + totalQuestions);
			if (score > 5) System.out.println("Nice! You know your stuff!");
			else if (score > 3) System.out.println("You had an average score. Try to beat it next time!");
			else System.out.println("Oh wow, this is a low score. Maybe study more next time.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}