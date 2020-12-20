package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.feedback.Feedback;

/*
 * Dieser Fehler rep�estiert die Ungleichheit der Spaltenanzahl.
 * */
public class Inequality extends Mistake{

	String name ;
	String text  ;
	double minus ;
	String difficulty;
	List<Attribute> atts;
	List<Feedback> feeedbacks;
	boolean extra, missing ;
	public Inequality(List<Attribute> left, List<Attribute> right) {
		 this.name = "Ungleichheit";
		 this.text = "Die Spaltenanzahl stimmt nicht �berein" ;
		 this.minus = 0.3;
		 this.difficulty = "Medium";
		 this.extra = false;
		 this.missing = false;
		 this.atts = new ArrayList<>();
		 this.feeedbacks = new ArrayList<>();
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

	public boolean getExtra() {
		return this.extra;
	}
	
	public boolean getMissing() {
		return this.missing;
	}
	
	public void checkAttributes(List<Attribute> left, List<Attribute> right) {
		boolean found = false;
		if(left.size() > right.size()) {
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
		} else if(left.size() < right.size()) {
			for(int i = 0; i < right.size(); i++) {
				found = false;
				for(int j  = 0; j< left.size(); j++) {
					if(right.get(i).getName().toUpperCase().equals(left.get(j).getName().toUpperCase())) {
						found = true;
					}
				}
				if(!found) {
					// �berfl�ssige Attribute
					this.extra = true;
					atts.add(right.get(i));
				}
			}
		}
	}
	
	@Override
	public List<Feedback> getFeedbacks() {
		for(int i=0; i<this.atts.size(); i++) {
			if(this.extra) {
				this.feeedbacks.add(new Feedback("Das Attribute " + this.atts.get(i).getName() + " ist ueberfluessig.."));
			}else if(this.missing) {
				this.feeedbacks.add(new Feedback("Das Attribute " + this.atts.get(i).getName() + " fehlt.."));
			}
		}
		if(this.atts.size() == 0) {
			this.feeedbacks.add(new Feedback("Pr�fen Sie die Operation und die dazu verwendete Relationen"));
		}
		return this.feeedbacks;
	}
	
}
