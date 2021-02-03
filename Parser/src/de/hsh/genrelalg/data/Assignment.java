package de.hsh.genrelalg.data;


import de.hsh.genrelalg.database.Database;

/*
 * bildet eine Aufgabe ab
 */
public class Assignment {
	private String text;
	private Database base;
	private String answer;
	private double score;
	
	/*
	 * Konstruktor der Aufgabe
	 */
	public Assignment(String text, Database base, String answer, double score) {
		this.text = text;
		this.base = base;
		this.score = score;
		this.answer = answer;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public void setScore(double p) {
		this.score = p;
	}
	
	public  String getText() {
		return this.text;
	};
	public  void setText(String text) {
		this.text = text;
	};
	public void setAnswer(String solution) {
		this.answer = solution;
	}
	
	/*
	 * Liefert die korrekte Antwort einer Aufgabe
	 */
	public String getAnswer() {
		return this.answer;
	}
	
	/*
	 * Liefert die Datenbank, auf der die Lösung ausgewertet wird. 
	 */
	public Database getBase() {
		return this.base;
	}
	
	
}
