package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.comparison.DeductionReader;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.feedback.Feedback;

public class Discrepancy extends Mistake{
	
	boolean missing;
	Attribute atts;
	
	public Discrepancy(Attribute att) {
	
		this.name = "Unstimmigkeit der Namen";
		this.difficulty = "Medium";
		this.text = "Namen der Attribite stimmen nicht überein";
		this.missing = false;
		this.atts = att;
		this.feedbacks = new ArrayList<>();
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
	public String getName() {
		return this.name;
	}
	@Override
	public String getDifficulty() {
		return this.difficulty;
	}

	@Override
	public List<Feedback> getFeedbacks() {
		this.feedbacks.add(new Feedback("Das Attribut "+ this.atts.getName() + " gehört nicht zur Lösung"));
		return this.feedbacks;
	}

	
	
}
