package com.techelevator;

public class Solution {

	public static void main(String[] args) {
		HomeworkAssignment test = new HomeworkAssignment (100);
		test.setTotalMarks(91);
		System.out.println((91*100/100));
		System.out.println("Letter Grade is " + test.getLetterGrade() + " for this assignment");
		System.out.println(test.getSubmitterName());
		test.setSubmitterName("arsh");
		System.out.println(test.getSubmitterName());


	}

}
