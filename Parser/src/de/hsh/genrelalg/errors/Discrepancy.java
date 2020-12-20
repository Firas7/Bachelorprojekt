package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.feedback.Feedback;

public class Discrepancy extends Mistake{
	
	String name;
	String text;
	double minus;
	String difficulty;
	boolean missing;
	List<Attribute> atts;
	List<Feedback> feedbacks;
	public Discrepancy(List<Attribute> left, List<Attribute> right) {
	
		this.name = "Unstimmigkeit der Namen oder Reihenfolge ";
		this.difficulty = "Medium";
		this.minus = 0.3;
		this.text = "Namen der Attribite stimmen nicht �berein oder die Reihenfolge";
		this.missing = false;
		atts = new ArrayList<>();
		this.feedbacks = new ArrayList<>();
		checkAttributes(left, right);
	}

	@Override
	public String getText() {
		return this.text;
	}
	
	@Override
	public double getMinus() {
		if(this.missing) {
			return 0.9;
		}else {
			return this.minus;
		}
		
	}
	@Override
	public String getName() {
		return this.name;
	}
	@Override
	public String getDifficulty() {
		return this.difficulty;
	}

	@Override
	public List<Feedback> getFeedbacks() {
		if(this.missing) {
			for(int i =0; i< this.atts.size(); i++) {
				this.feedbacks.add(new Feedback("Das Attribute " + this.atts.get(i).getName()+ " fehlt."));
			}
		}else {
			this.feedbacks.add(new Feedback("Die Reihenfolge der Attribute ist falsch!"));
		}
		return this.feedbacks;
	}
	
	public void checkAttributes(List<Attribute> left, List<Attribute> right) {
		boolean found = false;
		for(int i = 0; i < left.size(); i++) {
			 found = false;
			for(int j  = 0; j< right.size(); j++) {
				if(left.get(i).getName().toUpperCase().equals(right.get(j).getName().toUpperCase())) {
					found = true;
				}
			}
			if(!found) {
				// fehlende Attribute
				this.missing = true;
				atts.add(left.get(i));
			}
		}
	}
	
}
