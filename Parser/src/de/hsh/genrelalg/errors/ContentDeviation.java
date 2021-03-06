package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.feedback.Feedback;
import de.hsh.genrelalg.score.DeductionReader;

/*
 * Fehler des Inhaltes
 */
public class ContentDeviation extends Mistake{

	
	Relation relation;
	boolean x;
	public ContentDeviation(Relation r , boolean x) {
		this.name = "Inhalt";
		this.difficulty = "Medium";
		this.text = "Abweichung des Inhaltes";
		this.feedbacks = new ArrayList<>();
		this.relation = r;
		this.x = x;
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
		this.feedbacks.add(new Feedback("Ein Pr�dikat k�nnte falsch sein oder die ausgef�hrte Operation passt nicht zur Aufgabe"));
		if(this.x) {
			// Die korrekte L�sung hat mehr Datens�tze 
			this.feedbacks.add(new Feedback("Folgende Datens�tze fehlen"));
		}else {
			// student solution has more records
			this.feedbacks.add(new Feedback("Folgende Datens�tze sind �berfl�ssig"));
		}
		return this.feedbacks;
	}

	
}
