package com.techelevator.QuizMe;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuizWriter { // wanted to try the quizmaker exercise again where i put everything in the main method

	public static void main(String[] args) {
		System.out.println("Where is the file located?");
		Scanner console = new Scanner (System.in);
		String path = console.next();
		File file = new File (path);
		boolean run = true;
		while (run) {
			if (!file.exists()) System.out.println("That is not a valid file name! Please try again.");
			else if (!file.isFile()) System.out.println("Invalid file! Please try again.");
			else run = false;
		}
		List<QuizQuestion> questionsList = new ArrayList<QuizQuestion>();
		try (Scanner fileReader = new Scanner (file)) {
			int selection;
			String line;
			while (fileReader.hasNextLine()) {
				line = fileReader.nextLine();
				questionsList.add(new QuizQuestion(line));
			}
			String [] choicesArr;
			String correctAns;
			int score = 0;
			System.out.println("\n\nLet's get started...\n");
			for (QuizQuestion question: questionsList) {
				correctAns = question.getCorrectAnswer();
				choicesArr = question.getQuestionArr();
				boolean keepGoing = true;
				while (keepGoing) {
					System.out.println("\n" + question.askQuestion());
					System.out.println(question.getChoices());
					selection = console.nextInt();
					if (selection > 0 && selection < choicesArr.length) {
						System.out.println("Your Answer: " + selection + ". " + choicesArr[selection].replace("*", ""));
						if (choicesArr[selection].equals(correctAns)) {
							score++;
							System.out.println("Correct! Nice job.");
							keepGoing = false;
						}
						else System.out.println("Incorrect.");
						keepGoing = false;
					}
					else System.out.println("Invalid choice!");
				}
				if (questionsList.get(questionsList.size()-1).equals(question)) System.out.println("\n\nQuiz complete!");
				else System.out.println("\n\nNext Question...\n");
			}
			System.out.println("\n\nYou scored " + score + "/" + questionsList.size());
			if (score > 5) System.out.println("Nice! You know your stuff!");
			else if (score > 3) System.out.println("Eh, you did fine. Try to be better next time!");
			else System.out.println("Whoops, this is quite a low score. Maybe study more next time.");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
