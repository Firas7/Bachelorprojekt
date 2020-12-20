package de.hsh.genrelalg.errors;

import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.feedback.Feedback;

public abstract class Mistake {
	String name ;
	String text;
	double minus ;
	String difficulty ;
	List<Attribute> atts;
	
	public abstract String getName();
	
	public abstract String getText();
	
	public abstract double getMinus();
	
	public abstract String getDifficulty();
	
	public abstract List<Feedback> getFeedbacks();

}
