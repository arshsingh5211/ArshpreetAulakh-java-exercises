package com.techelevator;

public class HomeworkAssignment {
	private int totalMarks;
	private int possibleMarks;
	private String submitterName;
	private String letterGrade;
	
	public HomeworkAssignment(int possibleMarks) {
		this.possibleMarks = possibleMarks;
	}
	public int getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}
	public int getPossibleMarks() {
		return possibleMarks;
	}
	public String getSubmitterName() {
		return submitterName;
	}
	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}
	public String getLetterGrade() {
		double percent = (totalMarks * 100 / possibleMarks);
		if (percent < 60) {
			letterGrade = "F";
		}
		else if (percent < 70) {
			letterGrade = "D";
		}
		else if (percent < 80) {
			letterGrade = "C";
		}
		else if (percent < 90) {
			letterGrade = "B";
		}
		else letterGrade = "A";
		return letterGrade;
	}
}
