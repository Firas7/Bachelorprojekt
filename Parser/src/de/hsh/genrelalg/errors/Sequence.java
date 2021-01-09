package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.comparison.DeductionReader;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.feedback.Feedback;

public class Sequence extends Mistake{

	boolean missing;
	static double minus;
	public Sequence(Attribute left, Attribute right) {
		this.name = "Reihenfolge";
		this.difficulty = "Medium";
		this.text = "Abweichung der Reihenfolge";
		this.missing = false;
		atts = new ArrayList<>();
		this.feedbacks = new ArrayList<>();
		atts.add(left);
		atts.add(right);
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
		return DeductionReader.getMinus(this);
	}

	@Override
	public String getDifficulty() {
		return this.difficulty;
	}

	@Override
	public List<Feedback> getFeedbacks() {	
		String feedback;
		for(int i=0; i<this.atts.size(); i++) {
			feedback = " Die Reihenfolge des '"+this.atts.get(i).getName()+"' Attributs ist falsch.";
			this.feedbacks.add(new Feedback(feedback));
		}
		return this.feedbacks;
	}



}
