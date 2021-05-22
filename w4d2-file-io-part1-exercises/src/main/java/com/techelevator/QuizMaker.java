package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuizMaker {
	public static void main (String args[]) {
		Scanner console = new Scanner (System.in);
		System.out.println("Please enter the path of the text file to search: ");
		File file = getFile(console);
		//System.out.println("Absolute Path of " + file.getName() + ": " + file.getAbsolutePath()); // to test it works correctly
		//List <String> lineList = getLineAsList(file);
		//Question test = new Question(file, lineList);
		runQuiz(file);
		//Question test = new Question(file, lineList);
		//String questionString = test.getQuizQuestion();
		//String [] choices = test.getQuizChoices();
		//String correct = test.getQuizAnswer();
		//System.out.println("Question: " + questionString);
		//System.out.println("Choices: " + Arrays.toString(choices));
		//System.out.println("Answer: " + correct);
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
			line = "";
			if (quiz.hasNextLine()) {
				line = quiz.nextLine();
				list = Arrays.asList(line.split("\\|"));
			}
			return list;
		} 
		catch (FileNotFoundException e) {
			e.printStackTrace();
			return null; // idk how to return something in a catch block if i don't want to return a list (if it cant find file)
		}
	}
	
	public static void askAQuestion (File file, Question quizQuestion) {
		try (Scanner quiz = new Scanner(file)) {
			Scanner userAnswers = new Scanner (System.in);
			String[] quizArr = quizQuestion.getQuizChoices();
			int choiceNum = 1;
			System.out.println(quizQuestion.getQuizQuestion());
			for (int i = 0; i < quizArr.length; i++) {
				System.out.println(choiceNum + ". " + quizArr[i]);
				choiceNum++;
			}
			boolean wrong = true;
			while (wrong) {
				System.out.print("Please select the number that corresponds to your selection: "); // fix wording
				int selection = userAnswers.nextInt();
				System.out.println("Your answer: " + quizArr[selection-1]);
				if (quizArr[selection-1].equalsIgnoreCase(quizQuestion.getQuizAnswer())) {
					System.out.println("Great Job!");
					wrong = false; // this is confusing, fix it later
				}
				else System.out.println("Sorry, that is incorrect! Please try again.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void runQuiz (File file) {
		try (Scanner quizInput = new Scanner (file)) {
			String line;
			while (quizInput.hasNextLine()) {
				line = quizInput.nextLine();
				System.out.println("First line: " + line);
				Question quizQuestion = new Question (file, getLineAsList(file, line));
				askAQuestion(file, quizQuestion);
				line = quizInput.nextLine();
				System.out.println("This line: " + line);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

// Create a class that can hold a quiz question, its available answers, and the correct answer.
// Try holding each quiz question in a list of quiz questions