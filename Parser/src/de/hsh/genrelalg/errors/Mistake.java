package de.hsh.genrelalg.errors;

public abstract class Mistake {
	String name ;
	String text;
	double minus ;
	String difficulty ;
	
	public abstract String getName();
	
	public abstract String getText();
	
	public abstract double getMinus();
	
	public abstract String getDifficulty();

}
