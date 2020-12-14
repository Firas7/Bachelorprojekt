package de.hsh.genrelalg.errors;

public class Discrepancy extends Mistake{
	
	String name;
	String text;
	double minus;
	String difficulty;

	public Discrepancy() {
	
		this.name = "Discrepancy Error";
		this.difficulty = "Medium";
		this.minus = 0.3;
		this.text = "Zeilen oder Spalten stimmen nicht überein";
	}

	@Override
	public String getText() {
		return this.text;
	}
	
	@Override
	public double getMinus() {
		return this.minus;
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public String getDifficulty() {
		return this.difficulty;
	}
	
}
