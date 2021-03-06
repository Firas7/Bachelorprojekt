package de.hsh.genrelalg.comparison;

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
import de.hsh.genrelalg.report.ReportGenerator;
import de.hsh.genrelalg.score.Calculator;
import de.hsh.genrelalg.score.DeductionReader;

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
		
		if(errorService.getMistakes().size() != 0) {
			// struktureller Vergleich schl�gt fehl, dann setze die Punkte auf 0.
			generator = new ReportGenerator(errorService, 0.0);
			
		}else {
			boolean found = false;
			for(int j = 0; j < this.anwserOfStudent.getAttributes().size(); j++) {
				found = this.correctAnswer.containsAttribute(this.anwserOfStudent.getAttributes().get(j));
				if(!found) {
					attributes.add(this.anwserOfStudent.getAttributes().get(j));
					ErrorService.addError(new Discrepancy(this.anwserOfStudent.getAttributes().get(j)));
				}else {
					checkSequenceOfAttributes(this.correctAnswer.getAttributes().get(j), this.anwserOfStudent.getAttributes().get(j));
				}
				found = false;
			}
				
		
				if(errorService.getMistakes().size() != 0) {
					double socre = Calculator.calculatePoints(errorService, this.task.getScore());
					generator = new ReportGenerator(errorService,socre);
				}else {
					Union union = new Union(this.correctAnswer,this.anwserOfStudent);
					//writeOutput(union, "Union");
					Intersection intersection = new Intersection(this.correctAnswer,this.anwserOfStudent);
					//writeOutput(intersection, "Intersection");
					SetMinus minus = new SetMinus(union.getResult(),intersection.getResult(),12);
					//writeOutput(minus, "Minus ");
					
					double socre = Calculator.calculatePoints(errorService, this.task.getScore());
					// Keine Datens�tze �brig
						if(minus.getResult().getTuples().size() == 0) {
							generator = new ReportGenerator(minus.getResult(),errorService, socre);
						}else {
							// Das Ergebnis hat mehr Datens�tze 
							boolean x= checkNumbersOfTupel();
							ErrorService.addError(new ContentDeviation(minus.getResult(),x));
							socre = Calculator.calculatePoints(errorService, this.task.getScore());
							generator = new ReportGenerator(minus.getResult(),errorService,socre, x);
						}
				}	
		}
		
	}
	
	/* pr�ft die Reihenfolge die �bergebene Attribute. */
	public void checkSequenceOfAttributes(Attribute att1 , Attribute att2) {
		if(!att1.getName().toUpperCase().equals(att2.getName().toUpperCase())) {
			ErrorService.addError(new Sequence(att2));
		}
	}
	
	/* Diese Methode pr�ft, ob die korrekte Relation mehr Datens�tze oder weniger als die Relation der eingereichten L�sung hat.
	 * wenn ja: wird der Boolean-Wert x auf true gesetzt anderenfalls flase. */
	
	public boolean checkNumbersOfTupel() {
		boolean x = false;
		int tupleLeft = this.correctAnswer.getTuples().size();
		int tupleRight = this.anwserOfStudent.getTuples().size();
		
		if(tupleLeft > tupleRight) {
			x = true;
		}
		return x;
	}
	
	/* Diese Methode f�hrt den Strukturvergleich durch. */
	
	public void checkStructure() {
	
		int sizeLeft = this.correctAnswer.getAttributes().size();
		int sizeRight = this.anwserOfStudent.getAttributes().size();
		if(sizeLeft != sizeRight) {	
			// Die Spaltenanzahl stimmt nicht �berein
			ErrorService.addError(new Inequality(this.correctAnswer.getAttributes(), this.anwserOfStudent.getAttributes()));
		}
	}
		
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Checking Result: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}
}
