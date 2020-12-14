package de.hsh.genrelalg.data;

import org.antlr.v4.parse.ATNBuilder.subrule_return;

import de.hsh.genrelalg.database.Database;

public class Aufgabe {
	String text;
	Database base;
	String answer;
	
	public Aufgabe(String text, Database base, String answer) {
		this.setText(text);
		this.setDatabase(base);
		this.setAnswer(answer);
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
