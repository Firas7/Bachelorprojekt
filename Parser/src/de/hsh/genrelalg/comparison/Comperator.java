package de.hsh.genrelalg.comparison;

import java.util.ArrayList;
import java.util.List;

import de.hsh.genrelalg.data.Attribute;
import de.hsh.genrelalg.data.Relation;
import de.hsh.genrelalg.errors.ErrorService;
import de.hsh.genrelalg.errors.Mistake;
import de.hsh.genrelalg.relalg.Intersection;
import de.hsh.genrelalg.relalg.RelationalAlgebra;
import de.hsh.genrelalg.relalg.SetMinus;
import de.hsh.genrelalg.relalg.Union;

public class Comperator {

	ErrorService errorService = ErrorService.getInstance();
	Printer printer ;
	Relation correctAnswer , anwserOfStudent;
	List<Attribute> attributes = new ArrayList<>();
	
	public Comperator (Relation r1 , Relation r2) {
		this.correctAnswer = r1;
		this.anwserOfStudent = r2;
		//checkColumns();
		checkLinesOfTables();
	}
	
	/*
	 * Diese Methode prüft die Zeilen beider Relationen:
	 * 1- Enthält die neu entstehende Relation keinen Datensatz, ist damit die eingereichte Lösung richtig
	 * 2- Enthält die neu entstehnde Relation mindestens einen Datensatz, ist damit die Lösung falsch. Dabei muss das Prädikat geprüft werden.
	 * 
	 * */
	public void checkLinesOfTables() {
		Union union = new Union(this.correctAnswer,this.anwserOfStudent);
		
		writeOutput(union, "Union tow tables: ");
		for(int i = 0; i < union.getFaultyAttributes().size(); i++) {
			System.out.println("attribut " + union.getFaultyAttributes().get(i).getName() + " passt nicht in der Lösung");
		}
		
		for(int i = 0; i<errorService.getMistakes().size(); i++) {
			System.out.println("Fehler Name: " + errorService.getMistakes().get(i).getName());
			System.out.println("Fehler Text: " + errorService.getMistakes().get(i).getText());
		}
		
		Intersection intersection = new Intersection(this.correctAnswer,this.anwserOfStudent);
		//writeOutput(intersection, "Intersection tow tables: ");
		SetMinus minus = new SetMinus(union.getResult(),intersection.getResult(),12);
		//writeOutput(minus, "Minus tow tables: ");
		if(minus.getResult().getTuples().size() == 0) {
			System.out.println("Result is correct");
		}else {
			// Error --> check predicate.
			System.out.println("Result is not correct");
		}
		
	}
		
	
	/*
	 * TODO Zeilen und Spalten beider Relation vergleichen
	 * 
	 * */
	public void checkColumns() {
		int sizeLeft = this.correctAnswer.getAttributes().size();
		int sizeRight = this.anwserOfStudent.getAttributes().size();
		if(sizeLeft == sizeRight) {
			for(int i = 0; i < this.anwserOfStudent.getAttributes().size(); i++) {
				boolean found = false;
				for(int j = 0; j < this.correctAnswer.getAttributes().size(); j++) {
					System.out.println("I: " +i);
					System.out.println("J: " + j);
					if(this.correctAnswer.getAttributes().get(i).getName().toUpperCase().equals(this.anwserOfStudent.getAttributes().get(j).getName().toUpperCase())) {
						System.out.println("Attribut gefunden: " + this.correctAnswer.getAttributes().get(i).getName());
						found = true;
					}
				}
				if(!found) {
				attributes.add(this.anwserOfStudent.getAttributes().get(i));
				}
			}
		}else {
			// Error dass Attribute nicht miteinander übereinstimmen.
			System.out.println("Anzahl der Spalten beider Relationen ist ungleich!. ");
		}
	}
	
	public static void writeOutput(RelationalAlgebra expr, String task) {
		System.out.println("Aufgabe: " + task + "\n");		
		System.out.println(expr.toText("", false));
		System.out.println("\n");
		System.out.println(expr.toText("", true));
	}
}
