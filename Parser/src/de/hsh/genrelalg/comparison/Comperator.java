package de.hsh.genrelalg.comparison;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Assignment;
import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.errors.Discrepancy;
import de.hsh.genrelalg.errors.ErrorService;
import de.hsh.genrelalg.errors.ContentDeviation;
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
	public Comperator (Assignment task,Relation r1 , Relation r2)  {
		this.correctAnswer = r1;
		this.anwserOfStudent = r2;
		this.task = task;
		DeductionReader.getDeductions();
		checkStructure();
		checkContent();
	}
	
	public void checkContent(){
		
		/*
		 * Der strukturelle Vergleich weist keinen Fehler auf
		 */
		if(errorService.getMistakes().size() == 0) {
			Union union = new Union(this.correctAnswer,this.anwserOfStudent);
			Intersection intersection = new Intersection(this.correctAnswer,this.anwserOfStudent);
			SetMinus minus = new SetMinus(union.getResult(),intersection.getResult(),12);
			writeOutput(minus, "Minus ");
			
			double socre = Calculator.calculatePoints(errorService, this.task.getScore());
			// Keine Datensätze übrig
			if(minus.getResult().getTuples().size() == 0) {
				generator = new ReportGenerator(minus.getResult(),errorService, socre);
			}else {
				// Das Ergebnis hat mehr Datensätze 
				boolean x= checkNumbersOfTupel();
				ErrorService.addError(new ContentDeviation(minus.getResult(),x));
				generator = new ReportGenerator(minus.getResult(),errorService, 0.0, x);
			}	
		}
		
		else {
			// struktureller Vergleich schlägt fehl, dann setze die Punkte auf 0.
			generator = new ReportGenerator(errorService, 0.0);
		}
		
	}
	

	/*
	 * Diese Methode prüft, ob die korrekte Relation mehr Datensätze oder weniger als die Relation der eingereichten Lösung hat.
	 * wenn ja: wird der Boolean-Wert x auf true gesetzt anderenfalls flase.
	 */
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
	 * Diese Methode führt den Strukturvergleich durch.
	 */
	public void checkStructure() {
		
		boolean different = false;
		int sizeLeft = this.correctAnswer.getAttributes().size();
		int sizeRight = this.anwserOfStudent.getAttributes().size();
		boolean found = false;
		if(sizeLeft == sizeRight) {	
				for(int j = 0; j < this.anwserOfStudent.getAttributes().size(); j++) {
					found = this.correctAnswer.containsAttribute(this.anwserOfStudent.getAttributes().get(j));
					if(!found) {
						attributes.add(this.anwserOfStudent.getAttributes().get(j));
						System.out.println(this.anwserOfStudent.getAttributes().get(j).getName());
						ErrorService.addError(new Discrepancy(this.anwserOfStudent.getAttributes().get(j)));
						different = true;
					}
				
				found = false;
			}
			if(!different) {
				// Prüfung die Reihenfolge der Attribute beider Lösungen
				checkSequenceOfAttributes();
			}
		}else {
			// Die Spaltenanzahl stimmt nicht überein
			ErrorService.addError(new Inequality(this.correctAnswer.getAttributes(), this.anwserOfStudent.getAttributes()));
		}
	}
	
	/*
	 * Diese Methode führt die Prüfung der Reihenfolge der Attribute durch
	 */
	public void checkSequenceOfAttributes() {
		for(int i = 0; i<this.correctAnswer.getAttributes().size(); i++) {
			if(!this.correctAnswer.getAttributes().get(i).getName().toUpperCase().equals(this.anwserOfStudent.getAttributes().get(i).getName().toUpperCase())) {
				ErrorService.addError(new Sequence(this.correctAnswer.getAttributes().get(i), this.anwserOfStudent.getAttributes().get(i)));
			}
		}
	}
	
	
	/*
	 * Diese Methode prüft die Zeilen beider Relationen:
	 * 1- Enthält die neu entstehende Relation keinen Datensatz, ist damit die eingereichte Lösung richtig
	 * 2- Enthält die neu entstehnde Relation mindestens einen Datensatz, ist damit die Lösung falsch. Dabei muss das Prädikat geprüft werden.
	 * 
	 */
	public void checkLinesOfTables() throws NumberFormatException, IOException {
		
		/* inhaltlicher Vergleich */
		Union union = new Union(this.correctAnswer,this.anwserOfStudent);
		Intersection intersection = new Intersection(this.correctAnswer,this.anwserOfStudent);
		SetMinus minus = new SetMinus(union.getResult(),intersection.getResult(),12);
		writeOutput(minus, "Minus ");
		
		double socre = Calculator.calculatePoints(errorService, this.task.getScore());
		boolean x = checkNumbersOfTupel();
		generator = new ReportGenerator(minus.getResult(),errorService, socre, x);
	}
	
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Checking Result: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}
}
