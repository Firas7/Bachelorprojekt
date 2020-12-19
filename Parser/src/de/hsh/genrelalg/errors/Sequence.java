package de.hsh.genrelalg.errors;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Attribute;

public class Sequence extends Mistake{

	String name;
	String text;
	double minus;
	String difficulty;
	boolean missing;
	List<Attribute> atts;
	
	public Sequence(List<Attribute> left, List<Attribute> right) {
		this.name = "Die Reihenfolge ";
		this.difficulty = "Medium";
		this.minus = 0.3;
		this.text = "Die Reihenfolge der Attribute stimmt nicht überein";
		this.missing = false;
		atts = new ArrayList<>();
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
	public void getAttributesOfError() {
		System.out.println("Die Reihenfolge der folgenden Attributen stimmt nicht: ");
		for(int i=0; i<this.atts.size(); i++) {
			System.out.println(this.atts.get(i).getName()+" ");
		}
	}

	public void checkAttributes(List<Attribute> left, List<Attribute> right) {
		for(int i = 0; i<left.size(); i++) {
			if(!left.get(i).getName().toUpperCase().equals(right.get(i).getName().toUpperCase())) {
				this.atts.add(right.get(i));
			}
		}
	}
}
