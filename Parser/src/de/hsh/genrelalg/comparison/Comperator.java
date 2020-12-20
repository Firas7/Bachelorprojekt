package de.hsh.genrelalg.comparison;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Assignment;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.ErrorService;
import de.hsh.genrelalg.errors.Inequality;
import de.hsh.genrelalg.errors.Sequence;
import de.hsh.genrelalg.relalg.Intersection;
import de.hsh.genrelalg.relalg.RelationalAlgebra;
import de.hsh.genrelalg.relalg.SetMinus;
import de.hsh.genrelalg.relalg.Union;

public class Comperator {

	ErrorService errorService = ErrorService.getInstance();
	ReportGenerator generator ;
	Relation correctAnswer , anwserOfStudent;
	List<Attribute> attributes = new ArrayList<>();
	Assignment task;
	public Comperator (Assignment task,Relation r1 , Relation r2) {
		this.correctAnswer = r1;
		this.anwserOfStudent = r2;
		this.task = task;
		//checkLinesOfTables();
		checkColumns();
		printError();
	}
	
	public void printError() {
		
		// struktureller Vergleich okay..
		if(errorService.getMistakes().size() == 0) {
			Union union = new Union(this.correctAnswer,this.anwserOfStudent);
			Intersection intersection = new Intersection(this.correctAnswer,this.anwserOfStudent);
			SetMinus minus = new SetMinus(union.getResult(),intersection.getResult(),12);
			writeOutput(minus, "Minus ");
			double socre = Calculator.calculatePoints(errorService, this.task.getScore());
			if(minus.getResult().getTuples().size() == 0) {
				generator = new ReportGenerator(minus.getResult(),errorService, socre);
			}else {
				boolean x= checkNumbersOfTupel();
				generator = new ReportGenerator(minus.getResult(),errorService, socre, x);
			}
			
			
		}
		// struktureller Vergleich nicht okay.
		else {
			double socre = Calculator.calculatePoints(errorService, this.task.getScore());
			generator = new ReportGenerator(errorService, socre);
		}
		
	}
	
	/*
	 * Diese Methode prüft die Zeilen beider Relationen:
	 * 1- Enthält die neu entstehende Relation keinen Datensatz, ist damit die eingereichte Lösung richtig
	 * 2- Enthält die neu entstehnde Relation mindestens einen Datensatz, ist damit die Lösung falsch. Dabei muss das Prädikat geprüft werden.
	 * 
	 * */
	public void checkLinesOfTables() {
		
		/* inhaltlicher Vergleich */
		Union union = new Union(this.correctAnswer,this.anwserOfStudent);
		Intersection intersection = new Intersection(this.correctAnswer,this.anwserOfStudent);
		SetMinus minus = new SetMinus(union.getResult(),intersection.getResult(),12);
		writeOutput(minus, "Minus ");
		
		double socre = Calculator.calculatePoints(errorService, this.task.getScore());
		boolean x = checkNumbersOfTupel();
		generator = new ReportGenerator(minus.getResult(),errorService, socre, x);
	}
	
	/*
	 * Diese Methode prüft, ob die korrekte Relation mehr Datensätze oder weniger als die Relation der eingereichten Lösung hat.
	 * wenn ja: wird der Boolean-Wert x auf true gesetzt anderenfalls flase.
	 * */
	public boolean checkNumbersOfTupel() {
		boolean x = false;
		int tupleLeft = this.correctAnswer.getTuples().size();
		int tupleRight = this.anwserOfStudent.getTuples().size();
		
		if(tupleLeft > tupleRight) {
			x = true;
		}
		return x;
	}
	
	/*
	 * TODO Zeilen und Spalten beider Relation vergleichen
	 * 
	 * */
	public void checkColumns() {
		
		boolean different = false;
		int sizeLeft = this.correctAnswer.getAttributes().size();
		int sizeRight = this.anwserOfStudent.getAttributes().size();
		if(sizeLeft == sizeRight) {
			for(int i = 0; i < this.correctAnswer.getAttributes().size(); i++) {
				boolean found = false;
				for(int j = 0; j < this.anwserOfStudent.getAttributes().size(); j++) {
					if(this.correctAnswer.getAttributes().get(i).getName().toUpperCase().equals(this.anwserOfStudent.getAttributes().get(j).getName().toUpperCase())) {
						found = true;
					}
				}
				if(!found) {
					attributes.add(this.anwserOfStudent.getAttributes().get(i));
					ErrorService.addError(new Discrepancy(this.correctAnswer.getAttributes(), this.anwserOfStudent.getAttributes()));
					different = true;
				}
			}
			if(!different) {
				// check the sequence of attributes
				checkSequenceOfAttributes();
			}
		}else {
			// Error dass Attribute nicht miteinander übereinstimmen.
			System.out.println("Anzahl der Spalten beider Relationen ist ungleich!. ");
			ErrorService.addError(new Inequality(this.correctAnswer.getAttributes(), this.anwserOfStudent.getAttributes()));
		}
	}
	
	public void checkSequenceOfAttributes() {
		for(int i = 0; i<this.correctAnswer.getAttributes().size(); i++) {
			if(!this.correctAnswer.getAttributes().get(i).getName().toUpperCase().equals(this.anwserOfStudent.getAttributes().get(i).getName().toUpperCase())) {
				ErrorService.addError(new Sequence(this.correctAnswer.getAttributes(), this.anwserOfStudent.getAttributes()));
			}
		}
	}
	
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Checking Result: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}
}
