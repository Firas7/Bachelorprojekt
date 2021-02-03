package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.feedback.Feedback;
import de.hsh.genrelalg.score.DeductionReader;

/*
 *  Fehler der Reihenfolge der Attribute
 */
public class Sequence extends Mistake{

	boolean missing;
	static double minus;
	public Sequence(Attribute att) {
		this.name = "Reihenfolge";
		this.difficulty = "Medium";
		this.text = "Abweichung der Reihenfolge";
		this.missing = false;
		atts = new ArrayList<>();
		this.feedbacks = new ArrayList<>();
		atts.add(att);
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
			feedback = " Das Attribut '"+this.atts.get(i).getName()+"' steht an der falschen Stelle";
			this.feedbacks.add(new Feedback(feedback));
		}
		return this.feedbacks;
	}

	public void addFeedback(Feedback fed) {
		this.feedbacks.add(fed);
	}


}
