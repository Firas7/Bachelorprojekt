package de.hsh.genrelalg.comparison;

import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.Mistake;

import java.util.List;

public class Printer {

	List<Mistake> errors;
	public Printer(List<Mistake> erros) {
		this.errors = erros;
		this.printErrors();
	}
	
	public void printErrors() {
		for(int i = 0; i < this.errors.size(); i++) {
			System.out.println("Error Name: " + this.errors.get(i).getName());
			System.out.println("Error Minus: " + this.errors.get(i).getMinus());
			System.out.println("Error Diffeculty: " + this.errors.get(i).getDifficulty());
		}
	}
}
