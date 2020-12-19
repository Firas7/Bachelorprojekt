package de.hsh.genrelalg.data;


import de.hsh.genrelalg.database.Database;

public class Assignment {
	String text;
	Database base;
	String answer;
	double score;
	
	public Assignment(String text, Database base, String answer, double score) {
		this.setText(text);
		this.setDatabase(base);
		this.setScore(score);
		this.setAnswer(answer);
	}
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double p) {
		this.score = p;
	}
	public  Database getDatabase() {
		return this.base;
	};
	public  void setDatabase(Database database) {
		this.base = database;
	};
	public  String getText() {
		return this.text;
	};
	public  void setText(String text) {
		this.text = text;
	};
	public void setAnswer(String solution) {
		this.answer = solution;
	}
	
	public String getAnswer() {
		return this.answer;
	}
	
	public void printTextofTask() {
		System.out.println(this.text);
	}
}
