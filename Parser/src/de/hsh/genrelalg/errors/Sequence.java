package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.feedback.Feedback;

public class Sequence extends Mistake{

	String name;
	String text;
	double minus;
	String difficulty;
	boolean missing;
	List<Attribute> atts;
	List<Feedback> feedbacks;
	
	public Sequence(List<Attribute> left, List<Attribute> right) {
		this.name = "Die Reihenfolge ";
		this.difficulty = "Medium";
		this.minus = 0.3;
		this.text = "Die Reihenfolge der Attribute stimmt nicht überein";
		this.missing = false;
		atts = new ArrayList<>();
		this.feedbacks = new ArrayList<>();
		checkAttributes(left, right);
	}
		
	@Override
	public String getName() {
		return this.name;
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
	public String getDifficulty() {
		return this.difficulty;
	}

	@Override
	public List<Feedback> getFeedbacks() {	
		String feedback;
		for(int i=0; i<this.atts.size(); i++) {
			feedback = " Die Reihenfolge des "+this.atts.get(i).getName()+" Attributs ist falsch.";
			this.feedbacks.add(new Feedback(feedback));
		}
		return this.feedbacks;
	}

	public void checkAttributes(List<Attribute> left, List<Attribute> right) {
		for(int i = 0; i<left.size(); i++) {
			if(!left.get(i).getName().toUpperCase().equals(right.get(i).getName().toUpperCase())) {
				this.atts.add(right.get(i));
			}
		}
	}
}
